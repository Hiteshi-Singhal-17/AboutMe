package com.example.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val nameDetails = NameDetails("Jessica Singhal")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.nameDetails = nameDetails

        binding.doneButton.setOnClickListener {
            updateNicknameDisplay(it as Button)
            hideKeyboard(it)
        }
    }


    private fun updateNicknameDisplay(doneButton: Button) {
        binding.apply {
            // Initializing nickname property of the nameDetails object
            nameDetails = nameDetails?.copy(nickname = nicknameEdit.text.toString())
            this.nameDetails = nameDetails
//            invalidateAll()
            // Update the displayed nickname and adjust view visibilities.
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
    }


    private fun hideKeyboard(it: Button) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        // Every View in Android is associated with a window, and each window has a unique token.
        // Fetching window unique token from the view.
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}
