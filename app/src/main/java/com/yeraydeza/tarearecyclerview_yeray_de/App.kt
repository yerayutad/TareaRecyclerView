package com.yeraydeza.tarearecyclerview_yeray_de

import android.app.Application
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.yeraydeza.tarearecyclerview_yeray_de.model.Repositories

class App : Application() {
    val users: MutableList<Repositories> = mutableListOf()
//  User(1, "user #1", "https://i.imgur.com/DvpvklR.png"),
//  User(2, "user #2", "https://upload.wikimedia.org/wikipedia/commons/3/30/Chuck_Norris_May_2015.jpg"),
//  User(3, "user #3", "https://i.imgur.com/DvpvklR.png"),
//  User(4, "User #6", "https://i.imgur.com/DvpvklR.png")
}

fun ImageView.imageUrl(url: String, placeholder: Int = R.mipmap.ic_launcher){
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .into(this)
}