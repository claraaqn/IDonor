package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teladecadastro)

        val buttonIrParaOutraTelaVerificar: Button = findViewById(R.id.button)

        buttonIrParaOutraTelaVerificar.setOnClickListener {
            val intent = Intent(this@TelaCadastro, TelaVerificacao::class.java)

            startActivity(intent)
        }
    }
}