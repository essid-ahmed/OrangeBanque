package com.essid.orangebanque.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.essid.domain.entities.Repo
import kotlinx.android.synthetic.main.repo.view.*

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItems(repo: Repo) {
        itemView.full_name.text = repo.fullName
        itemView.watchers.text = repo.watchers.toString()
        itemView.open_issues.text = repo.openIssues.toString()
        itemView.forks.text = repo.forks.toString()
    }
}