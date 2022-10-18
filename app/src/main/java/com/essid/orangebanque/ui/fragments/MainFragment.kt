package com.essid.orangebanque.ui.fragments

import android.content.Intent
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
import kotlinx.coroutines.launch
import com.essid.orangebanque.databinding.MainFragmentBinding
import com.essid.orangebanque.ui.activities.DetailsActivity
import com.essid.orangebanque.utils.Constants

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val reposViewModel: ReposViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerViewAdapter()
        reposViewModel.getRepos().observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing=false
            when (it) {
                is DataResult.Loading -> {
                    binding.progress.visibility = View.VISIBLE
                }
                is DataResult.Success -> {
                    binding.progress.visibility = View.GONE
                    (binding.recyclerRepoList.adapter as RepoListAdapter).submitList(it.repos)
                }
                is DataResult.Failure -> {
                    binding.progress.visibility = View.GONE
                    Toast.makeText(context,it.exception.message,Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.swipeRefresh.setOnRefreshListener { reposViewModel.fetchRepos()}

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                reposViewModel.fetchRepos()
            }
        }
    }

    private fun setUpRecyclerViewAdapter() {
        binding.recyclerRepoList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RepoListAdapter(this.context)
            (adapter as RepoListAdapter).onItemClick = { repo ->
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(Constants.REPO_FULL_NAME,repo.fullName)
                intent.putExtra(Constants.REPO_DESCRIPTION,repo.description)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}