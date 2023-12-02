package com.miu.walmartlogin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class ProductAdapter(var context: Context,var plist: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.playout.apply {
            tvTitle.text = plist[position].title
            tvPrice.text = "Price : $${plist[position].price.toString()}"
            tvColor.text = "Color : ${plist[position].color}"
            //image keep as String - convert to int from drawable resource
            imageView.setImageResource(getResources().getIdentifier(
                plist[position].img, "drawable", "com.miu.walmartlogin"))

            holder.itemView.playout.setOnClickListener{
                val intent = Intent(context, ItemDetailActivity::class.java)
                var res = plist[position]
                Toast.makeText(context, "$res clicked", Toast.LENGTH_LONG).show()

                intent.putExtra("product", plist[position])
                context.startActivity(intent)

            }

        }
    }

    override fun getItemCount(): Int {
        return  plist.size
    }
}