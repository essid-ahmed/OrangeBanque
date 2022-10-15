package com.essid.orangebanque.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.essid.domain.dataresult.DataResult
import com.essid.orangebanque.ui.adapters.RepoListAdapter
import com.essid.orangebanque.viewmodel.ReposViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.launch
import com.essid.orangebanque.R

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val reposViewModel: ReposViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_repoList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RepoListAdapter(this.context)
        }
        reposViewModel.getRepos().observe(viewLifecycleOwner){
            when (it) {
                is DataResult.Loading -> {
                    progress.visibility = View.VISIBLE
                }
                is DataResult.Success -> {
                    progress.visibility = View.GONE
                    (recycler_repoList.adapter as RepoListAdapter).submitList(it.repos)
                }
                is DataResult.Failure -> {
                    progress.visibility = View.GONE
                    Toast.makeText(context,it.exception.message,Toast.LENGTH_LONG)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                //TODO
            }
        }
    }
}