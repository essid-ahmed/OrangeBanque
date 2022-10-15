package com.essid.data.dto

import com.google.gson.annotations.SerializedName


data class PermissionsDto(

    @SerializedName("admin") var admin: Boolean,
    @SerializedName("maintain") var maintain: Boolean,
    @SerializedName("push") var push: Boolean,
    @SerializedName("triage") var triage: Boolean,
    @SerializedName("pull") var pull: Boolean
)