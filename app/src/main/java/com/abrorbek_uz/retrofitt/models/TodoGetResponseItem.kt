package com.abrorbek_uz.retrofitt.models

data class TodoGetResponseItem(
    val bajarildi: Boolean,
    val batafsil: String,
    val id: Int,
    val oxirgi_muddat: String,
    val sana: String,
    val sarlavha: String,
    val zarurlik: String
)