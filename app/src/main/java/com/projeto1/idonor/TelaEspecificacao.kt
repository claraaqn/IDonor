package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TelaEspecificacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_especificacao)

        var btnVoltar = findViewById<Button>(R.id.botaovoltarespecificacao)
        var btnAvancar = findViewById<Button>(R.id.botaoavancar)

        fun irCategorias(view: View){
            var intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        btnVoltar.setOnClickListener{
            irCategorias(it)
        }

        fun irCheckOut(view: View){
            var intent = Intent(this, TelaConfirmacao::class.java)
            startActivity(intent)
        }
        btnAvancar.setOnClickListener{
            irCheckOut(it)
        }


    }
}



