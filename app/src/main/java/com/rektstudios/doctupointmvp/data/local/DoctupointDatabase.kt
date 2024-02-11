package com.rektstudios.doctupointmvp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
	entities = [DoctorEntity::class, DoctorSlotEntity::class, PatientEntity::class,
		PatientSlotEntity::class],
	version = 1
)
abstract class DoctupointDatabase: RoomDatabase() {
	abstract val dao: DoctupointDao
}