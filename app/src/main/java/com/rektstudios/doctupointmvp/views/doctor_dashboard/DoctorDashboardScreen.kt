package com.rektstudios.doctupointmvp.views.doctor_dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot

@Composable
fun DoctorDashboardScreen(
	navController: NavHostController,
	viewModel: DoctorDashboardViewModel = hiltViewModel()
) {
	val swipeRefreshState = rememberSwipeRefreshState(
		isRefreshing = viewModel.state.isRefreshing
	)
	val state = viewModel.state
	if(state.error == null) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			state.doctor?.let { doctor ->
				Text(
					text = doctor.name,
					fontWeight = FontWeight.Bold,
					fontSize = 18.sp,
					overflow = TextOverflow.Ellipsis,
					modifier = Modifier.fillMaxWidth()
				)
				Spacer(modifier = Modifier.height(8.dp))
				SwipeRefresh(
					state = swipeRefreshState,
					onRefresh = {
						viewModel.onEvent(DoctorDashboardEvent.Refresh)
					}
				) {
					LazyColumn(
						modifier = Modifier.fillMaxSize()
					) {
						items(state.doctor.slots.size) { i ->
							val slot = state.doctor.slots[i]
							DoctorSlotItem(
								doctorSlot = slot,
								{ totalSlots: Int, doctorSlot: DoctorSlot -> viewModel
									.onTotalSlotsChange(totalSlots,doctorSlot) },
								{ slotAvailability: Boolean, doctorSlot: DoctorSlot -> viewModel
									.onSlotAvailabilityChange(slotAvailability, doctorSlot)},
								{ doctorSlot: DoctorSlot -> viewModel.onSlotDelete(doctorSlot)},
								modifier = Modifier
									.fillMaxWidth()
									.padding(16.dp)
							)
							if (i < state.doctor.slots.size) {
								Divider(
									modifier = Modifier.padding(
										horizontal = 16.dp
									)
								)
							}
						}
					}
				}
				Spacer(modifier = Modifier.height(8.dp))
				Button(onClick = { viewModel.onEvent(DoctorDashboardEvent.OnDoctorSave) }) {
					Text(text="Save")
				}
			}
		}
	}
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		if(state.isLoading) {
			CircularProgressIndicator()
		} else if(state.error != null) {
			Text(
				text = state.error,
				color = MaterialTheme.colorScheme.error
			)
		}
	}
}