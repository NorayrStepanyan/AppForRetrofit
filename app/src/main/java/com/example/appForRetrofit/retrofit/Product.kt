package com.example.appForRetrofit.retrofit

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Float,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val tumBail: String,
    val image: List<String>,
)
