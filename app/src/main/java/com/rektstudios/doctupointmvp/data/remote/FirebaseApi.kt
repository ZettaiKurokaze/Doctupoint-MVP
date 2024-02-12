package com.rektstudios.doctupointmvp.data.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import com.rektstudios.doctupointmvp.domain.model.Doctor
import com.rektstudios.doctupointmvp.domain.model.Patient

class FirebaseApi:DoctupointApi {
	private val db=Firebase.firestore
	private val doctorCollection=db.collection("Doctors")
	private val patientCollection=db.collection("Patients")

	override suspend fun getDoctor(doctor: Doctor?): List<Doctor> {
		lateinit var doctors: MutableList<Doctor>
		if(doctor!=null){
			doctorCollection
				.document(doctor.name)
				.get()
				.addOnSuccessListener { document ->
					if(document.exists()) doctors.add(document.toObject<Doctor>()!!)
				}
				.addOnFailureListener { exception ->
					Log.w(TAG, "Error getting document: ", exception)
				}
		}
		else {
			doctorCollection.get()
				.addOnSuccessListener { documents ->
					for (document in documents) {
						doctors.add(document.toObject<Doctor>())
					}
				}
				.addOnFailureListener { exception ->
					Log.w(TAG, "Error getting documents: ", exception)
				}
		}
		return doctors
	}

	override suspend fun getPatient(patient: Patient?): List<Patient> {
		lateinit var patients: MutableList<Patient>
		if(patient!=null){
			patientCollection
				.document(patient.name)
				.get()
				.addOnSuccessListener { document ->
					if(document.exists()) patients.add(document.toObject<Patient>()!!)
				}
				.addOnFailureListener { exception ->
					Log.w(TAG, "Error getting document: ", exception)
				}
		}
		else {
			patientCollection.get()
				.addOnSuccessListener { documents ->
					for (document in documents) {
						patients.add(document.toObject<Patient>())
					}
				}
				.addOnFailureListener { exception ->
					Log.w(TAG, "Error getting documents: ", exception)
				}
		}
		return patients
	}

	override suspend fun updateDoctor(doctor: Doctor) {
		doctorCollection.document(doctor.name)
			.set(doctor)
			.addOnSuccessListener { Log.d(TAG, "Doctor ${doctor.name} successfully written!") }
			.addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
	}

	override suspend fun updatePatient(patient: Patient) {
		patientCollection.document(patient.name)
			.set(patient)
			.addOnSuccessListener { Log.d(TAG, "Patient ${patient.name} successfully written!") }
			.addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
	}

	override suspend fun deleteDoctor(doctor: Doctor) {
		doctorCollection.document(doctor.name)
			.delete()
			.addOnSuccessListener { Log.d(TAG, "Doctor ${doctor.name} successfully deleted!") }
			.addOnFailureListener { e -> Log.w(TAG, "Error deleting doctor", e) }
	}

	override suspend fun deletePatient(patient: Patient) {
		patientCollection.document(patient.name)
			.delete()
			.addOnSuccessListener { Log.d(TAG, "Patient ${patient.name} successfully deleted!") }
			.addOnFailureListener { e -> Log.w(TAG, "Error deleting patient", e) }
	}

}