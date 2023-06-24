package com.ahmed.m.hassaan.data.mapper

import com.ahmed.m.hassaan.data.model.NasaItemLocal
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import javax.inject.Inject

class LocalNasaItemMapper @Inject constructor() : Mapper<NasaItemLocal, DomainNasaImage> {

    override fun mapDataToDomain(data: NasaItemLocal): DomainNasaImage {
        return DomainNasaImage(
            data.title,
            data.nasa_id,
            data.center,
            data.keywords,
            data.date_created,
            data.description_508,
            data.secondary_creator,
            data.description,
            data.imageLink,
        )
    }

    override fun mapDomainToData(data: DomainNasaImage): NasaItemLocal {
        return NasaItemLocal(
            data.title,
            data.nasa_id,
            data.center,
            data.keywords,
            data.date_created,
            data.description_508,
            data.secondary_creator,
            data.description,
            data.imageLink
        )
    }

}