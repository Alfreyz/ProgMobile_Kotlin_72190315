package com.example.progmobile_kotlin_72190315.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobile_kotlin_72190315.CRUD.GetPetaniActivity
import com.example.progmobile_kotlin_72190315.CRUD.UpdatePetaniActivity
import com.example.progmobile_kotlin_72190315.R
import com.example.progmobile_kotlin_72190315.model.DataItem
import com.example.progmobile_kotlin_72190315.model.ResponseAddPetani
import com.example.progmobile_kotlin_72190315.model.ResponsePetani
import com.example.progmobile_kotlin_72190315.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResponsePetaniAdapater(val petani: List<DataItem>?): RecyclerView.Adapter<ResponsePetaniAdapater.ResponsePetaniHolder>() {
    lateinit var mContext : Context
    lateinit var adapter : ResponsePetaniAdapater
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ResponsePetaniAdapater.ResponsePetaniHolder {
            return ResponsePetaniHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_petani, parent, false))
        }
        override fun onBindViewHolder(holder: ResponsePetaniAdapater.ResponsePetaniHolder, position: Int) {
            holder.bindPetani(petani?.get(position))
            var popupMenu = PopupMenu(holder.itemView.context, holder.itemView)
            popupMenu.menu.add(Menu.NONE,0,0,"Edit")
            popupMenu.menu.add(Menu.NONE,1,1,"Delete")
            popupMenu.setOnMenuItemClickListener { menuItem ->
                val id = menuItem.itemId
                mContext = holder.itemView.context
                if (id==0){
                    var bundle = Bundle()
                    var idTmp = petani?.get(position)?.id.toString()
                    var namaTmp = petani?.get(position)?.nama.toString()
                    var alamatTmp = petani?.get(position)?.alamat.toString()
                    var provinsiTmp = petani?.get(position)?.provinsi.toString()
                    var kabupatenTmp = petani?.get(position)?.kabupaten.toString()
                    var kecamatanTmp = petani?.get(position)?.kecamatan.toString()
                    var kelurahanTmp = petani?.get(position)?.kelurahan.toString()
                    var namaistriTmp = petani?.get(position)?.namaIstri.toString()
                    var jumlahlahanTmp = petani?.get(position)?.jumlahLahan.toString()
                    var fotoTmp = petani?.get(position)?.foto.toString()
                    bundle.putString("idPetani",idTmp)
                    bundle.putString("namaPetani",namaTmp)
                    bundle.putString("alamatPetani",alamatTmp)
                    bundle.putString("provinsiPetani",provinsiTmp)
                    bundle.putString("kabupatenPetani",kabupatenTmp)
                    bundle.putString("kecamatanPetani",kecamatanTmp)
                    bundle.putString("kelurahanPetani",kelurahanTmp)
                    bundle.putString("namaistriPetani",namaistriTmp)
                    bundle.putString("jumlahlahanPetani",jumlahlahanTmp)
                    bundle.putString("fotoPetani",fotoTmp)
                    var intent = Intent(mContext, UpdatePetaniActivity::class.java)
                    intent.putExtras(bundle)
                    mContext.startActivity(intent)
                }
                else if(id==1){
                    var idTmp = petani?.get(position)?.id.toString()
                    NetworkConfig().getService()
                        .deletePetani(idTmp.toInt())
                        .enqueue(object : Callback<ResponseAddPetani?> {
                            override fun onFailure(call: Call<ResponseAddPetani?>, t:
                            Throwable) {
                                Toast.makeText(holder.itemView.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                            }
                            override fun onResponse(
                                call: Call<ResponseAddPetani?>,
                                response: Response<ResponseAddPetani?>
                            ) {
                                Toast.makeText(
                                    holder.itemView.context,
                                    "Berhasil Hapus Data",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                (mContext as GetPetaniActivity).finish()
                                var intent = Intent(mContext, GetPetaniActivity::class.java)
                                mContext.startActivity(intent)
                                }
                        })
                }
                false
            }
            holder.itemView.setOnClickListener((View.OnClickListener { view ->
                popupMenu.show()
            }))
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
