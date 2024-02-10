package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class TelaImpactoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_impacto)

        // Inicialize os botões
        val btnVoltarImpacto = findViewById<Button>(R.id.voltar_impacto)
        val btnSetaSemanaDireita = findViewById<Button>(R.id.seta_semana_direita)
        val btnMes = findViewById<Button>(R.id.mes)
        val btnAno = findViewById<Button>(R.id.ano)
        val btnSemana = findViewById<Button>(R.id.semana)

        fun voltarTelaPerfil(view: View) {
            val intent = Intent(this, TelaPerfilActivity::class.java)
            startActivity(intent)
        }

        btnVoltarImpacto.setOnClickListener {
            voltarTelaPerfil(it)
        }


        btnSetaSemanaDireita.setOnClickListener {
            // Implemente a lógica desejada quando o botão de seta à direita é clicado
        }

        btnMes.setOnClickListener {
            // Implemente a lógica desejada quando o botão de mês é clicado
        }

        btnAno.setOnClickListener {
            // Implemente a lógica desejada quando o botão de ano é clicado
        }

        btnSemana.setOnClickListener {
            // Implemente a lógica desejada quando o botão de semana é clicado
        }
    }
}