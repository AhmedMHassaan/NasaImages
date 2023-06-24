package com.ahmed.m.hassaan.nasaimages.presentation.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.ahmed.m.hassaan.nasaimages.app.App;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

public class PaginatedRecyclerView extends ShimmerRecyclerView {


    // for pagination
    private PaginationCallbacks callbacks;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    boolean startedToFetchData = false;


    public PaginatedRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public PaginatedRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PaginatedRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {


        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) { //check for scroll down
                    if (getLayoutManager() == null) {
                        Log.d(App.APP_TAG, "PaginatedRecyclerView - onScrolled:  layoutmanager is null");
                        return;
                    }

                    visibleItemCount = getLayoutManager().getChildCount();
                    totalItemCount = getLayoutManager().getItemCount();

//                    Log.d(App.APP_TAG, "PaginatedRecyclerView - onScrolled:  visibles count = " + visibleItemCount + " and total is " + totalItemCount);
                    if (getLayoutManager() instanceof LinearLayoutManager)
                        pastVisiblesItems = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
                    else if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
                        int[] firstVisibleItems = null;
                        firstVisibleItems = ((StaggeredGridLayoutManager) getLayoutManager()).findFirstVisibleItemPositions(firstVisibleItems);
                        if (firstVisibleItems != null && firstVisibleItems.length > 0)
                            pastVisiblesItems = firstVisibleItems[0];

                    }


                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            Log.v(App.APP_TAG, "From CustomRecView.Last Item Wow !");
//                            msg("Do Pagination Here");
                            if (!startedToFetchData) {
                                if (callbacks != null) {
                                    callbacks.loadData();
                                    callbacks.showPaginationProgress();
                                } ;
                            }
                            loading = true;
                        }
                    }
                }

            }
        });
    }


    public void setPaginationCallbacks(PaginationCallbacks callbacks) {
        this.callbacks = callbacks;
    }


}


