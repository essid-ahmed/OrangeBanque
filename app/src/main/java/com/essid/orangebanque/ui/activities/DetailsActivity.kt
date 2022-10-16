package com.essid.orangebanque.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.essid.orangebanque.R
import com.essid.orangebanque.utils.Constants
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setUpUi(
            intent.getStringExtra(Constants.REPO_FULL_NAME),
            intent.getStringExtra(Constants.REPO_DESCRIPTION)
        )
    }

    private fun setUpUi(fullName: String?, description: String?) {
        repo_full_name.text = fullName
        repo_description.text = description
    }
}