package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.get
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.ahmed.m.hassaan.core.activity.BaseActivityBinding
import com.ahmed.m.hassaan.core.callbacks.OnItemClickedWithPosition
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.nasaimages.R
import com.ahmed.m.hassaan.nasaimages.app.App
import com.ahmed.m.hassaan.nasaimages.databinding.ActivityMainBinding
import com.ahmed.m.hassaan.nasaimages.presentation.custom_view.PaginationCallbacks
import com.ahmed.m.hassaan.nasaimages.presentation.details.ActivityDetails
import com.ahmed.m.hassaan.nasaimages.utils.ext.RecViewExt.setupWithAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val nasaAdapter = NasaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.recViewImages.setupWithAdapter(
            nasaAdapter,
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        )

        with(viewModel) {
            images.onEach { onEachResult(it) }
                .launchIn(this@MainActivity.lifecycleScope)

            paginatedImages.onEach {
                nasaAdapter.updateListWithPagination(ArrayList(it))
                binding.progress.isInvisible = true
            }
                .launchIn(this@MainActivity.lifecycleScope)


        }

        events()

    }

    private fun events() {
        binding.recViewImages.setPaginationCallbacks(object : PaginationCallbacks {
            override fun loadData() {
                viewModel.paginate()
            }

            override fun showPaginationProgress() {
                binding.progress.isVisible = true
            }

        })

        nasaAdapter.listener = object : OnItemClickedWithPosition<DomainNasaImage> {
            override fun onItemClicked(position: Int, item: DomainNasaImage) {

                val intent = Intent(this@MainActivity, ActivityDetails::class.java)
                val options = ActivityOptions
                    .makeSceneTransitionAnimation(
                        this@MainActivity,
                        binding.recViewImages[position],
                        "trans"
                    )

                startActivity(
                    intent.also {
                        it.putExtra("item", item)
                    }, options.toBundle()
                )
                Log.d(App.APP_TAG, "MainActivity - onItemClicked:  started $position, $item")
            }
        }
    }


    private fun onEachResult(photos: List<DomainNasaImage>) {
        Log.d(App.APP_TAG, "MainActivity - onEachResult:  data emiited to Flow $photos ")
        nasaAdapter.updateList(ArrayList(photos))
    }

    override fun getLayoutId() = R.layout.activity_main
}