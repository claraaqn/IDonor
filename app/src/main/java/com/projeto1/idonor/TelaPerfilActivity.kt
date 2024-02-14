package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaPerfilActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_perfil)

        val edicaoPerfilButton: Button = findViewById(R.id.edicao_perfil)
        val voltarTelaInicialButton: Button = findViewById(R.id.voltar_a_tela_inical)
        val dadosCadastraisButton: Button = findViewById(R.id.dados_cadratais)
        val meusEnderecosButton: Button = findViewById(R.id.meus_enderecos)
        val impactoBotaoButton: Button = findViewById(R.id.impacto_botao)
        val sairBotaoButton: Button = findViewById(R.id.sair_botao)

        val sharedPreferences = getSharedPreferences("USER_PREFS", MODE_PRIVATE)
        val nomeUsuario = sharedPreferences.getString("NOME", "")
        val emailUsuario = sharedPreferences.getString("EMAIL", "")
        val telefoneUsuario = sharedPreferences.getString("TELEFONE", "")

        val textViewNome: TextView = findViewById(R.id.nome_edit)
        val textViewEmail: TextView = findViewById(R.id.email_edit)
        val textViewTelefone: TextView = findViewById(R.id.telefone)

        textViewNome.text = nomeUsuario
        textViewEmail.text = emailUsuario
        textViewTelefone.text = telefoneUsuario

        edicaoPerfilButton.setOnClickListener {
            // Lógica quando o botão de edição é clicado
        }

        fun voltarTelaInicial(view: View) {
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        }

        voltarTelaInicialButton.setOnClickListener {
            voltarTelaInicial(it)
        }

        dadosCadastraisButton.setOnClickListener {
            // Lógica quando o botão dados cadastrais é clicado
        }

        meusEnderecosButton.setOnClickListener {
            // Lógica quando o botão meus endereços é clicado
        }

        fun irParaTelaImpacto(view: View) {
            val intent = Intent(this, TelaImpactoActivity::class.java)
            startActivity(intent)
        }

        impactoBotaoButton.setOnClickListener {
            irParaTelaImpacto(it)
        }

        sairBotaoButton.setOnClickListener {
            // Lógica quando o botão sair é clicado
        }
    }
}