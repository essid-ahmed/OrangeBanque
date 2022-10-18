package com.essid.orangebanque.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.essid.domain.entities.Repo
import com.essid.orangebanque.databinding.RepoBinding

class RepoListAdapter(private val ctx: Context?) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    private val data = mutableListOf<Repo>()
    var onItemClick: ((Repo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val binding = RepoBinding.inflate(LayoutInflater.from(ctx),parent,false)
        return ViewHolder(binding)
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
            holder.bind(repo)
    }

    inner class ViewHolder(private val itemBinding: RepoBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(data[adapterPosition])
            }
        }
        fun bind(repo: Repo) {
            itemBinding.fullName.text = repo.fullName
            itemBinding.watchers.text = repo.watchers.toString()
            itemBinding.openIssues.text = repo.openIssues.toString()
            itemBinding.forks.text = repo.forks.toString()
        }
    }
}