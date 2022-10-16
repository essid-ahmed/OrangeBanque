package com.essid.data.dataSource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepoEntity(
    @PrimaryKey
    val id: Int,
    val fullName: String,
    val forks: Int,
    val watchers: Int,
    val openIssues: Int,
    val description: String?
)