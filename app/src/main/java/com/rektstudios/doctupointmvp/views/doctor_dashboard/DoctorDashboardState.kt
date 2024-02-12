package com.rektstudios.doctupointmvp.views.doctor_dashboard

import com.rektstudios.doctupointmvp.domain.model.Doctor

data class DoctorDashboardState(
	val doctor: Doctor? = null,
	val isLoading: Boolean = false,
	val error: String? = null
)
