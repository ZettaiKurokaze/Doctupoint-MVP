package com.rektstudios.doctupointmvp.views.doctor_dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.DoctorSlot
import com.rektstudios.doctupointmvp.domain.repository.DoctupointRepository
import com.rektstudios.doctupointmvp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoctorDashboardViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val repository: DoctupointRepository
): ViewModel() {
	var state by mutableStateOf(DoctorDashboardState())
	private var saveJob: Job? = null
	init {
		getDoctors()
	}
	fun onEvent(event: DoctorDashboardEvent) {
		when(event) {
			is DoctorDashboardEvent.Refresh -> {
				getDoctors(fetchFromRemote = true)
			}
			is DoctorDashboardEvent.OnDoctorSave -> {
				saveJob?.cancel()
				saveJob = viewModelScope.launch {
					delay(500L)
					updateDoctor(state.doctor!!)
				}
			}
		}
	}
	private fun updateDoctor(doctor: Doctor){
		viewModelScope.launch {
			repository
				.updateDoctors(listOf(doctor))
		}
	}


	private fun getDoctors( fetchFromRemote: Boolean = false ) {
		viewModelScope.launch {
			val doctor = savedStateHandle.get<Doctor>("doctor") ?: return@launch
			repository
				.getDoctors(fetchFromRemote,doctor)
				.collect { result ->
					when(result) {
						is Resource.Success -> {
							result.data?.let { it ->
								state = state.copy(
									doctor = it.first()
								)
							}
						}
						is Resource.Error -> Unit
						is Resource.Loading -> {
							state = state.copy(isLoading = result.isLoading)
						}
					}
				}
		}
	}

	fun onTotalSlotsChange(totalSlots: Int, doctorSlot: DoctorSlot){
		val filteredSlots = state.doctor!!.slots.map { if(it.id==doctorSlot.id) DoctorSlot(it
			.timeSlot, totalSlots, it.slotAvailability, it.id) }
		state = state.copy (
			doctor = Doctor(
				name = state.doctor!!.name,
				slots = filteredSlots as List<DoctorSlot>,
				id = state.doctor!!.id
			)
		)
	}
	fun onSlotAvailabilityChange(slotAvailability: Boolean, doctorSlot: DoctorSlot){
		val filteredSlots = state.doctor!!.slots.map { if(it.id==doctorSlot.id) DoctorSlot(it
			.timeSlot, it.totalSlots, slotAvailability, it.id) }
		state = state.copy (
			doctor = Doctor(
				name = state.doctor!!.name,
				slots = filteredSlots as List<DoctorSlot>,
				id = state.doctor!!.id
			)
		)
	}
	fun onSlotDelete(doctorSlot: DoctorSlot){
		val filteredSlots = state.doctor!!.slots.filter { it.id!=doctorSlot.id }
		state = state.copy (
			doctor = Doctor(
				name = state.doctor!!.name,
				slots = filteredSlots,
				id = state.doctor!!.id
			)
		)
	}
}