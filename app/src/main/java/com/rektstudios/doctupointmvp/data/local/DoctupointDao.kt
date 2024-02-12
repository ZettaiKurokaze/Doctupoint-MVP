package com.rektstudios.doctupointmvp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DoctupointDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertDoctors(
		doctorEntities: List<DoctorEntity>
	)
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertPatients(
		patientEntities: List<PatientEntity>
	)
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertDoctorSlots(
		doctorSlotEntities: List<DoctorSlotEntity>
	)
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertPatientSlots(
		patientSlotEntities: List<PatientSlotEntity>
	)

	@Query("DELETE FROM doctorentity WHERE id = (:id)")
	suspend fun deleteDoctor(id: Int)

	@Query("DELETE FROM doctorslotentity WHERE id = (:id)")
	suspend fun deleteDoctorSlot(id: Int)

	@Query("DELETE FROM patiententity WHERE id = (:id)")
	suspend fun deletePatient(id: Int)

	@Query("DELETE FROM patientslotentity WHERE id = (:id)")
	suspend fun deletePatientSlot(id: Int)
}