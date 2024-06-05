package com.dilip.androidlayoutsapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SimpleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: ArrayList<String> = ArrayList()
    private var headerText: String? = null

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> R.layout.view_holder_header
            data.size -> R.layout.view_holder_footer
            else -> R.layout.view_holder_textview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.view_holder_header -> SimpleHeaderViewHolder(parent)
            R.layout.view_holder_footer -> SimpleFooterViewHolder(parent)
            else -> SimpleViewHolder(parent)
        }
    }

    override fun getItemCount(): Int {
        return data.size + 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is SimpleViewHolder -> holder.onBind(data[position - 1], position, position % 10 == 0)
            is SimpleHeaderViewHolder -> holder.onBind(headerText)
            is SimpleFooterViewHolder -> holder.onBind()

        }
    }

    fun setData(data: List<String>, headerText: String?) {
        this.data.clear()
        this.data.addAll(data)
        this.headerText = headerText
    }

    inner class SimpleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_textview, parent, false)
    ) {
        private val textView: TextView = itemView.findViewById(R.id.textView)
        private val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)

        fun onBind(textToDisplay: String, position: Int, isChecked: Boolean) {
            val color = if (position % 2 == 0) {
                itemView.context.getColor(R.color.light_background)
            } else {
                itemView.context.getColor(R.color.white)
            }
            textView.text = textToDisplay
            itemView.setBackgroundColor(color)

            checkBox.isChecked = isChecked
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                Log.i("CHECKED", isChecked.toString())
                if (isChecked) {
                    // network call
                } else {
                    // delete
                }
            }

        }
    }

    inner class SimpleHeaderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_header, parent, false)
    ) {
        private val textView: TextView = itemView.findViewById(R.id.header_textView)

        fun onBind(headerText: String?) {

            val textToDisplay = headerText ?: "No header"
            textView.text = textToDisplay

        }
    }

    inner class SimpleFooterViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_footer, parent, false)
    ) {
        private val leftButton: Button = itemView.findViewById(R.id.left_button)
        private val rightButton: Button = itemView.findViewById(R.id.right_button)

        fun onBind() {
            leftButton.setOnClickListener {
                Log.i("Log", "Left Button Clicked")
            }

            rightButton.setOnClickListener {
                Log.i("Log", "Right Button Clicked")
            }
        }

    }

}