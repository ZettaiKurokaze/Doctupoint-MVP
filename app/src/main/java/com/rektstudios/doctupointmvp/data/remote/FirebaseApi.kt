package com.rektstudios.doctupointmvp.data.remote

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient

class FirebaseApi:DoctupointApi {
	private val db=Firebase.firestore
	private val doctorCollection=db.collection("Doctors")
	private val patientCollection=db.collection("Patients")
	override suspend fun getAllDoctors(): Any {
		TODO("Not yet implemented")
	}

	override suspend fun getDoctor(doctor: Doctor): Any {
		TODO("Not yet implemented")
	}

	override suspend fun getDoctorSlot(doctor: Doctor, doctorSlot: DoctorSlot): Any {
		TODO("Not yet implemented")
	}

	override suspend fun getAllPatients(): Any {
		TODO("Not yet implemented")
	}

	override suspend fun getPatient(patient: Patient): Any {
		TODO("Not yet implemented")
	}

	override suspend fun addDoctor(doctor: Doctor) {
		TODO("Not yet implemented")
	}

	override suspend fun addPatient(patient: Patient) {
		TODO("Not yet implemented")
	}

	override suspend fun updateDoctor(doctor: Doctor) {
		TODO("Not yet implemented")
	}

	override suspend fun updatePatient(patient: Patient) {
		TODO("Not yet implemented")
	}

	override suspend fun addDoctorSlot(doctor: Doctor, doctorSlot: DoctorSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun addPatientSlot(patient: Patient, doctorSlot: DoctorSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun updateDoctorSlot(doctorSlot: DoctorSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun updatePatientSlot(patient: Patient, doctorSlot: DoctorSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun deleteDoctor(doctor: Doctor) {
		TODO("Not yet implemented")
	}

	override suspend fun deletePatient(patient: Patient) {
		TODO("Not yet implemented")
	}

	override suspend fun deleteDoctorSlot(doctor: Doctor, doctorSlot: DoctorSlot) {
		TODO("Not yet implemented")
	}

	override suspend fun deletePatientSlot(patient: Patient, doctorSlot: DoctorSlot) {
		TODO("Not yet implemented")
	}
}