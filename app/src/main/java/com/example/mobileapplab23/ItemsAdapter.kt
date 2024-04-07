package com.example.mobileapplab23

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_img)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val desc: TextView = view.findViewById(R.id.item_list_text)
        val price: TextView = view.findViewById(R.id.item_list_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.title.text = items[position].title
        val titleId = context.resources.getIdentifier(items[position].title, "values", context.packageName)
        holder.title.setText(titleId)
        //holder.desc.text = items[position].desc
        val descId = context.resources.getIdentifier(items[position].desc, "values", context.packageName)
        holder.desc.setText(descId)
        holder.price.text = items[position].price.toString()

        val imageId = context.resources.getIdentifier(items[position].image, "drawable", context.packageName)
        holder.image.setImageResource(imageId)
    }
}