package com.example.progmobile_kotlin_72190315

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SampleList : AppCompatActivity() {
    lateinit var btnshowlist : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)
        btnshowlist = findViewById(R.id.btnShowList)
        btnshowlist.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleListView::class.java)
            startActivity(intent)
        })
    }
}