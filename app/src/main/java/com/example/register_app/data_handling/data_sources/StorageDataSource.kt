package com.example.register_app.data_handling.data_sources;

import android.util.Log

class StorageDataSource : DataSource {
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
    override fun save(data: String) {
        TODO("Not yet implemented")
    }

    override fun load(): String {
        return exampleData
    }
}
