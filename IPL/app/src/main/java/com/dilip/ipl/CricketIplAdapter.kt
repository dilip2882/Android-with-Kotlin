package com.dilip.ipl

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CricketIplAdapter(private val data: ArrayList<CricketIpl>): RecyclerView.Adapter<CricketIplAdapter.CricketIplViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketIplViewHolder {
        return CricketIplViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CricketIplViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    inner class CricketIplViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_cricket_ipl, parent, false)
    ) {

        val headerImageView: ImageView = itemView.findViewById(R.id.team_header_image_view)
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        val learnMoreButton: Button = itemView.findViewById(R.id.button)
        fun onBind(cricketIpl: CricketIpl) {

        }
    }

}