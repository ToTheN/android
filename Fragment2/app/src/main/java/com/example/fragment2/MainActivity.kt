package com.example.fragment2

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.preference.PreferenceFragmentCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


// Observe Lifecycle of Fragment with activity
// Observe Lifecycle of Fragment with activity while using Add, Replace, hide, show, remove

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

// Creating Diaglog Fragment
class DialogFragmentDemo : DialogFragment() {

    // It return Dialog after building it
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Welcome")
            .setMessage("This is Dialog Fragment")
            .setPositiveButton("Okay!") { _, _ -> }
            .create()
}

// Creating PreferenceFragment and
// inflate the hierarchy
class MySettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
    }
}