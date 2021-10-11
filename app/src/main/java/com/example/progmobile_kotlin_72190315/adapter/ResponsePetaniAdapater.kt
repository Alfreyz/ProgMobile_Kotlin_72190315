package com.example.progmobile_kotlin_72190315.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobile_kotlin_72190315.R
import com.example.progmobile_kotlin_72190315.model.DataItem



class ResponsePetaniAdapater(val petani: List<DataItem>?): RecyclerView.Adapter<ResponsePetaniAdapater.ResponsePetaniHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ResponsePetaniAdapater.ResponsePetaniHolder {
            return ResponsePetaniHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_petani, parent, false))
        }
        override fun onBindViewHolder(holder: ResponsePetaniAdapater.ResponsePetaniHolder, position: Int) {
            holder.bindPetani(petani?.get(position))
        }
        override fun getItemCount(): Int {
            return petani?.size?:0
        }

        class ResponsePetaniHolder(view: View) : RecyclerView.ViewHolder(view) {
            lateinit var txtNama : TextView
            lateinit var txtJumlahLahan : TextView
            lateinit var txtAlamat : TextView
            lateinit var txtKelurahan : TextView

            fun bindPetani(petani: DataItem?) {
                itemView.apply {
                    txtNama = findViewById(R.id.nama)
                    txtJumlahLahan = findViewById(R.id.jumlah_lahan)
                    txtAlamat = findViewById(R.id.alamat)
                    txtKelurahan = findViewById(R.id.kelurahan)

                    txtNama.text = petani?.nama
                    txtJumlahLahan.text = petani?.jumlahLahan
                    txtAlamat.text = petani?.alamat
                    txtKelurahan.text = petani?.kelurahan
                }
            }
        }
    }
