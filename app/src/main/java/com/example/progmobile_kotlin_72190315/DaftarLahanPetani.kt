package com.example.progmobile_kotlin_72190315

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.*
import com.example.progmobile_kotlin_72190315.adapter.LahanAdapter
import com.example.progmobile_kotlin_72190315.model.Lahan
import com.google.android.material.snackbar.Snackbar

class DaftarLahanPetani : AppCompatActivity() {
    private lateinit var adapter: LahanAdapter
    private var lahans = arrayListOf<Lahan>()

    private var names = arrayOf(
        "abdulrohma",
        "abuwiyono",
        "adiprajitn",
        "adipranot2"
    )

    private var descriptions = arrayOf(
        "Nama : Abdul Rohman \nTotal Jumlah Lahan : 1 \nJumlah Lahan yang sudah teridentifikasi : 0 \nLahan yang bisa ditambahkan : 1",
        "Nama : Abuwiyono / Sukri \nTotal Jumlah Lahan : 1 \nJumlah Lahan yang sudah terindetifikasi : 1 \nLahan yang bisa ditambahkan : 0",
        "Nama : Adi Prajitno \nTotal Jumlah Lahan : 3 \nJumlah Lahan yang sudah teridentifikasi : 0 \nLahan yang bisa ditambahkan : 3",
        "Nama : Adi Pranoto \nTotal Jumlah Lahan : 3 \nJumlah Lahan yang sudah terindetifikasi : 2 \nLahan yang bisa ditambahkan : 1"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_daftar_lahan_petani)

        val listView: ListView = findViewById(R.id.listview)
        adapter = LahanAdapter(this)
        listView.adapter = adapter
        addItem()
        listView.setOnItemClickListener { parent, view, position, l -> Snackbar.make(view,"Anda memilih: ${lahans[position].name}", Snackbar.LENGTH_LONG).show() }
    }
    private fun addItem(){
        for(position in names.indices) {
            val lahan = Lahan(
                names[position],
                descriptions[position]
            )
            lahans.add(lahan)
        }
        adapter.lahans = lahans
    }
}