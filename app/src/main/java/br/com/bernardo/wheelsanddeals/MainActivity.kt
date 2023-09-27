package br.com.bernardo.wheelsanddeals

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import br.com.bernardo.wheelsanddeals.databinding.ActivityMainLayoutBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#040F0F")
    }
}