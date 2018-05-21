package com.listy.listy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        add_store.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }

        val shoppingList = listOf(
            Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"),
            Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables"), Shop("Target", "stuff"),
            Shop("99", "meat & vegetables")
            )

        val shoppingListAdapter = ShopListAdapter(this, shoppingList)

        shopping_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = shoppingListAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

class ShopListAdapter(val context: Context, private var shopList: List<Shop> = listOf()) :
    RecyclerView.Adapter<ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val shopItem = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ShoppingItemViewHolder(shopItem)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val shop = shopList[position]
        holder.setItem(shop)
        holder.itemView.setOnClickListener {
            context.startActivity(ShopActivity.newIntent(context,shop))
        }
    }

    fun setShops(shops: List<Shop>) {
        shopList = shops
        notifyDataSetChanged()
    }

}

class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var storeNameTextView: TextView? = null
    var itemNamesTextView: TextView? = null

    init {
        storeNameTextView = itemView.findViewById(R.id.shop_name)
        itemNamesTextView = itemView.findViewById(R.id.item_names)
    }

    fun setItem(shop: Shop) {
        storeNameTextView?.text = shop.shopName
        itemNamesTextView?.text = shop.itemNames
    }
}
