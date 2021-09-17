package com.example.progmobile_kotlin_72190315

import com.example.progmobile_kotlin_72190315.model.Petani

object dataPetani {
    private val user = arrayOf(
        "F 1",
        "F 2",
        "F 3",
        "F 4"
    )
    private val nama = arrayOf(
        "Ferry",
        "Ferry",
        "Ferry",
        "Ferry"
    )
    private val jumlahLahan = arrayOf(
        "100",
        "50",
        "90",
        "70"
    )
    private val identifikasi = arrayOf(
        "80",
        "55",
        "35",
        "60"
    )
    private val tambahLahan = arrayOf(
        "60",
        "75",
        "80",
        "95"
    )

    val listData: ArrayList<Petani>
        get() {
            val list = arrayListOf<Petani>()
            for (position in user.indices) {
                val petani = Petani()
                petani.user = user[position]
                petani.nama = nama[position]
                petani.jumlahLahan = jumlahLahan[position]
                petani.identifikasi = identifikasi[position]
                petani.tambahLahan = tambahLahan[position]
                list.add(petani)
            }
            return list
        }
}