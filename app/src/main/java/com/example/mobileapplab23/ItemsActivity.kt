package com.example.mobileapplab23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "credit_img", "@string/credit_short_text", "@string/credit_full_text", 5000000.0))
        items.add(Item(1, "deposit_img", "@string/deposit_short_text", "@string/deposit_full_text", 16.5))
        items.add(Item(1, "crypto_trade_img", "@string/crypto_trade_short_text", "@string/crypto_trade_full_text", 0.8))

        itemsList.layoutManager = LinearLayoutManager(this) // расположение услуг друг под другом
        itemsList.adapter = ItemsAdapter(items, this)
    }
}