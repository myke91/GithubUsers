package com.myke.sharecare.browsr.base.usecasetypes

interface BaseUseCaseWithOutParams<R> {
    suspend fun run() : R
}