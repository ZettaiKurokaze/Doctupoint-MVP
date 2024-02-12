package com.rektstudios.doctupointmvp.data.repository

import com.rektstudios.doctupointmvp.data.local.DoctupointDatabase
import com.rektstudios.doctupointmvp.data.remote.DoctupointApi
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.domain.repository.DoctupointRepository
import com.rektstudios.doctupointmvp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DoctupointRepositoryImpl @Inject constructor(
	private val api: DoctupointApi,
	private val db: DoctupointDatabase
): DoctupointRepository {
	override suspend fun getDoctors(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Doctor>>> {
		TODO("Not yet implemented")
	}

	override suspend fun updateDoctors(doctors: List<Doctor>) {
		TODO("Not yet implemented")
	}

	override suspend fun getPatients(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Patient>>> {
		TODO("Not yet implemented")
	}

	override suspend fun updatePatients(patients: List<Patient>) {
		TODO("Not yet implemented")
	}

}