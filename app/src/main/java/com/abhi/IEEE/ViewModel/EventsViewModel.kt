package com.abhi.IEEE.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abhi.IEEE.FireBase.dataClass.EventData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EventsViewModel : ViewModel() {

    val db = FirebaseDatabase.getInstance()
    val eventsRef = db.getReference("Events")

    private var _Events = MutableLiveData<List<EventData>>()
    val events : LiveData<List<EventData>> = _Events

    init {
        fetchEvents {
            _Events.value = it
        }
    }

    private fun fetchEvents(onResult : (List<EventData>) -> Unit){
        eventsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val result = mutableListOf<EventData>()

                for(announcementSnapShot in snapshot.children){
                    val announcementData = announcementSnapShot.getValue(EventData::class.java)

                    if (announcementData != null) {
                        result.add(0 , announcementData)
                    }


                    if(result.size == snapshot.childrenCount.toInt()){
                        onResult(result)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    fun saveData() {

        val EventData = EventData(description = "" , title =  "" , activeStatus = "" ,
            first = "" , second = "" , third = "" , members = "" , link = "" , date = "")

        eventsRef.child(eventsRef.push().key!!).setValue(EventData).addOnSuccessListener {
        }.addOnFailureListener{

        }

    }



}