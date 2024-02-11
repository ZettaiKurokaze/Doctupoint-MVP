package com.rektstudios.doctupointmvp.domain.model

data class Doctor(
	val name: String,
	val slots: List<DoctorSlot>,
	val id: Int
)
