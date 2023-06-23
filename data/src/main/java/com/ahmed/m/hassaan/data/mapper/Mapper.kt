package com.ahmed.m.hassaan.data.mapper

interface Mapper<I,O> {

    fun mapDataToDomain(data:I):O

    fun mapDomainToData(data: O):I
}