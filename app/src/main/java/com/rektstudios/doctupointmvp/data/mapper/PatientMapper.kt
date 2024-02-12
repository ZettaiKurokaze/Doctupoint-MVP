package com.rektstudios.doctupointmvp.data.mapper

import com.rektstudios.doctupointmvp.data.local.PatientEntity
import com.rektstudios.doctupointmvp.data.local.PatientSlotEntity
import com.rektstudios.doctupointmvp.domain.model.Patient
import com.rektstudios.doctupointmvp.domain.model.PatientSlot

fun PatientEntity.toPatient(slots: List<PatientSlot>): Patient{
	return Patient(
		name = name,
		slots = slots,
		id = id!!
	)
}

fun Patient.toPatientEntity(): PatientEntity{
	return PatientEntity(
		name = name,
		id = id
	)
}
fun Patient.toNewPatientEntity(): PatientEntity{
	return PatientEntity(
		name = name
	)
}
fun PatientSlot.toPatientSlotEntity(patient: Patient): PatientSlotEntity{
	return PatientSlotEntity(
		patientId = patient.id,
		slotId = slotId,
		id = id
	)
}

fun PatientSlot.toNewPatientSlotEntity(patient: Patient): PatientSlotEntity{
	return PatientSlotEntity(
		patientId = patient.id,
		slotId = slotId
	)
}

fun PatientSlotEntity.toPatientSlot(): PatientSlot{
	return PatientSlot(
		id = id!!,
		slotId = slotId
	)
}
