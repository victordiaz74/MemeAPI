package com.example.memeapi.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeapi.R
import com.example.memeapi.entidades.MemeResponse
import com.example.memeapi.api.MemeRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemeAdapter(private val onClickListener: (Int) -> Unit): RecyclerView.Adapter<MemeViewHolder>() {

    private lateinit var context: Context
    lateinit var memes: List<MemeResponse>

    fun MemeAdapter(context: Context, memes: List<MemeResponse>) {
        this.context = context
        this.memes = memes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MemeViewHolder(layoutInflater.inflate(R.layout.meme_item, parent, false))
    }

    override fun getItemCount(): Int {
        return memes.size
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.render(memes[position], onClickListener)
    }

}