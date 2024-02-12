package com.rektstudios.doctupointmvp.data.repository

import com.rektstudios.doctupointmvp.data.local.DoctupointDatabase
import com.rektstudios.doctupointmvp.data.remote.DoctupointApi
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.domain.model.PatientSlot
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
	private val dao = db.dao
	override suspend fun getDoctors(
		fetchFromRemote: Boolean,
		doctor: Doctor?
	): Flow<Resource<List<Doctor>>> {
		TODO("Not yet implemented")
	}

	override suspend fun updateDoctors(doctors: List<Doctor>) {
		TODO("Not yet implemented")
	}

	override suspend fun addDoctorSlot(doctor: Doctor, slot: DoctorSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun deleteDoctors(doctors: List<Doctor>) {
		TODO("Not yet implemented")
	}

	override suspend fun getPatients(
		fetchFromRemote: Boolean,
		patient: Patient?
	): Flow<Resource<List<Patient>>> {
		TODO("Not yet implemented")
	}

	override suspend fun updatePatients(patients: List<Patient>) {
		TODO("Not yet implemented")
	}

	override suspend fun addPatientSlot(patient: Patient, slot: PatientSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun deletePatients(doctors: List<Patient>) {
		TODO("Not yet implemented")
	}

}