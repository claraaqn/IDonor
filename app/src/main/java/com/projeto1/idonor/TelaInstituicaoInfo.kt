package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button


class TelaInstituicaoInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_instituicao_info)

        val botaoInfoVoltarParaInicial : Button = findViewById<Button>(R.id.botaovoltarinfo)
        val botaoInfoParaContato : Button = findViewById<Button>(R.id.botaocontatoinfo)
        val botaoInfoParaDesejos : Button = findViewById<Button>(R.id.botaowishlistinfo)
        val botaoInfoParaAvaliacao : Button = findViewById<Button>(R.id.botaoavaliacaoinfo)
        val botaoDoarInfo : Button = findViewById<Button>(R.id.botaodoarinfo)


        fun voltarTelaInicial(view: View){
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)

        }
        botaoInfoVoltarParaInicial.setOnClickListener{
            voltarTelaInicial(it)
        }

        fun irTelaDesejo(view: View){
            val intent = Intent(this, TelaInstituicaoDesejos::class.java)
            startActivity(intent)
        }
        botaoInfoParaDesejos.setOnClickListener{
            irTelaDesejo(it)
        }

        fun irTelaContato(view: View){
            val intent = Intent(this, TelaInstituicaoContato::class.java)
            startActivity(intent)
        }
        botaoInfoParaContato.setOnClickListener{
            irTelaContato(it)
        }

        fun irTelaAvaliacao(view: View){
            val intent = Intent(this, TelaInstituicaoAvaliacao::class.java)
            startActivity(intent)
        }
        botaoInfoParaAvaliacao.setOnClickListener{
            irTelaAvaliacao(it)
        }

        fun irParaCategorias(view: View){
            val intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        botaoDoarInfo.setOnClickListener{
            irParaCategorias(it)
        }

    }
}