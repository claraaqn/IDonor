package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TelaLogin : AppCompatActivity() {

    private lateinit var emailUser: EditText
    private lateinit var senhaUser: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        auth = Firebase.auth
        emailUser = findViewById(R.id.editTextText)
        senhaUser = findViewById(R.id.senha)

        val buttonIrParaInstituicoes: Button = findViewById(R.id.button)

        buttonIrParaInstituicoes.setOnClickListener {
            val email = emailUser.text.toString()
            val password = senhaUser.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        updateUI(null)
                    }
                }
        }

        val voltar: View = findViewById(R.id.voltar)
        voltar.setOnClickListener {
            val intent = Intent(this@TelaLogin, TelaInicial::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    companion object {
        const val TAG = "TelaLogin"
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val sharedPreferences = getSharedPreferences("USER_PREFS", MODE_PRIVATE)
            val nomeUsuario = sharedPreferences.getString("NOME", "")

            Toast.makeText(
                this, "Bem-vindo(a), $nomeUsuario!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@TelaLogin, TelaInicialActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(
                this, "Adicione o seu e-mail e a sua senha.", Toast.LENGTH_SHORT).show()
        }
    }
}

