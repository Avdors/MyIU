package com.example.myiu.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Date

class TaskApiModel (

    @SerializedName("id") @Expose
    var id : Int,

    @SerializedName("name") @Expose
    var name : String? = null,

    @SerializedName("info") @Expose
    var info : String? = null,

    @SerializedName("email") @Expose
    var email : String? = null,

    @SerializedName("type") @Expose
    var type : String? = null,

    @SerializedName("dateStart") @Expose
    var dateStart : String? = null,

    @SerializedName("dateEnd") @Expose
    var dateEnd : String? = null,

    @SerializedName("completed") @Expose
    var completed : String? = null
)