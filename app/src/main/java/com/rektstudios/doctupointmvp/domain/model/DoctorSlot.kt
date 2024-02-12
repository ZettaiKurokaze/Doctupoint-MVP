package com.rektstudios.doctupointmvp.domain.model

data class DoctorSlot(
	val timeSlot: String,
	val totalSlots: Int,
	val slotAvailability: Boolean,
	val id: Int
)
