package com.example.mylist.presentation.ui.mainScreen

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.mylist.presentation.ui.mainScreen.fragments.StartFragment
import com.example.mylist.R
import com.example.mylist.util.openFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

       if (savedInstanceState == null) {
            openFragment(StartFragment())
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            super.onBackPressed()
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}


