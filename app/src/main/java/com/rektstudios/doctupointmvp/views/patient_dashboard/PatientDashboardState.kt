package com.rektstudios.doctupointmvp.views.patient_dashboard

import com.rektstudios.doctupointmvp.domain.model.Patient


data class PatientDashboardState(
	val patient: Patient? = null,
	val isLoading: Boolean = false,
	val error: String? = null
)
