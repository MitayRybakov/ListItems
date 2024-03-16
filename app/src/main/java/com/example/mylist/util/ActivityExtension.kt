package com.example.mylist.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.mylist.R

private const val FRAGMENT_TAG = "fragmentTestTag"

fun FragmentActivity.openFragment(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragmentContainer, fragment, FRAGMENT_TAG)
        .addToBackStack(fragment::class.java.simpleName)
        .commit()
}