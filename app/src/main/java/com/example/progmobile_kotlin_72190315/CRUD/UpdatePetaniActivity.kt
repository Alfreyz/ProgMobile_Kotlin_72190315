package com.example.progmobile_kotlin_72190315.CRUD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.progmobile_kotlin_72190315.R
import com.example.progmobile_kotlin_72190315.model.DataItem
import com.example.progmobile_kotlin_72190315.model.ResponseAddPetani
import com.example.progmobile_kotlin_72190315.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePetaniActivity : AppCompatActivity() {
    lateinit var edId : EditText
    lateinit var edNama : EditText
    lateinit var edAlamat : EditText
    lateinit var edProvinsi : EditText
    lateinit var edKabupaten : EditText
    lateinit var edKecamatan : EditText
    lateinit var edKelurahan : EditText
    lateinit var edNamaIstri : EditText
    lateinit var edJumlahLahan : EditText
    lateinit var edfoto : EditText
    lateinit var btnSimpanPetani : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_petani)
        edId = findViewById(R.id.edId)
        edNama = findViewById(R.id.edNama)
        edAlamat = findViewById(R.id.edAlamat)
        edProvinsi = findViewById(R.id.edProvinsi)
        edKabupaten = findViewById(R.id.edKabupaten)
        edKecamatan = findViewById(R.id.edKecamatan)
        edKelurahan = findViewById(R.id.edKelurahan)
        edNamaIstri = findViewById(R.id.edNamaIstri)
        edJumlahLahan = findViewById(R.id.edJumlahLahan)
        edfoto = findViewById(R.id.edFoto)
        if (intent.extras != null){
            var bundle: Bundle? = intent.extras
            var strId: String = bundle?.getString("idPetani").toString()
            var strNama: String = bundle?.getString("namaPetani").toString()
            var strAlamat: String = bundle?.getString("alamatPetani").toString()
            var strProvinsi: String = bundle?.getString("provinsiPetani").toString()
            var strKabupaten: String = bundle?.getString("kabupatenPetani").toString()
            var strKecamatan: String = bundle?.getString("kecamatanPetani").toString()
            var strKelurahan: String = bundle?.getString("kelurahanPetani").toString()
            var strNamaIstri: String = bundle?.getString("namaistriPetani").toString()
            var strJumlahLahan: String = bundle?.getString("jumlahlahanPetani").toString()
            var strfoto: String = bundle?.getString("fotoPetani").toString()
            edId.setText(strId)
            edNama.setText(strNama)
            edAlamat.setText(strAlamat)
            edProvinsi.setText(strProvinsi)
            edKabupaten.setText(strKabupaten)
            edKecamatan.setText(strKecamatan)
            edKelurahan.setText(strKelurahan)
            edNamaIstri.setText(strNamaIstri)
            edJumlahLahan.setText(strJumlahLahan)
            edfoto.setText(strfoto)
        }

        btnSimpanPetani = findViewById(R.id.btnSimpanPetani)

        btnSimpanPetani.setOnClickListener(View.OnClickListener { view ->
            var ptn = DataItem()
            ptn.id = edId.text.toString()
            ptn.nama = edNama.text.toString()
            ptn.alamat = edAlamat.text.toString()
            ptn.provinsi = edProvinsi.text.toString()
            ptn.kabupaten = edKabupaten.text.toString()
            ptn.kecamatan = edKecamatan.text.toString()
            ptn.kelurahan = edKelurahan.text.toString()
            ptn.namaIstri = edNamaIstri.text.toString()
            ptn.jumlahLahan = edJumlahLahan.text.toString()
            ptn.foto = edfoto.text.toString()



            NetworkConfig().getService()
                .updatePetani(edId.text.toString().toInt(), ptn)
                .enqueue(object : Callback<ResponseAddPetani?> {
                    override fun onFailure(call: Call<ResponseAddPetani?>, t:
                    Throwable) {
                        Toast.makeText(this@UpdatePetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(
                        call: Call<ResponseAddPetani?>,
                        response: Response<ResponseAddPetani?>
                    ) {
                        Toast.makeText(
                            this@UpdatePetaniActivity,
                            "Berhasil Ubah Data",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })
        })
    }
}