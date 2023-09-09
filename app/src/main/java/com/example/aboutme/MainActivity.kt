package com.example.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton = findViewById<Button>(R.id.done_button)
        doneButton.setOnClickListener {
            updateNicknameDisplay(it as Button)
            hideKeyboard(it)
        }
    }


    private fun updateNicknameDisplay(doneButton: Button) {
        // Retrieve references to the necessary views.
        val nicknameDisplay = findViewById<TextView>(R.id.nickname_text)
        val nicknameInput = findViewById<EditText>(R.id.nickname_edit_text)

        // Update the displayed nickname and adjust view visibilities.
        nicknameDisplay.text = nicknameInput.text
        nicknameInput.visibility = View.GONE
        doneButton.visibility = View.GONE
        nicknameDisplay.visibility = View.VISIBLE
    }


    private fun hideKeyboard(it: Button) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        // Every View in Android is associated with a window, and each window has a unique token.
        // Fetching window unique token from the view.
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}