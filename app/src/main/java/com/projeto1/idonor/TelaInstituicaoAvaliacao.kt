package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class TelaInstituicaoAvaliacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_instituicao_avaliacao)

        var btnVoltar = findViewById<Button>(R.id.botaovoltaravaliacao)
        var btnInfo = findViewById<Button>(R.id.botaoinfoavaliacao)
        val btnContato = findViewById<Button>(R.id.botaocontatoavaliacao)
        val btnWishList = findViewById<Button>(R.id.botaowishlistavaliacao)
        val btnDoarAvaliacao = findViewById<Button>(R.id.botaodoaravaliacao)

        fun irTelaInicial(view: View){
            var intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        }
        btnVoltar.setOnClickListener{
            irTelaInicial(it)
        }

        fun irTelaInfo(view: View){
            var intent = Intent(this, TelaInstituicaoInfo::class.java)
            startActivity(intent)
        }
        btnInfo.setOnClickListener{
            irTelaInfo(it)
        }

        fun irTelaWishList(view: View){
            var intent = Intent(this, TelaInstituicaoDesejos::class.java)
            startActivity(intent)
        }
        btnWishList.setOnClickListener{
            irTelaWishList(it)
        }

        fun irTelaContato(view: View){
            var intent = Intent(this, TelaInstituicaoContato::class.java)
            startActivity(intent)
        }
        btnContato.setOnClickListener{
            irTelaContato(it)
        }

        fun irTelaCategorias(view: View){
            var intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        btnDoarAvaliacao.setOnClickListener{
            irTelaCategorias(it)
        }



    }
}