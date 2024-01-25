package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TelaVerificacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teladeverificacao)

        val buttonIrParaInstituicoes: Button = findViewById(R.id.buttonCadastro)

        buttonIrParaInstituicoes.setOnClickListener {
            val intent = Intent(this@TelaVerificacao, TelaInicialActivity::class.java)

            startActivity(intent)
        }
        val buttonVoltarCadastroVe: View = findViewById(R.id.voltarTelaVerificar)

        buttonVoltarCadastroVe.setOnClickListener {
            val intent = Intent(this@TelaVerificacao, TelaCadastro::class.java)

            startActivity(intent)
        }
    }
}
