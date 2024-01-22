package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val buttonIrParaOutraTelaLogin: Button = findViewById(R.id.button)

        buttonIrParaOutraTelaLogin.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaLogin::class.java)

            startActivity(intent)

            val buttonIrParaOutraTelaCadastro: Button = findViewById(R.id.button2)

            buttonIrParaOutraTelaCadastro.setOnClickListener {
                val intent2 = Intent(this@TelaInicial, TelaCadastro::class.java)

                startActivity(intent2)
            }
        }
    }
}
