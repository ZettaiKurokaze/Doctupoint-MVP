package com.rektstudios.doctupointmvp.domain.repository

import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.util.Resource
import kotlinx.coroutines.flow.Flow

interface DoctupointRepository {
	suspend fun getDoctors(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Doctor>>>

	suspend fun updateDoctors(
		doctors: List<Doctor>
	)

	suspend fun getPatients(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Patient>>>


	suspend fun updatePatients(
		patients: List<Patient>
	)
}