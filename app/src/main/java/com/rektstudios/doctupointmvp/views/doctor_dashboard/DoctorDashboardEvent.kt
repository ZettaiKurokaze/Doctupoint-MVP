package com.rektstudios.doctupointmvp.views.doctor_dashboard

import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot

sealed class DoctorDashboardEvent {
	data object Refresh: DoctorDashboardEvent()
	data object OnDoctorSave : DoctorDashboardEvent()
}