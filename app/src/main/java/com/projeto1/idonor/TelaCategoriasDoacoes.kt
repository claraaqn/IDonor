package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TelaCategoriasDoacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_categorias_doacoes)

        var btnVoltar = findViewById<Button>(R.id.botaovoltarcategorias)
        var btnAlimentos = findViewById<Button>(R.id.botaoalimentos)
        var btnDinheiro = findViewById<Button>(R.id.botaodinheiro)
        var btnVestimenta = findViewById<Button>(R.id.botaovestimentas)
        var btnVoluntario = findViewById<Button>(R.id.botaovoluntario)

        fun irTelaInstituicao(view: View){
            var intent = Intent(this, TelaInstituicaoInfo::class.java)
            startActivity(intent)
        }
        btnVoltar.setOnClickListener{
            irTelaInstituicao(it)
        }
        fun irEspecificacaoVestimenta(view: View){
            var intent = Intent(this, TelaEspecificacao::class.java)
            startActivity(intent)
        }
        btnVestimenta.setOnClickListener{
            irEspecificacaoVestimenta(it)
        }
        btnAlimentos.setOnClickListener{
            // Código a ser executado
        }
        btnDinheiro.setOnClickListener{
            // Código a ser executado
        }
        btnVoluntario.setOnClickListener{
            // Código a ser executado
        }



    }
}