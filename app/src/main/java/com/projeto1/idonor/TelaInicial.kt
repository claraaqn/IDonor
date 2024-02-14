package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)


        val buttonLogin: Button = findViewById(R.id.buttonlogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaLogin::class.java)
            startActivity(intent)
        }

        val buttonIrParaCadastro: Button = findViewById(R.id.button2)
        buttonIrParaCadastro.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaCadastro::class.java)
            startActivity(intent)
        }

        val buttonIntituicoes: Button = findViewById(R.id.conhecer_as)
        buttonIntituicoes.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaInicialActivity::class.java)
            startActivity(intent)
        }

        }

}
