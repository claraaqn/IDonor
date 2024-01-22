package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaAgradecimentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_agradecimeneto)

        val telaInicialButton: Button = findViewById(R.id.voltar_a_tela_inical)

        telaInicialButton.setOnClickListener {
            irParaTelaInicial(it)
        }
    }

    fun irParaTelaInicial(view: View) {
        val intent = Intent(this, TelaInicialActivity::class.java)
        startActivity(intent)
    }
}
