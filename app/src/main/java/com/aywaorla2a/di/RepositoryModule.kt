package com.aywaorla2a.di

import com.aywaorla2a.network.remote.AppService
import com.aywaorla2a.repository.YesOrNoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun providesYesOrNoRepository(appService: AppService): YesOrNoRepository {
        return YesOrNoRepository(appService = appService)
    }
}