package com.rektstudios.doctupointmvp.data.remote

import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.Patient

interface DoctupointApi {
	suspend fun getDoctor(doctor: Doctor? = null): Any
	suspend fun getPatient(patient: Patient? = null): Any
	suspend fun updateDoctor(doctor: Doctor)
	suspend fun updatePatient(patient: Patient)
	suspend fun deleteDoctor(doctor: Doctor)
	suspend fun deletePatient(patient: Patient)
}