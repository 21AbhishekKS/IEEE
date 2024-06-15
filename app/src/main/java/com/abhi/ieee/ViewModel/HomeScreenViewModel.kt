package com.abhi.ieee.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhi.ieee.FireBase.dataClass.AnnouncementData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await





class HomeScreenViewModel  : ViewModel(){
    var state = mutableListOf<AnnouncementData>()

    init {
        getAnnouncement()
    }

    private fun getAnnouncement() {
        viewModelScope.launch {
           state = getAnnouncementDataFromFireStore()
        }
    }
}








suspend fun getAnnouncementDataFromFireStore() : MutableList<AnnouncementData>{
    val db = FirebaseFirestore.getInstance()
    var announcement = mutableListOf<AnnouncementData>()

    try{
        db.collection("Announce").get().await().forEach { document ->
            val announcementItem = document.toObject(AnnouncementData::class.java)
            announcement.add(announcementItem)
        }
        return announcement

    }catch (e : FirebaseFirestoreException){

        Log.d("errordb", "DataStore : $e")

    }

    return announcement
}