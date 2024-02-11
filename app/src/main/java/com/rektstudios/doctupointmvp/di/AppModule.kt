package com.rektstudios.doctupointmvp.di

import android.app.Application
import androidx.room.Room
import com.rektstudios.doctupointmvp.data.local.DoctupointDatabase
import com.rektstudios.doctupointmvp.data.remote.DoctupointApi
import com.rektstudios.doctupointmvp.data.remote.FirebaseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun provideStockDatabase(app: Application): DoctupointDatabase {
		return Room.databaseBuilder(
			app,
			DoctupointDatabase::class.java,
			"doctupointdb.db"
		).build()
	}

	@Provides
	@Singleton
	fun provideDoctupointApi(): DoctupointApi {
		return FirebaseApi()
	}
}