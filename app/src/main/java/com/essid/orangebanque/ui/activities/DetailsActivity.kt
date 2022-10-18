package com.essid.orangebanque.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.essid.orangebanque.databinding.ActivityDetailsBinding
import com.essid.orangebanque.databinding.RepoBinding
import com.essid.orangebanque.utils.Constants

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
       val view = binding.root
       setContentView(view)
        setUpUi(
            intent.getStringExtra(Constants.REPO_FULL_NAME),
            intent.getStringExtra(Constants.REPO_DESCRIPTION)
        )
    }

    private fun setUpUi(fullName: String?, description: String?) {
      binding.repoFullName.text =fullName
      binding.repoDescription.text =description
    }
}