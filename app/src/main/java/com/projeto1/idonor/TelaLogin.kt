package com.projeto1.idonor

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class TelaLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var binding: TelaLogin? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        auth = Firebase.auth

        val buttonVoltarParaTelaLogin: View = findViewById(R.id.voltar)

        buttonVoltarParaTelaLogin.setOnClickListener{
            val intent = Intent(this@TelaLogin, TelaInicial::class.java)

            startActivity(intent)
        }
        val buttonIrParaOutraTelaCadastro: Button = findViewById(R.id.button)

        buttonIrParaOutraTelaCadastro.setOnClickListener {
            val intent = Intent(this@TelaLogin, TelaInicialActivity::class.java)

            startActivity(intent)
        }
    }

    fun createUserWithEmailAndPassaword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d(ContentValues.TAG, "createUserWithEmailAndPassword: Success")
                val user = auth.currentUser
            } else {
                Log.w(ContentValues.TAG, "createUserWithEmailAndPassword: Failure", task.exception)
                Toast.makeText(baseContext, "Authentication Failure", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun signInWithEmailAndPassword(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Log.d(ContentValues.TAG, "signInWithEmailAndPassword: Success")
                val user = auth.currentUser
            }else{
                Log.w(ContentValues.TAG, "signInWithEmailAndPassword: Failure", task.exception)
                Toast.makeText(baseContext, "Authentication Failure", Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object {
        private var Tag =  "EmailAndPassword"
    }

    override fun onDestroy(){
        super.onDestroy()
        binding = null
    }

}