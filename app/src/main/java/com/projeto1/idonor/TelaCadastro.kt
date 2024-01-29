package com.projeto1.idonor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TelaCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teladecadastro)

            val user = Firebase.auth.currentUser
             user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email
            val telefone = it.phoneNumber

            // Check if user's email is verified
            val emailVerified = it.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = it.uid

             val user = Firebase.auth.currentUser
             val newPassword = "SOME-SECURE-PASSWORD"

             user!!.updatePassword(newPassword)
                 .addOnCompleteListener { task ->
                     if (task.isSuccessful) {
                         Log.d(TAG, "User password updated.")
                     }
                 }
        }



        val buttonIrParaOutraTelaVerificar: Button = findViewById(R.id.button)

        buttonIrParaOutraTelaVerificar.setOnClickListener {
            val intent = Intent(this@TelaCadastro, TelaVerificacao::class.java)

            startActivity(intent)
        }
        val buttonIrParaVoltar: View = findViewById(R.id.voltar)

        buttonIrParaVoltar.setOnClickListener {
            val intent = Intent(this@TelaCadastro, TelaInicial::class.java)

            startActivity(intent)
        }


    }
    companion object {
        private const val TAG = "TelaCadastro"
    }
}