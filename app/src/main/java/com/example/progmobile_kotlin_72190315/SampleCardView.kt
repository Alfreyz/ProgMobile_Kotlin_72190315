package com.example.progmobile_kotlin_72190315

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobile_kotlin_72190315.adapter.LahanAdapter
import com.example.progmobile_kotlin_72190315.adapter.PetaniCVAdapter
import com.example.progmobile_kotlin_72190315.model.Petani

class SampleCardView : AppCompatActivity() {
    private lateinit var cvSample: RecyclerView
    private var list: ArrayList<Petani> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_card_view)
        cvSample = findViewById(R.id.rvCardView)
        list.addAll(dataPetani.listData)
        showCardViewList()
    }

    private fun showCardViewList() {
        cvSample.layoutManager = LinearLayoutManager(this)
        val petaniCVAdapter = PetaniCVAdapter(list)
        cvSample.adapter = petaniCVAdapter
    }
}