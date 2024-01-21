package com.projeto1.idonor

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial)

        // Referencie os botões usando seus IDs
        val btnAjuda = findViewById<Button>(R.id.ajuda)
        val btnFecharCampanha = findViewById<Button>(R.id.fechar_campanha)
        val btnIgreja = findViewById<Button>(R.id.igreja)
        val btnInfantil = findViewById<Button>(R.id.infantil)
        val btnBairro = findViewById<Button>(R.id.bairro)
        // Adicione mais botões conforme necessário

        // Configure o que acontece quando um botão é clicado
        btnAjuda.setOnClickListener {
            // Código a ser executado quando o botão Ajuda é clicado
            // Por exemplo, abrir outra atividade ou executar alguma lógica
        }

        btnFecharCampanha.setOnClickListener {
            // Código a ser executado quando o botão Fechar Campanha é clicado
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
        // Adicione mais blocos de código conforme necessário para outros botões
    }
}