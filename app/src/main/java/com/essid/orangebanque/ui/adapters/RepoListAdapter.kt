package com.essid.orangebanque.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.essid.domain.entities.Repo
import com.essid.orangebanque.R

class RepoListAdapter(private val ctx: Context?) : RecyclerView.Adapter<RepoViewHolder>() {

    private val data = mutableListOf<Repo>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RepoViewHolder {
        return RepoViewHolder(LayoutInflater.from(ctx).inflate(R.layout.repo, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    fun submitList(newData: List<Repo>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: RepoViewHolder, p1: Int) {
        p0.bindItems(data[p1])
    }
}