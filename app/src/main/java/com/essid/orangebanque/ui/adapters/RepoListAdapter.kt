package com.essid.orangebanque.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.essid.domain.entities.Repo
import com.essid.orangebanque.R
import kotlinx.android.synthetic.main.repo.view.*

class RepoListAdapter(private val ctx: Context?) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    private val data = mutableListOf<Repo>()
    var onItemClick: ((Repo) -> Unit)? = null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.repo, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    fun submitList(newData: List<Repo>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val repo =data[position]
            holder.itemView.full_name.text = repo.fullName
            holder.itemView.watchers.text = repo.watchers.toString()
            holder.itemView.open_issues.text = repo.openIssues.toString()
            holder.itemView.forks.text = repo.forks.toString()
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(data[adapterPosition])
            }
        }
    }
}