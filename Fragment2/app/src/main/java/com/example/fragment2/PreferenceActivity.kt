package com.example.fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment2.R

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        // Add PreferenceFragment in activity
        supportFragmentManager
            .beginTransaction()
            .add(R.id.preferenceFragmentContainer, MySettingsFragment())
            .commit()
    }
}