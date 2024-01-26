package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class TelaInstituicaoDesejos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_instituicao_desejos)

        val btnVoltar = findViewById<Button>(R.id.botaovoltarwishlist)
        val btnInfo = findViewById<Button>(R.id.botaoinfowishlist)
        val btnContato = findViewById<Button>(R.id.botaocontatowishlist)
        val btnAvaliacao = findViewById<Button>(R.id.botaoavaliacaowishlist)
        val btnDoarWishlist = findViewById<Button>(R.id.botaodoarwishlist)

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

        fun irTelaContato(view: View){
            val intent = Intent(this, TelaInstituicaoContato::class.java)
            startActivity(intent)
        }
        btnContato.setOnClickListener{
            irTelaContato(it)
        }

        fun irTelaAvaliacao(view: View){
            val intent = Intent(this, TelaInstituicaoAvaliacao::class.java)
            startActivity(intent)
        }
        btnAvaliacao.setOnClickListener{
            irTelaAvaliacao(it)
        }

        fun irCategoriasDoar(view: View){
            val intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        btnDoarWishlist.setOnClickListener{
            irCategoriasDoar(it)
        }








    }
}