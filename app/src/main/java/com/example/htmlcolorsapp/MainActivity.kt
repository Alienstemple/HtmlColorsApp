package com.example.htmlcolorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.databinding.ActivityMainBinding
import com.example.htmlcolorsapp.databinding.RowItemBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    lateinit var plantRecylerview : RecyclerView
    lateinit var rowItemBinding: RowItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        rowItemBinding = RowItemBinding.inflate(layoutInflater)  // initialize row item with layout
        mainBinding.apply {

        }
    }
}