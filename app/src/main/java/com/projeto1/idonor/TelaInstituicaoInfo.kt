package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI


class TelaInstituicaoInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_instituicao_info)

        val botaoInfoVoltarParaInicial : Button = findViewById<Button>(R.id.botaovoltarinfo)
        val botaoDoarInfo : Button = findViewById<Button>(R.id.botaodoarinfo)



        fun voltarTelaInicial(view: View){
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)

        }
        botaoInfoVoltarParaInicial.setOnClickListener{
            voltarTelaInicial(it)
        }


        fun irParaCategorias(view: View){
            val intent = Intent(this, TelaCategoriasDoacoes::class.java)
            startActivity(intent)
        }
        botaoDoarInfo.setOnClickListener{
            irParaCategorias(it)
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerInfo) as NavHostFragment
        //val navController : NavController = navHostFragment.navController
        //NavigationUI.setupActionBarWithNavController(this, navController)

        }

    }
