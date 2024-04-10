package com.example.register_app.data_handling.menu_data

import org.json.JSONArray
import org.json.JSONObject
import java.math.BigDecimal

class MenuData(jsonMenu: JSONObject) {
    private var title: String
    private var elementLines: List<ElementLine>

    init {
        title = jsonMenu["title"] as String
        val jsonElementLines = jsonMenu.getJSONArray("elementLines")
        val elementLinesList : ArrayList<ElementLine> = arrayListOf()
        for (i in 0 until jsonElementLines.length()) {
            elementLinesList.add(ElementLine(jsonElementLines.getJSONObject(i)))
        }
        this.elementLines = elementLinesList.toList()
    }
    fun serialize() : JSONObject {
        val jsonMenu = JSONObject()
        jsonMenu.put("title", title)
        val jsonElementLines = JSONArray()
        for(element in elementLines) {
            jsonElementLines.put(element.serialize())
        }
        jsonMenu.put("elementLines", jsonElementLines)
        return jsonMenu
    }

    fun getTitle(): String{
        return title
    }

    private fun checkIndex(i: Int){
        assert(i>0 || i<elementLines.size)
    }
    fun getLineTitle(i: Int) : String{
        checkIndex(i)
        return elementLines[i].getTitle()
    }

    fun getElementName(i: Int, j: Int) : String{
        checkIndex(i)
        return elementLines[i].getName(j)
    }

    fun getElementPrice(i: Int, j: Int) : BigDecimal{
        checkIndex(i)
        return elementLines[i].getPrice(j)
    }

    fun getElementDeposit(i: Int, j: Int) : Boolean{
        checkIndex(i)
        return elementLines[i].getDeposit(j)
    }

    fun getNumberOfElementLines(): Int {
        return elementLines.size
    }

    fun getNumberOfElements(i: Int): Int {
        checkIndex(i)
        return elementLines[i].getNumberOfElements()
    }
}

internal class ElementLine(jsonElementLine: JSONObject) {
    private var title: String
    private var elements: List<Element>

    init {
        title = jsonElementLine["title"] as String
        val jsonElements = jsonElementLine.getJSONArray("elements")
        val elementsList : ArrayList<Element> = arrayListOf()
        for (i in 0 until jsonElements.length())
            elementsList.add(Element(jsonElements.getJSONObject(i)))

        elements = elementsList.toList()
    }

    fun serialize() : JSONObject {
        val jsonElementLine = JSONObject()
        jsonElementLine.put("title", title)
        val jsonElements = JSONArray()
        for(element in elements)
            jsonElements.put(element.serialize())

        jsonElementLine.put("elements", jsonElements)
        return jsonElementLine
    }

    fun getTitle(): String{
        return title
    }

    private fun checkIndex(i: Int){
        assert(i>0 || i<=elements.size)
    }

    fun getName(i: Int): String{
        checkIndex(i)
        return elements[i].getName()
    }

    fun getPrice(i: Int): BigDecimal{
        checkIndex(i)
        return elements[i].getPrice()
    }

    fun getDeposit(i: Int): Boolean{
        checkIndex(i)
        return elements[i].getDeposit()
    }

    fun getNumberOfElements(): Int {
        return elements.size
    }
}

internal class Element(jsonElement: JSONObject) {
    private var name: String
    private var price: BigDecimal
    private var deposit: Boolean

    init {
        name = jsonElement["name"] as String
        price = jsonElement["price"] as BigDecimal
        deposit = jsonElement["deposit"] as Boolean
    }

    fun serialize() : JSONObject {
        val jsonElement = JSONObject()
        jsonElement.put("name", name)
        jsonElement.put("price", price)
        jsonElement.put("deposit", deposit)
        return jsonElement
    }

    fun getName(): String{
        return name
    }

    fun getPrice(): BigDecimal{
        return price
    }

    fun getDeposit(): Boolean{
        return deposit
    }
}