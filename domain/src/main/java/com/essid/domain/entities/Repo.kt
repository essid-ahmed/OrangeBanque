package com.essid.domain.entities

data class Repo(
    var fullName : String,
    var forks : Int,
    var openIssues : Int,
    var watchers : Int,
    var description : String?
)