package com.example.credassessment1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MainAdapter(
    private val items: List<NumberItem>,
    private val itemLayout: Int,
    context: Context
) : ArrayAdapter<NumberItem>(context, itemLayout, items) {

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)

        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ImageView = view.findViewById(R.id.image_view)

        val currentItem = items[position]

        // Set the views based on the item's state
        textView.text = currentItem.word
        imageView.setImageResource(currentItem.imageResId)

        // Expand/collapse logic based on the item's state
        if (currentItem.isExpanded) {
            textView.textSize = 40f  // Adjust text size or any other property for expanded state
            imageView.visibility = View.VISIBLE
        } else {
            textView.textSize = 20f  // Adjust text size or any other property for collapsed state
            imageView.visibility = View.GONE  // Hide image in collapsed state
        }

        // Set click listener to toggle state
        view.setOnClickListener {
            // Toggle current item's state
            currentItem.isExpanded = !currentItem.isExpanded

            // Collapse other items
            items.forEachIndexed { index, item ->
                if (index != position) item.isExpanded = false
            }

            notifyDataSetChanged()  // Refresh the adapter to reflect changes
        }

        return view
    }
}