package com.projeto1.idonor

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TelaLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)


        val buttonIrParaOutraTelaLogin: Button = this.findViewById(R.id.button)

        buttonIrParaOutraTelaLogin.setOnClickListener {
            val intent = Intent(this@TelaLogin, TelaInicialActivity::class.java)
            startActivity(intent)
        }

    }

}

