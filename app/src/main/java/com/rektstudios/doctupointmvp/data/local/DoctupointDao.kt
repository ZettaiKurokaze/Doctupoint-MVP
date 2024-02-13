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
	suspend fun insertDoctorSlot(
		doctorSlotEntity: DoctorSlotEntity
	)
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertPatientSlot(
		patientSlotEntity: PatientSlotEntity
	)

	@Query("SELECT * FROM doctorentity WHERE id = (:id)")
	suspend fun getDoctor(id: Int): DoctorEntity

	@Query("SELECT * FROM doctorentity")
	suspend fun getDoctors(): List<DoctorEntity>

	@Query("SELECT * FROM doctorslotentity WHERE id = (:id)")
	suspend fun getDoctorSlot(id: Int): DoctorSlotEntity

	@Query("SELECT * FROM doctorslotentity WHERE doctorId = (:id)")
	suspend fun getDoctorSlots(id: Int): List<DoctorSlotEntity>

	@Query("SELECT * FROM patiententity WHERE id = (:id)")
	suspend fun getPatient(id: Int): PatientEntity

	@Query("SELECT * FROM patiententity")
	suspend fun getPatients(): List<PatientEntity>

	@Query("SELECT * FROM patientslotentity WHERE id = (:id)")
	suspend fun getPatientSlot(id: Int): PatientSlotEntity

	@Query("SELECT * FROM patientslotentity WHERE patientId = (:id)")
	suspend fun getPatientSlots(id: Int): List<PatientSlotEntity>

	@Query("DELETE FROM doctorentity WHERE id = (:id)")
	suspend fun deleteDoctor(id: Int)

	@Query("DELETE FROM doctorentity")
	suspend fun clearDoctors()

	@Query("DELETE FROM doctorslotentity WHERE id = (:id)")
	suspend fun deleteDoctorSlot(id: Int)

	@Query("DELETE FROM patiententity WHERE id = (:id)")
	suspend fun deletePatient(id: Int)

	@Query("DELETE FROM patiententity")
	suspend fun clearPatients()

	@Query("DELETE FROM patientslotentity WHERE id = (:id)")
	suspend fun deletePatientSlot(id: Int)
}