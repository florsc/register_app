package com.example.register_app

import com.example.register_app.data_handling.menu_data.MenuData
import com.example.register_app.util.Money
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

class MenuDataTest {
    var exampleData: String = """
{
    "title":"MainTitle",
    "itemLines":
    [
        {
        "title":"ItemLineTitle0",
        "items":
            [
                {
                "name":"ItemName00",
                "price":"0.00",
                "deposit":true
                },
                {
                "name":"ItemName01",
                "price":"0.10",
                "deposit":false
                }
            ]
        },
        {
        "title":"ItemLineTitle1",
        "items":
            [
                {
                "name":"ItemName10",
                "price":"1.00",
                "deposit":false
                },
                {
                "name":"ItemName11",
                "price":"1.10",
                "deposit":true
                }
            ]
        }
    ]
}
"""

    @Test
    fun MenuDataTest() {
        val menuData : MenuData = MenuData(JSONObject(exampleData))
        print(menuData.getTitle())
        assertEquals(menuData.getTitle(), "MainTitle")
        assertEquals(menuData.getNumberOfItemLines(), 2)
        assertEquals(menuData.getLineTitle(0), "ItemLineTitle0")
        assertEquals(menuData.getLineTitle(1), "ItemLineTitle1")
        assertEquals(menuData.getNumberOfItems(0), 2)
        assertEquals(menuData.getNumberOfItems(1), 2)
        assertEquals(menuData.getItemName(0,0), "ItemName00")
        assertEquals(menuData.getItemName(0,1), "ItemName01")
        assertEquals(menuData.getItemName(1,0), "ItemName10")
        assertEquals(menuData.getItemName(1,1), "ItemName11")
        assertEquals(menuData.getItemPrice(0,0), Money("0.00"))
        assertEquals(menuData.getItemPrice(0,1), Money("0.10"))
        assertEquals(menuData.getItemPrice(1,0), Money("1.00"))
        assertEquals(menuData.getItemPrice(1,1), Money("1.10"))
        assertEquals(menuData.getItemDeposit(0,0), true)
        assertEquals(menuData.getItemDeposit(0,1), false)
        assertEquals(menuData.getItemDeposit(1,0), false)
        assertEquals(menuData.getItemDeposit(1,1), true)
    }

    @Test
    fun SerializationTest() {
        val menuData : MenuData = MenuData(JSONObject(exampleData))
        val serializedMenuData = menuData.serialize()
        assertEquals(JSONObject(exampleData).toString(),serializedMenuData.toString())
    }
}