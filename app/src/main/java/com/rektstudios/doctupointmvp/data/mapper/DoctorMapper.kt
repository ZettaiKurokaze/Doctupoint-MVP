package com.rektstudios.doctupointmvp.data.mapper

import com.rektstudios.doctupointmvp.data.local.DoctorEntity
import com.rektstudios.doctupointmvp.data.local.DoctorSlotEntity
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.model.Patient

fun DoctorEntity.toDoctor(slots: List<DoctorSlot> = emptyList<DoctorSlot>()): Doctor {
	return Doctor(
		name = name,
		id = id!!,
		slots = slots
	)
}

fun Doctor.toDoctorEntity(): DoctorEntity {
	return DoctorEntity(
		name = name,
		id = id
	)
}
fun DoctorSlotEntity.toDoctorSlot(patients: List<Patient> = emptyList<Patient>()): DoctorSlot{
	return DoctorSlot(
		timeSlot = timeSlot,
		totalSlots = totalSlots,
		availableSlots = availableSlots,
		slotStatus = slotStatus,
		patients = patients,
		id = id!!
	)
}

fun DoctorSlot.toDoctorSlotEntity(doctor: Doctor): DoctorSlotEntity{
	return DoctorSlotEntity(
		timeSlot = timeSlot,
		totalSlots = totalSlots,
		availableSlots = availableSlots,
		slotStatus = slotStatus,
		doctorId = doctor.id,
		id = id
	)
}