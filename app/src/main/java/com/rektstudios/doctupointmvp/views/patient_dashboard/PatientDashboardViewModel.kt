package com.rektstudios.doctupointmvp.views.patient_dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rektstudios.doctupointmvp.domain.repository.DoctupointRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PatientDashboardViewModel @Inject constructor(
private val savedStateHandle: SavedStateHandle,
private val repository: DoctupointRepository
): ViewModel() {
}