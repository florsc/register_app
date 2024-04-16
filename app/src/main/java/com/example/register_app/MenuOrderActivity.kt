package com.example.register_app

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.register_app.data_handling.data_sources.StorageDataSource
import com.example.register_app.data_handling.menu_data.MenuData
import org.json.JSONObject

class MenuOrderActivity : AppCompatActivity() {

    private var menuData: MenuData = MenuData(JSONObject(StorageDataSource().load()))

    private fun addItem(line: LinearLayout, lineIndex: Int, itemIndex: Int) {
        layoutInflater.inflate(R.layout.selling_item, line)
        val item = line.getChildAt(itemIndex)

        val name = item.findViewById<TextView>(R.id.itemName)
        name.text = menuData.getItemName(lineIndex, itemIndex)

        val price = item.findViewById<TextView>(R.id.price)
        price.text = menuData.getItemPrice(lineIndex, itemIndex).toString()

        val count = item.findViewById<TextView>(R.id.count)
        count.text = 0.toString()
    }

    fun addItemLine(itemsArea: LinearLayout, i: Int) {
        layoutInflater.inflate(R.layout.menu_order_line, itemsArea)
        val menuLine = itemsArea.getChildAt(i)

        val lineTitle: TextView = menuLine.findViewById(R.id.title)
        lineTitle.text = this.menuData.getLineTitle(i)

        val lineItems: LinearLayout = menuLine.findViewById(R.id.line)
        for (j in 0..<this.menuData.getNumberOfItems(i)) {
            addItem(lineItems, i, j)
        }
    }

    fun loadInterface() {
        for (i in 0..<menuData.getNumberOfItemLines()) {
            val itemsArea: LinearLayout = findViewById(R.id.items)
            addItemLine(itemsArea, i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_order)
        loadInterface()
    }
}