package com.example.progmobile_kotlin_72190315

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ServiceActivity : AppCompatActivity() {
    lateinit var btngetapi : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        btngetapi = findViewById(R.id.btnGetAPI)
        btngetapi.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@ServiceActivity, GetAPIActivity::class.java)
            startActivity(intent)
        })
    }
}