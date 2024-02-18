package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TelaEspecificacao : AppCompatActivity() {

    private var quantidadeItens = 1
    private lateinit var quantidadeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_especificacao)


        var btnVoltar = findViewById<Button>(R.id.botaovoltarespecificacao)
        var btnAvancar = findViewById<Button>(R.id.botaoavancar)

        fun irCategorias(view: View){
            var intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        btnVoltar.setOnClickListener{
            irCategorias(it)
        }

        fun irCheckOut(view: View){
            var intent = Intent(this, TelaConfirmacao::class.java)
            startActivity(intent)
        }
        btnAvancar.setOnClickListener{
            irCheckOut(it)
        }

        val radioGroup1 = findViewById<RadioGroup>(R.id.radiogroup1espec)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radiogroup2espec)
        val btnAdicionar = findViewById<Button>(R.id.botaoadicionardoacao)

        btnAdicionar.setOnClickListener{
            if(radioGroup1.checkedRadioButtonId != -1 && radioGroup2.checkedRadioButtonId != -1){
                radioGroup1.clearCheck()
                radioGroup2.clearCheck()
                quantidadeItens = 1
                atualizarQuantidade()
            }
            else{
                Toast.makeText(this, "Por favor, selecione o estado e o tipo do item.", Toast.LENGTH_SHORT).show()
            }

        }

        quantidadeTextView = findViewById(R.id.quantidademodificavel)
        val btnmais = findViewById<Button>(R.id.botaoaumentarquantidade)
        val btnmenos = findViewById<Button>(R.id.botaodiminuirquantidade)

        btnmais.setOnClickListener{
            quantidadeItens++
            atualizarQuantidade()
        }

        btnmenos.setOnClickListener{
            quantidadeItens = maxOf(quantidadeItens-1,1)
            atualizarQuantidade()
        }



    }

    private fun atualizarQuantidade(){
        quantidadeTextView.text = quantidadeItens.toString()
    }
}



