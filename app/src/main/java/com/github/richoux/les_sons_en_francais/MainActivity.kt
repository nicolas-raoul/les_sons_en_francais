package com.github.richoux.les_sons_en_francais

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import com.github.richoux.les_sons_en_francais.ui.Navigation
import com.github.richoux.les_sons_en_francais.ui.theme.LesSonsEnFrançaisTheme

class MainActivity : ComponentActivity() {
    private val TAG = "Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val preferences: SharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
            val darkTheme: Boolean = preferences.getBoolean("darkMode", isSystemInDarkTheme())
            Log.d(TAG, "Main")
            LesSonsEnFrançaisTheme(
                darkTheme = darkTheme
            ) {
                Navigation(preferences)
            }
        }
    }
}
