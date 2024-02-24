package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore

class TelaConfirmacao : AppCompatActivity(),  OnMapReadyCallback{

    private var dataBase = FirebaseFirestore.getInstance()

    private lateinit var doacoesTxtView1: TextView
    private lateinit var doacoesTxtView2: TextView
    private lateinit var doacoesTxtView3: TextView

    private var mGoogleMap:GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_confirmacao)


        var btnVoltar = findViewById<Button>(R.id.botaovoltarconfirmacao)
        var btnDoar = findViewById<Button>(R.id.botaodoarconfirmacao)


        val botaoremover = findViewById<Button>(R.id.remover)

        fun irEspecificacao(view: View){
            var intent = Intent(this, TelaEspecificacao::class.java)
            startActivity(intent)
        }
        btnVoltar.setOnClickListener{
            irEspecificacao(it)
        }

        fun irAgradecimento(view: View){
            var intent = Intent(this, TelaAgradecimentoActivity::class.java)
            startActivity(intent)
        }
        btnDoar.setOnClickListener{
            irAgradecimento(it)
        }

        val doacoesView1 = findViewById<TextView>(R.id.doacoestxt1)
        val doacoesView2 = findViewById<TextView>(R.id.doacoestxt2)
        val doacoesView3 = findViewById<TextView>(R.id.doacoestxt3)


        val doacaovazia = ""

        var contadordoacoes = 4

        val sharedPreferences = getSharedPreferences("DOACAO", MODE_PRIVATE)
        val doacao1 = sharedPreferences.getString("DOACAO1","")
        val doacao2 = sharedPreferences.getString("DOACAO2", "")
        val doacao3 = sharedPreferences.getString("DOACAO3", "")
        doacoesView1.text = doacao1
        doacoesView2.text = doacao2
        doacoesView3.text = doacao3

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)




        botaoremover.setOnClickListener {
            if(contadordoacoes == 4){
                doacoesView3.text = doacaovazia
                contadordoacoes--
            }
            else if (contadordoacoes == 3){
                doacoesView2.text = doacaovazia
                contadordoacoes--
            }
            else if (contadordoacoes == 2){
                doacoesView1.text = doacaovazia
            }
            else{contadordoacoes--}



        }



    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
        val latLong : LatLng = LatLng(-8.3338946,-36.4264714)
        val newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLong,15f)
        mGoogleMap?.animateCamera(newLatLngZoom)

        mGoogleMap?.addMarker(MarkerOptions()
            .position(LatLng(-8.3338946,-36.4264714))
            .title("Lar Dos Idosos")
        )
    }





}