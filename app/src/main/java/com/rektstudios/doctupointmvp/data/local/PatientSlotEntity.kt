package com.rektstudios.doctupointmvp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
	foreignKeys = [ForeignKey(
	entity = DoctorSlotEntity::class,
	childColumns = ["slotId"],
	parentColumns = ["id"],
	onDelete = ForeignKey.CASCADE),
	ForeignKey(
	entity = PatientEntity::class,
	childColumns = ["patientId"],
	parentColumns = ["id"],
	onDelete = ForeignKey.CASCADE),
	])
data class PatientSlotEntity(
	val patientId: Int,
	val slotId: Int,
	@PrimaryKey val id: Int? = null
)