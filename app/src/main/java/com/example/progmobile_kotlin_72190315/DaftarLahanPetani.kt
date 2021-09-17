package com.example.progmobile_kotlin_72190315

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.core.content.res.TypedArrayUtils
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.htmlEncode
import com.google.android.material.snackbar.Snackbar

class DaftarLahanPetani : AppCompatActivity() {
    private lateinit var adapter: LahanAdapter
    private var lahans = arrayListOf<Lahan>()

    private var names = arrayOf(
        "Testing 1",
        "Testing 2",
        "Testing 3",
        "Testing 4"
    )

    private var descriptions = arrayOf(
        "Nama : Number 1 \nTotal Jumlah Lahan : 1 \nJumlah Lahan yang sudah teridentifikasi : 0 \nLahan yang bisa ditambahkan : 0",
        "Nama : Number 2 \nTotal Jumlah Lahan : 1 \nJumlah Lahan yang sudah terindetifikasi : 1 \nLahan yang bisa ditambahkan : 1",
        "Nama : Number 3 \nTotal Jumlah Lahan : 3 \nJumlah Lahan yang sudah teridentifikasi : 3 \nLahan yang bisa ditambahkan : 0",
        "Nama : Number 4 \nTotal Jumlah Lahan : 2 \nJumlah Lahan yang sudah terindetifikasi : 2 \nLahan yang bisa ditambahkan : 1"
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