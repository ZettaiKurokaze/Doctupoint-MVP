package com.rektstudios.doctupointmvp.domain.repository

import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.domain.model.PatientSlot
import com.rektstudios.doctupointmvp.util.Resource
import kotlinx.coroutines.flow.Flow

interface DoctupointRepository {
	suspend fun getDoctors(
		fetchFromRemote: Boolean,
		doctor: Doctor? = null
	): Flow<Resource<List<Doctor>>>

	suspend fun updateDoctors(
		doctors: List<Doctor>
	)
	suspend fun addDoctorSlot(
		doctor: Doctor,
		slot: DoctorSlot
	)

	suspend fun deleteDoctors(
		doctors: List<Doctor>
	)

	suspend fun getPatients(
		fetchFromRemote: Boolean,
		patient: Patient? = null
	): Flow<Resource<List<Patient>>>


	suspend fun updatePatients(
		patients: List<Patient>
	)

	suspend fun addPatientSlot(
		patient: Patient,
		slot: PatientSlot
	)

	suspend fun deletePatients(
		doctors: List<Patient>
	)
}