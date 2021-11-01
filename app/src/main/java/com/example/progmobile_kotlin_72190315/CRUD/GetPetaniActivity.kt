package com.example.progmobile_kotlin_72190315.CRUD

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobile_kotlin_72190315.LoginActivity
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

    val prefs_name = "session_login"
    lateinit var sharedPref : SharedPreferences

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnLogout ->{
                val editor : SharedPreferences.Editor = sharedPref.edit()
                editor.clear()
                editor.apply()
                finish()
                var intent = Intent(this@GetPetaniActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_petani)
            rvpetani = findViewById(R.id.rvPetani)
            fabaddpetani = findViewById(R.id.fabAddPetani)

            sharedPref = getSharedPreferences(prefs_name, Context.MODE_PRIVATE)

            var tmpEmail = sharedPref.getString("email", null)
            val actionBar = supportActionBar
            actionBar!!.title = "Halaman Admin - " + tmpEmail

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