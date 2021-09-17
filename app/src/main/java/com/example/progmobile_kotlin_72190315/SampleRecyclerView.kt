package com.example.progmobile_kotlin_72190315

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobile_kotlin_72190315.adapter.LahanAdapter
import com.example.progmobile_kotlin_72190315.adapter.PetaniAdapter
import com.example.progmobile_kotlin_72190315.model.Lahan
import com.example.progmobile_kotlin_72190315.model.Petani
import com.google.android.material.snackbar.Snackbar

class SampleRecyclerView : AppCompatActivity() {
    private lateinit var rvSample: RecyclerView
    private var list: ArrayList<Petani> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_recycler_view)
        rvSample = findViewById(R.id.rvLatihan)
        rvSample.setHasFixedSize(true)
        list.addAll(dataPetani.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvSample.layoutManager = LinearLayoutManager(this)
        val petaniAdapter = PetaniAdapter(list)
        rvSample.adapter = petaniAdapter
    }

}