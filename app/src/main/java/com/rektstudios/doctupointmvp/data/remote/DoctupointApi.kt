package com.rektstudios.doctupointmvp.data.remote

import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.ktx.Firebase
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient

interface DoctupointApi {
	suspend fun getAllDoctors(): Any
	suspend fun getDoctor(doctor: Doctor): Any
	suspend fun getDoctorSlot(doctor: Doctor, doctorSlot: DoctorSlot): Any
	suspend fun getAllPatients(): Any
	suspend fun getPatient(patient: Patient): Any

	suspend fun addDoctor(doctor: Doctor)
	suspend fun addPatient(patient: Patient)
	suspend fun updateDoctor(doctor: Doctor)
	suspend fun updatePatient(patient: Patient)
	suspend fun addDoctorSlot(doctor: Doctor, doctorSlot: DoctorSlot)
	suspend fun addPatientSlot(patient: Patient, doctorSlot: DoctorSlot)
	suspend fun updateDoctorSlot(doctorSlot: DoctorSlot)
	suspend fun updatePatientSlot(patient: Patient, doctorSlot: DoctorSlot)
	suspend fun deleteDoctor(doctor: Doctor)
	suspend fun deletePatient(patient: Patient)
	suspend fun deleteDoctorSlot(doctor: Doctor, doctorSlot: DoctorSlot)
	suspend fun deletePatientSlot(patient: Patient, doctorSlot: DoctorSlot)
}