package com.example.register_app.util

import android.util.Log
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class Money {
    private var moneyValue : BigDecimal
    private var currencyFormatter: NumberFormat =
        NumberFormat.getCurrencyInstance(Locale("de", "DE"))

    init {
        Log.e("test", "kk2k")
        currencyFormatter.maximumFractionDigits = 2
        currencyFormatter.minimumFractionDigits = 2
    }

    constructor(initValue: String)
    {
        Log.e("test", initValue)
        assert(initValue.matches(Regex("\\d{1}.\\d{2}")))
        moneyValue = BigDecimal(initValue)
    }

    constructor(initValue: Int)
    {
        moneyValue = initValue.toBigDecimal()
        moneyValue = moneyValue.setScale(2)
    }

    constructor(initValue: Double)
    {
        moneyValue = initValue.toBigDecimal()
        moneyValue = moneyValue.setScale(2)
    }
    constructor(initValue: BigDecimal)
    {
        moneyValue = initValue
        moneyValue = moneyValue.setScale(2)
    }
    operator fun plus(other : Money): Money {
        return Money(moneyValue + other.moneyValue)
    }

    operator fun minus(other : Money): Money {
        return Money(moneyValue - other.moneyValue)
    }

    override fun equals(other : Any?): Boolean {
        return other is Money && moneyValue == other.moneyValue
    }

    override fun toString(): String{
        return moneyValue.toString()
    }

    fun toMoneyString(): String{
        return currencyFormatter.format(moneyValue)
    }

}