package com.rektstudios.doctupointmvp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
	foreignKeys = [
		ForeignKey(
		entity = DoctorEntity::class,
		childColumns = ["doctorId"],
		parentColumns = ["id"],
		onDelete = ForeignKey.CASCADE),
	])
data class DoctorSlotEntity(
	val doctorId: Int,
	val timeSlot: String,
	val totalSlots: Int,
	val availableSlots: Int,
	val slotStatus: Int,
	@PrimaryKey val id: Int? = null
)
