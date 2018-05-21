package com.listy.listy

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shop.*

const val SHOP_NAME = "shop.name"
const val ITEM_NAMES = "item,names"

class ShopActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context, shop: Shop) :Intent{
            val intent = Intent(context,ShopActivity::class.java)
            intent.putExtra(SHOP_NAME, shop.shopName)
            intent.putExtra(ITEM_NAMES, shop.itemNames)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val shopName = intent.getStringExtra(SHOP_NAME)
        val itemNames = intent.getStringExtra(ITEM_NAMES)

        shop_name.setText(shopName)
        item_names.setText(itemNames)
    }
}
