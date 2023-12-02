package com.miu.walmartlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.detail_layout.*

class ItemDetailActivity : AppCompatActivity() {
    lateinit var result:Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        if(intent.hasExtra("product")){
            val temp = intent.getSerializableExtra("product")
            result = temp as Product
            tvName.text = "${result.title}"
            tvPrice.text = "Price : $${result.price.toString()}"
            tvColor.text = "Color : ${result.color}"
            tvId.text = "Walmart #: ${result.itemId}"
            tvDesc.text = result.desc
            imageView.setImageResource(getResources().getIdentifier(
                result.img, "drawable", "com.miu.walmartlogin"))

        }
    }
}