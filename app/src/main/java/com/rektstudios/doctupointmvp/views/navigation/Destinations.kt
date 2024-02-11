package com.rektstudios.doctupointmvp.views.navigation

interface Destinations {
	val route: String
}

object DoctorDashboard : Destinations {
	override val route = "DoctorDashboard"
}

object Onboarding : Destinations {
	override val route = "Onboarding"
}

object PatientDashboard : Destinations {
	override val route = "PatientDashboard"
}