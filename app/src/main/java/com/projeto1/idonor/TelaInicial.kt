package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.projeto1.idonor.R


class TelaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val buttonIrParaOutraTelaLogin: Button = findViewById(R.id.button)
        buttonIrParaOutraTelaLogin.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaLogin::class.java)
            startActivity(intent)
        }

        val buttonIrParaTelaCadastro: Button = findViewById(R.id.button2)
        buttonIrParaTelaCadastro.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaCadastro::class.java)
            startActivity(intent)
        }

        val buttonIrParaInstituicoes: Button = findViewById(R.id.conhecer_as)
        buttonIrParaInstituicoes.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaInicialActivity::class.java)
            startActivity(intent)
        }
    }
}

