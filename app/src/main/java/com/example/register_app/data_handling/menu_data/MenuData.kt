package com.example.register_app.data_handling.menu_data

import com.example.register_app.util.Money
import org.json.JSONArray
import org.json.JSONObject

class MenuData(jsonMenu: JSONObject) {
    private var title: String
    private var itemLines: List<ItemLine>

    init {
        title = jsonMenu["title"] as String
        val jsonItemLines = jsonMenu.getJSONArray("itemLines")
        val itemLinesList : ArrayList<ItemLine> = arrayListOf()
        for (i in 0 until jsonItemLines.length()) {
            itemLinesList.add(ItemLine(jsonItemLines.getJSONObject(i)))
        }
        this.itemLines = itemLinesList.toList()
    }
    fun serialize() : JSONObject {
        val jsonMenu = JSONObject()
        jsonMenu.put("title", title)
        val jsonItemLines = JSONArray()
        for(item in itemLines) {
            jsonItemLines.put(item.serialize())
        }
        jsonMenu.put("itemLines", jsonItemLines)
        return jsonMenu
    }

    fun getTitle(): String{
        return title
    }

    private fun checkIndex(i: Int){
        assert(i>0 || i<itemLines.size)
    }
    fun getLineTitle(i: Int) : String{
        checkIndex(i)
        return itemLines[i].getTitle()
    }

    fun getItemName(i: Int, j: Int) : String{
        checkIndex(i)
        return itemLines[i].getName(j)
    }

    fun getItemPrice(i: Int, j: Int) : Money{
        checkIndex(i)
        return itemLines[i].getPrice(j)
    }

    fun getItemDeposit(i: Int, j: Int) : Boolean{
        checkIndex(i)
        return itemLines[i].getDeposit(j)
    }

    fun getNumberOfItemLines(): Int {
        return itemLines.size
    }

    fun getNumberOfItems(i: Int): Int {
        checkIndex(i)
        return itemLines[i].getNumberOfItems()
    }
}

internal class ItemLine(jsonItemLine: JSONObject) {
    private var title: String
    private var items: List<Item>

    init {
        title = jsonItemLine["title"] as String
        val jsonItems = jsonItemLine.getJSONArray("items")
        val itemsList : ArrayList<Item> = arrayListOf()
        for (i in 0 until jsonItems.length())
            itemsList.add(Item(jsonItems.getJSONObject(i)))

        items = itemsList.toList()
    }

    fun serialize() : JSONObject {
        val jsonItemLine = JSONObject()
        jsonItemLine.put("title", title)
        val jsonItems = JSONArray()
        for(item in items)
            jsonItems.put(item.serialize())

        jsonItemLine.put("items", jsonItems)
        return jsonItemLine
    }

    fun getTitle(): String{
        return title
    }

    private fun checkIndex(i: Int){
        assert(i>0 || i<=items.size)
    }

    fun getName(i: Int): String{
        checkIndex(i)
        return items[i].getName()
    }

    fun getPrice(i: Int): Money{
        checkIndex(i)
        return items[i].getPrice()
    }

    fun getDeposit(i: Int): Boolean{
        checkIndex(i)
        return items[i].getDeposit()
    }

    fun getNumberOfItems(): Int {
        return items.size
    }
}

internal class Item(jsonItem: JSONObject) {
    private var name: String
    private var price: Money
    private var deposit: Boolean

    init {
        name = jsonItem["name"] as String
        price = Money(jsonItem["price"] as String)
        deposit = jsonItem["deposit"] as Boolean
    }

    fun serialize() : JSONObject {
        val jsonItem = JSONObject()
        jsonItem.put("name", name)
        jsonItem.put("price", price)
        jsonItem.put("deposit", deposit)
        return jsonItem
    }

    fun getName(): String{
        return name
    }

    fun getPrice(): Money {
        return price
    }

    fun getDeposit(): Boolean{
        return deposit
    }
}