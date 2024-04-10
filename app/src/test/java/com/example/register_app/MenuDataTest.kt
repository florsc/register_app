package com.example.register_app

import com.example.register_app.data_handling.menu_data.MenuData
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

class MenuDataTest {
    var exampleData: String = """
{
    "title":"MainTitle",
    "elementLines":
    [
        {
        "title":"ElementLineTitle0",
        "elements":
            [
                {
                "name":"ElementName00",
                "price":0.00,
                "deposit":true
                },
                {
                "name":"ElementName01",
                "price":0.1,
                "deposit":false
                }
            ]
        },
        {
        "title":"ElementLineTitle1",
        "elements":
            [
                {
                "name":"ElementName10",
                "price":1.00,
                "deposit":false
                },
                {
                "name":"ElementName11",
                "price":1.10,
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
        assertEquals(menuData.getNumberOfElementLines(), 2)
        assertEquals(menuData.getLineTitle(0), "ElementLineTitle0")
        assertEquals(menuData.getLineTitle(1), "ElementLineTitle1")
        assertEquals(menuData.getNumberOfElements(0), 2)
        assertEquals(menuData.getNumberOfElements(1), 2)
        assertEquals(menuData.getElementName(0,0), "ElementName00")
        assertEquals(menuData.getElementName(0,1), "ElementName01")
        assertEquals(menuData.getElementName(1,0), "ElementName10")
        assertEquals(menuData.getElementName(1,1), "ElementName11")
        assertEquals(menuData.getElementPrice(0,0), BigDecimal("0.00"))
        assertEquals(menuData.getElementPrice(0,1), BigDecimal("0.1"))
        assertEquals(menuData.getElementPrice(1,0), BigDecimal("1.00"))
        assertEquals(menuData.getElementPrice(1,1), BigDecimal("1.10"))
        assertEquals(menuData.getElementDeposit(0,0), true)
        assertEquals(menuData.getElementDeposit(0,1), false)
        assertEquals(menuData.getElementDeposit(1,0), false)
        assertEquals(menuData.getElementDeposit(1,1), true)
    }
}