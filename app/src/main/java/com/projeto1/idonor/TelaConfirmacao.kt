package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class TelaConfirmacao : AppCompatActivity(),  OnMapReadyCallback{
    private var mGoogleMap:GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_confirmacao)

        var btnVoltar = findViewById<Button>(R.id.botaovoltarconfirmacao)
        var btnDoar = findViewById<Button>(R.id.botaodoarconfirmacao)

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

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        mGoogleMap?.addMarker(MarkerOptions()
            .position(LatLng(-8.3338946,-36.4264714))
            .title("Lar Dos Idosos")
        )


    }
}