package com.aywaorla2a.di

import com.aywaorla2a.home.YesOrNoViewModel
import com.aywaorla2a.repository.YesOrNoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    fun providesYesOrNoViewModel(yesOrNoRepository: YesOrNoRepository): YesOrNoViewModel {
        return YesOrNoViewModel(yesOrNoRepository = yesOrNoRepository)
    }

}