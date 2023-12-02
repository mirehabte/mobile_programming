package com.miu.walmartlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category_list.*

class CategoryListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        var products = ArrayList<Product>()
        products.add( Product("RCA Voyager 7\" 16GB android tablet", 35.00, "Blue", "tablet", "123L", "Nice tablet Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the great item."))
        products.add(Product("HP Flyer Red 15.6 \" Laptop", 435.00, "Red", "laptop", "1236L", "Nice laptop Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the great item."))
        products.add( Product("Vizio 70\" class 4K", 235.00, "Black", "tv", "1234L", "Nice TV Screen Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the great item."))
        products.add(Product("EPSON workforce WF-2750", 135.00, "Black", "scanner", "1235L", "Nice Scanner Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the great item."))

        rv.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(this,products)
        rv.adapter = adapter
    }
}