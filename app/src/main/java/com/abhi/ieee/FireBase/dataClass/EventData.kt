package com.abhi.ieee.FireBase.dataClass

data class EventData(
    var activeStatus : String = "completed" ,
    var title : String = "" ,
    var description: String = "",
    var members : String = "",
    var first : String = "",
    var second : String = "",
    var third : String = "",
    var link : String= "",
    var date : String= ""
)

data class EventCompleteData(
    var activeStatus : String = "completed" ,
    var title : String = "" ,
    var description: String = "",
    var members : String = "",
    var first : String = "",
    var second : String = "",
    var third : String = "",
)