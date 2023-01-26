package com.example.memeapi.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memeapi.R
import com.example.memeapi.entidades.MemeResponse

class MemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var idMeme = itemView.findViewById<TextView>(R.id.idTag)
    var nombreMeme = itemView.findViewById<TextView>(R.id.txtTag)
    var mostrarMeme = itemView.findViewById<TextView>(R.id.btnMostrar)

    fun render(meme: MemeResponse, onClickListener: (Int) -> Unit)
    {
        idMeme.text = meme.idMeme.toString()
        nombreMeme.text = meme.nombreMeme

        mostrarMeme.setOnClickListener{
            onClickListener(meme.idMeme)
        }
    }
}