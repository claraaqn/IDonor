package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TelaAgradecimentoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial)
    }
    fun irParaTelaInicial(view: View) {
        val intent = Intent(this, TelaInicialActivity::class.java)
        startActivity(intent)
    }
}