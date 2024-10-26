package com.example.credassessment1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MainAdapter(
    private val numberWord: List<String>,
    private val numberImage: List<Int>,
    private val itemLayout: Int,
    context: Context
) : ArrayAdapter<String>(context, itemLayout, numberWord) {

    override fun getCount(): Int {
        return numberWord.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)

        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ImageView = view.findViewById(R.id.image_view)

        textView.text = numberWord[position]
        imageView.setImageResource(numberImage[position])

        return view
    }
}