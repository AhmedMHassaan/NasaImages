package com.ahmed.m.hassaan.data.mapper

import com.ahmed.m.hassaan.data.model.ImagesResponseCollection
import com.ahmed.m.hassaan.data.model.Items
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import javax.inject.Inject

class NasaItemMapper @Inject constructor() : Mapper<Items, DomainNasaImage> {
    override fun mapDataToDomain(data: Items): DomainNasaImage {
        return DomainNasaImage(
            data.data[0].title,
            data.data[0].nasa_id,
            data.data[0].center,
            data.data[0].keywords,
            data.data[0].date_created,
            data.data[0].description_508,
            data.data[0].secondary_creator,
            data.data[0].description,
            data.links[0].imageLink,
        )
    }

    override fun mapDomainToData(data: DomainNasaImage): Items {
        TODO("Not yet implemented")
    }


}