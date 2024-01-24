package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial)

        val btnAjuda = findViewById<Button>(R.id.ajuda)
        val btnFecharCampanha = findViewById<Button>(R.id.fechar_campanha)
        val btnLarIdosos = findViewById<Button>(R.id.lados_idosos)
        val btnIgreja = findViewById<Button>(R.id.igreja)
        val btnInfantil = findViewById<Button>(R.id.infantil)
        val btnBairro = findViewById<Button>(R.id.bairro)
        val btnPerfil = findViewById<Button>(R.id.user)

        btnAjuda.setOnClickListener {
            // Código a ser executado quando o botão Ajuda é clicado
            // Por exemplo, abrir outra atividade ou executar alguma lógica
        }

        btnFecharCampanha.setOnClickListener {
            // Código a ser executado quando o botão Fechar Campanha é clicado
        }

        fun abrirTelaPerfil(view: View) {
            val intent = Intent(this, TelaPerfilActivity::class.java)
            startActivity(intent)
        }

        btnLarIdosos.setOnClickListener {

        }

        btnIgreja.setOnClickListener {
            // Código a ser executado quando o botão Igreja é clicado
        }

        btnInfantil.setOnClickListener {
            // Código a ser executado quando o botão Infantil é clicado
        }

        btnBairro.setOnClickListener {
            // Código a ser executado quando o botão Bairro é clicado
        }

        btnPerfil.setOnClickListener() {
            abrirTelaPerfil(it)
        }
    }
}