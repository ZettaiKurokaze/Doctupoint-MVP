package com.rektstudios.doctupointmvp.views.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rektstudios.doctupointmvp.views.doctor_dashboard.DoctorDashboardScreen
import com.rektstudios.doctupointmvp.views.onboarding.OnboardingScreen

@Composable
fun NavigationComposable(){
	val navController = rememberNavController()
//	val firstName = sharedPreferences.getString("firstName", "")
	val firstName = "test"
	NavHost(navController = navController, startDestination = DoctorDashboard.route) {
		composable(DoctorDashboard.route) {
			DoctorDashboardScreen(navController)
		}
		composable(Onboarding.route) {
			OnboardingScreen(navController)
		}
//		composable(Profile.route) {
//			Profile(navController, sharedPreferences)
//		}
	}
}