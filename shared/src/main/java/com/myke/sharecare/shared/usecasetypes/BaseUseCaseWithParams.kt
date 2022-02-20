package com.myke.sharecare.shared.usecasetypes

interface BaseUseCaseWithParams<P, R> {
    suspend fun run(params : P) : R
}