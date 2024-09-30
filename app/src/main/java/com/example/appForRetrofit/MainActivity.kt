package com.example.appForRetrofit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appForRetrofit.retrofit.AuthRequest
import com.example.appForRetrofit.retrofit.MainApi
import com.example.appforretrofit.R
import com.example.appforretrofit.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // you can try usName and pass options https://dummyjson.com/users

        //  I used the following gradle in the code


        //okhttp and interceptor-to master data output and input
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        // Gson and Retrofit-data to receive
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .build()


        val mainApi = retrofit.create(MainApi::class.java)

        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val user = mainApi.auth(
                        AuthRequest(
                            binding.username.text.toString(), binding.password.text.toString()
                        )
                    )
                    runOnUiThread {
                        //picasso-for the image
                        Picasso.get().load(user.image)
                        binding.firstName
                        binding.lastName
                        binding.id
                        binding.email
                        binding.gender

                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra("imageUrl", user.image)
                        intent.putExtra("id", user.id.toString())
                        intent.putExtra("firstName", user.firstName)
                        intent.putExtra("lastName", user.lastName)
                        intent.putExtra("email", user.email)
                        intent.putExtra("gender", user.gender)
                        startActivity(intent)

                    }
                } catch (e: Exception) {
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity,
                            "Incorrect login or password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}