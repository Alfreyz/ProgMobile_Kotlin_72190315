package com.example.progmobile_kotlin_72190315

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SampleList : AppCompatActivity() {
    lateinit var btnshowlist : Button
    lateinit var btnrecyclelist : Button
    lateinit var btncardview : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)
        btnshowlist = findViewById(R.id.btnShowList)
        btnrecyclelist = findViewById(R.id.btnSampleRV)
        btncardview = findViewById(R.id.btncv)
        btnshowlist.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleListView::class.java)
            startActivity(intent)
        })
        btnrecyclelist.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleRecyclerView::class.java)
            startActivity(intent)
        })
        btncardview.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleCardView::class.java)
            startActivity(intent)
        })
    }
}