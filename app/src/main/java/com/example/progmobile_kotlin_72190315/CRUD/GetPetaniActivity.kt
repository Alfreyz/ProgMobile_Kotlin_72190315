package com.example.progmobile_kotlin_72190315.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobile_kotlin_72190315.R
import com.example.progmobile_kotlin_72190315.SampleListView
import com.example.progmobile_kotlin_72190315.adapter.ResponsePetaniAdapater
import com.example.progmobile_kotlin_72190315.model.DataItem
import com.example.progmobile_kotlin_72190315.model.ResponsePetani
import com.example.progmobile_kotlin_72190315.network.NetworkConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPetaniActivity : AppCompatActivity() {
    lateinit var rvpetani : RecyclerView
    lateinit var fabaddpetani : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_petani)
            rvpetani = findViewById(R.id.rvPetani)
            fabaddpetani = findViewById(R.id.fabAddPetani)
            NetworkConfig().getService()
                .getPetaniAll()
                .enqueue(object : Callback<ResponsePetani?>{
                    override fun onFailure(call: Call<ResponsePetani?>, t:
                    Throwable) {
                        Toast.makeText(this@GetPetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(
                        call: Call<ResponsePetani?>,
                        response: Response<ResponsePetani?>
                    ) {
                        rvpetani.apply{
                            layoutManager = LinearLayoutManager(this@GetPetaniActivity)
                            adapter = ResponsePetaniAdapater(response.body()?.data as List<DataItem>?)
                        }
                    }
                })
        fabaddpetani.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@GetPetaniActivity, AddPetaniActivity::class.java)
            startActivity(intent)
        })
        }
    }