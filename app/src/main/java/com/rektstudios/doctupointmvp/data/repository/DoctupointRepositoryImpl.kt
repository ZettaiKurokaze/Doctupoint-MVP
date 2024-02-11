package com.rektstudios.doctupointmvp.data.repository

import com.rektstudios.doctupointmvp.data.local.DoctupointDatabase
import com.rektstudios.doctupointmvp.data.remote.DoctupointApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DoctupointRepositoryImpl @Inject constructor(
	private val api: DoctupointApi,
	private val db: DoctupointDatabase
){
}