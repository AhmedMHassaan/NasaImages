package com.ahmed.m.hassaan.data.remote.throwables

import com.ahmed.m.hassaan.data.model.ApiError

data class ApiThrowable(
    val body: ApiError,
    val code: Int
) : Throwable()
