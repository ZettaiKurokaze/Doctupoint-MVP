package com.rektstudios.doctupointmvp.domain.repository

import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.util.Resource
import kotlinx.coroutines.flow.Flow

interface DoctupointRepository {
	suspend fun getDoctors(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Doctor>>>

	suspend fun getDoctorSlots(
		symbol: String
	): Resource<List<DoctorSlot>>

	suspend fun getPatients(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Doctor>>>

	suspend fun getPatientSlots(
		symbol: String
	): Resource<List<DoctorSlot>>
}