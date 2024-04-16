package com.example.register_app

import com.example.register_app.data_handling.menu_data.MenuData
import com.example.register_app.util.Money
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

class MoneyTest {

    @Test
    fun InputOutputTest() {
        val money1 = Money("1.01")
        val money2 = Money(4.22)
        val money3 = Money(4.5)
        val money4 = Money(5)
        assertEquals(money1.toMoneyString(),"1,01 €")
        assertEquals(money2.toMoneyString(),"4,22 €")
        assertEquals(money3.toMoneyString(),"4,50 €")
        assertEquals(money4.toMoneyString(),"5,00 €")
        assertEquals(money1.toString(),"1.01")
        assertEquals(money2.toString(),"4.22")
        assertEquals(money3.toString(),"4.50")
        assertEquals(money4.toString(),"5.00")
    }

    @Test
    fun CalculationTest(){
        val money1 = Money(4.22)
        val money2 = Money(1.01)
        val money3 = Money(0.78)
        val money4 = Money(0.22)
        val addResult1 = money1 + money2
        val minusResult1 = money1 - money2
        val addResult2 = money1 + money3
        val minusResult2 = money1 - money4
        assertEquals(addResult1.toString(),"5.23")
        assertEquals(minusResult1.toString(),"3.21")
        assertEquals(addResult2.toString(),"5.00")
        assertEquals(minusResult2.toString(),"4.00")
    }
}