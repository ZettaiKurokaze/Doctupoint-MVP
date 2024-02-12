package com.rektstudios.doctupointmvp.data.mapper

import com.rektstudios.doctupointmvp.data.local.DoctorEntity
import com.rektstudios.doctupointmvp.data.local.DoctorSlotEntity
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot

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

fun Doctor.toNewDoctorEntity(): DoctorEntity {
	return DoctorEntity(
		name = name,
	)
}

fun DoctorSlotEntity.toDoctorSlot(): DoctorSlot{
	return DoctorSlot(
		timeSlot = timeSlot,
		totalSlots = totalSlots,
		slotAvailability = slotAvailability,
		id = id!!
	)
}

fun DoctorSlot.toDoctorSlotEntity(doctor: Doctor): DoctorSlotEntity{
	return DoctorSlotEntity(
		timeSlot = timeSlot,
		totalSlots = totalSlots,
		slotAvailability = slotAvailability,
		doctorId = doctor.id,
		id = id
	)
}

fun DoctorSlot.toNewDoctorSlotEntity(doctor: Doctor): DoctorSlotEntity{
	return DoctorSlotEntity(
		timeSlot = timeSlot,
		totalSlots = totalSlots,
		slotAvailability = slotAvailability,
		doctorId = doctor.id,
	)
}