package com.rektstudios.doctupointmvp.domain.model

data class DoctorSlot(
	val timeSlot: String,
	val totalSlots: Int,
	val availableSlots: Int,
	val slotStatus: Int,
	val patients: List<Patient>,
	val id: Int
)
