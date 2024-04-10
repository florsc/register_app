package com.example.register_app.data_handling.data_sources

interface DataSource {
    fun save(data : String)
    fun load() : String
}