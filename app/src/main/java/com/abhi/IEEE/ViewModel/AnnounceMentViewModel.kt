package com.abhi.IEEE.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abhi.IEEE.FireBase.dataClass.AnnouncementData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AnnouncementViewModel: ViewModel() {

    private val db = FirebaseDatabase.getInstance()
    val announcement = db.getReference("Announce")


    private var _Announcements = MutableLiveData<List<AnnouncementData>>()
    val announcements : LiveData<List<AnnouncementData>> = _Announcements

    init {
        fetchAnnoucemnts {
            _Announcements.value = it
        }
    }

    private fun fetchAnnoucemnts(onResult : (List<AnnouncementData>) -> Unit){
        announcement.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                val result = mutableListOf<AnnouncementData>()

                for(announcementSnapShot in snapshot.children){
                    val announcementData = announcementSnapShot.getValue(AnnouncementData::class.java)

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



    fun saveData(thread: String,
                 userId :String,
                 imageUrl : String,
    ) {

        val ThreadData = AnnouncementData("thread", "userI")

        announcement.child(announcement.push().key!!).setValue(ThreadData).addOnSuccessListener {
        }.addOnFailureListener{

        }

    }


}