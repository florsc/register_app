package com.example.register_app.data_handling.data_sources;

class StorageDataSource : DataSource {
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
    override fun save(data: String) {
        TODO("Not yet implemented")
    }

    override fun load(): String {
        return exampleData
    }
}
