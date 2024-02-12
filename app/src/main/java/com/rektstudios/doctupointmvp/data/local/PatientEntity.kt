package com.rektstudios.doctupointmvp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PatientEntity(
	val name: String,
	@PrimaryKey(autoGenerate = true) val id: Int? = null
)
