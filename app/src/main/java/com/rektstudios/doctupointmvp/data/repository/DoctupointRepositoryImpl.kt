package com.rektstudios.doctupointmvp.data.repository

import com.rektstudios.doctupointmvp.data.local.DoctupointDatabase
import com.rektstudios.doctupointmvp.data.mapper.toDoctor
import com.rektstudios.doctupointmvp.data.mapper.toDoctorEntity
import com.rektstudios.doctupointmvp.data.mapper.toDoctorSlot
import com.rektstudios.doctupointmvp.data.mapper.toDoctorSlotEntity
import com.rektstudios.doctupointmvp.data.mapper.toPatient
import com.rektstudios.doctupointmvp.data.mapper.toPatientEntity
import com.rektstudios.doctupointmvp.data.mapper.toPatientSlot
import com.rektstudios.doctupointmvp.data.mapper.toPatientSlotEntity
import com.rektstudios.doctupointmvp.data.remote.DoctupointApi
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.domain.model.PatientSlot
import com.rektstudios.doctupointmvp.domain.repository.DoctupointRepository
import com.rektstudios.doctupointmvp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
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
		return flow {
			emit(Resource.Loading(true))

			if(doctor!=null)
			{
				val doctorFetched = dao.getDoctor(doctor.id)
				emit(Resource.Success(
					data = listOf(doctorFetched.toDoctor(dao.getDoctorSlots(doctor.id).map { it
						.toDoctorSlot() }))
				))
			}
			else {
				val doctors = dao.getDoctors()
				emit(Resource.Success(
					data = doctors.map{ it1 ->
						val slots = it1.id?.let {
							dao.getDoctorSlots(it).map { it2 -> it2
								.toDoctorSlot() }
						}
						it1.toDoctor(slots!!)}
				))
			}

			val remoteListings = try {
				api.getDoctor() as List<Doctor>
			} catch(e: Exception) {
				e.printStackTrace()
				emit(Resource.Error("Couldn't load data"))
				null
			}

			remoteListings?.let { doctors ->
				dao.clearDoctors()
				dao.insertDoctors(
					doctors.map {
						for (slot in it.slots){
							dao.insertDoctorSlot(slot.toDoctorSlotEntity(it))
						}
						it.toDoctorEntity()
					}
				)
				if(doctor!=null) {
					val doctorFetched = dao.getDoctor(doctor.id)
					emit(Resource.Success(
						data = listOf(doctorFetched.toDoctor(dao.getDoctorSlots(doctor.id).map { it
							.toDoctorSlot() }))
					))
				}
				else{
					emit(Resource.Success(
						data = dao
							.getDoctors()
							.map{ it1 ->
								val slots = it1.id?.let {
									dao.getDoctorSlots(it).map { it2 -> it2
										.toDoctorSlot() }
								}
								it1.toDoctor(slots!!)}
					))
				}
				emit(Resource.Loading(false))
			}
		}
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
		return flow {
			emit(Resource.Loading(true))

			if(patient!=null)
			{
				val patientFetched = dao.getPatient(patient.id)
				emit(Resource.Success(
					data = listOf(patientFetched.toPatient(dao.getPatientSlots(patient.id).map { it
						.toPatientSlot() }))
				))
			}
			else {
				val patients = dao.getPatients()
				emit(Resource.Success(
					data = patients.map{it.toPatient()}
				))
			}

			val remoteListings = try {
				api.getPatient() as List<Patient>
			} catch(e: Exception) {
				e.printStackTrace()
				emit(Resource.Error("Couldn't load data"))
				null
			}

			remoteListings?.let { patients ->
				dao.clearPatients()
				dao.insertPatients(
					patients.map {
						for (slot in it.slots){
							dao.insertPatientSlot(slot.toPatientSlotEntity(it))
						}
						it.toPatientEntity()
					}
				)
				if(patient!=null) {
					val patientFetched = dao.getPatient(patient.id)
					emit(Resource.Success(
						data = listOf(patientFetched.toPatient())
					))
				}
				else{
					emit(Resource.Success(
						data = dao
							.getPatients()
							.map { it.toPatient() }
					))
				}
				emit(Resource.Loading(false))
			}
		}
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