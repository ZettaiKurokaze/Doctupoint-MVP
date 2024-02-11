package com.rektstudios.doctupointmvp.data.mapper

import com.rektstudios.doctupointmvp.data.local.PatientEntity
import com.rektstudios.doctupointmvp.data.local.PatientSlotEntity
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient

fun PatientEntity.toPatient(): Patient{
	return Patient(
		name = name,
		id = id!!
	)
}

fun Patient.toPatientEntity(): PatientEntity{
	return PatientEntity(
		name = name,
		id = id
	)
}
fun DoctorSlot.toPatientSlotEntity(patient: Patient): PatientSlotEntity{
	return PatientSlotEntity(
		patientId = patient.id,
		slotId = id
	)
}