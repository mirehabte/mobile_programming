package com.miu.walmartlogin

import java.io.Serializable

data class Product (var title: String, var price: Double, var color: String, var img: String, var itemId: String, var desc: String) :
    Serializable