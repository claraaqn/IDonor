package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore

class TelaConfirmacao : AppCompatActivity(),  OnMapReadyCallback{

    private var dataBase = FirebaseFirestore.getInstance()

    private lateinit var doacoesTxtView: TextView
    private lateinit var doacoesTxtView2: TextView
    private lateinit var doacoesTxtView3: TextView

    private var mGoogleMap:GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_confirmacao)
        val contadordoacoes = 1

        var btnVoltar = findViewById<Button>(R.id.botaovoltarconfirmacao)
        var btnDoar = findViewById<Button>(R.id.botaodoarconfirmacao)

        val botaover = findViewById<Button>(R.id.ver)
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

        val doacoesView = findViewById<TextView>(R.id.doacoestxt)
        val doacoesView2 = findViewById<TextView>(R.id.doacoestxt2)
        val doacoesView3 = findViewById<TextView>(R.id.doacoestxt3)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        botaover.setOnClickListener {

            dataBase.collection("doacoes").document("doacao")
                .addSnapshotListener { documento, error ->
                    if (documento != null) {

                        val quantidade = documento.getLong("quantidade")

                        doacoesView.text = documento.getString("tipoDoItem")
                        doacoesView2.text = quantidade.toString()
                        doacoesView3.text = documento.getString("estadoDoItem")
                    }
                    else{}
            }
        }

        botaoremover.setOnClickListener {
            doacoesView.clearComposingText()
            doacoesView2.clearComposingText()
            doacoesView3.clearComposingText()
        }




    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        mGoogleMap?.addMarker(MarkerOptions()
            .position(LatLng(-8.3338946,-36.4264714))
            .title("Lar Dos Idosos")
        )


    }
}