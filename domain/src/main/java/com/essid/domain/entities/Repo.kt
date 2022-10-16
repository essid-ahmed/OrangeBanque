package com.essid.domain.entities

data class Repo(
    var id : Int,
    var fullName : String,
    var forks : Int,
    var openIssues : Int,
    var watchers : Int,
    var description : String?
)