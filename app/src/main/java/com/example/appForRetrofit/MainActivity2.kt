package com.example.appForRetrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appforretrofit.R
import com.example.appforretrofit.databinding.ActivityMain2Binding
import com.example.appforretrofit.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        val imageUrl = intent.getStringExtra("imageUrl")
        val id = intent.getStringExtra("id")
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")


        Picasso.get().load(imageUrl).into(binding.imageView2)
        binding.id2.text = "id-$id"
        binding.firstName2.text = "firstname-$firstName"
        binding.lastName2.text = "lastName-$lastName"
        binding.email2.text = "email-$email"
        binding.gender2.text = "gender-$gender"

    }
}