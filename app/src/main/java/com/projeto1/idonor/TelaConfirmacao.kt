package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TelaConfirmacao : AppCompatActivity() {
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

    }
}