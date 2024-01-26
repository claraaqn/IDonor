package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TelaInstituicaoContato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_instituicao_contato)

        val btnVoltar = findViewById<Button>(R.id.botaovoltarcontato)
        val btnInfo = findViewById<Button>(R.id.botaoinfocontato)
        val btnWishList = findViewById<Button>(R.id.botaowishlistcontato)
        val btnAvaliacao = findViewById<Button>(R.id.botaoavaliacaocontato)
        val btnDoarContato = findViewById<Button>(R.id.botaodoarcontato)

        fun irTelaInicial(view: View){
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        }
        btnVoltar.setOnClickListener{
            irTelaInicial(it)
        }

        fun irTelaInfo(view: View){
            val intent = Intent(this, TelaInstituicaoInfo::class.java)
            startActivity(intent)
        }
        btnInfo.setOnClickListener{
            irTelaInfo(it)
        }

        fun irTelaWishList(view: View){
            val intent = Intent(this, TelaInstituicaoDesejos::class.java)
            startActivity(intent)
        }
        btnWishList.setOnClickListener{
            irTelaWishList(it)
        }

        fun irTelaAvaliacao(view: View){
            val intent = Intent(this, TelaInstituicaoAvaliacao::class.java)
            startActivity(intent)
        }
        btnAvaliacao.setOnClickListener{
            irTelaAvaliacao(it)
        }

        fun irTelaCategorias(view: View){
            val intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        btnDoarContato.setOnClickListener{
            irTelaCategorias(it)
        }

    }
}