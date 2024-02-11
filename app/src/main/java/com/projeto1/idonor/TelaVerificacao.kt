package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth

class TelaVerificacao : AppCompatActivity() {

    private lateinit var codigo: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teladeverificacao)

        codigo = findViewById(R.id.codigo)
        auth = FirebaseAuth.getInstance()

        val buttonVerificarCodigo: Button = findViewById(R.id.buttonCadastro)
        buttonVerificarCodigo.setOnClickListener {
            verificarCodigo()
        }

        val buttonVoltarCadastroVe: View = findViewById(R.id.voltarTelaVerificar)

        buttonVoltarCadastroVe.setOnClickListener {
            val intent = Intent(this@TelaVerificacao, TelaCadastro::class.java)
            startActivity(intent)
        }
    }

    private fun verificarCodigo() {
        val codigoverificar = codigo.text.toString()

        if (codigoverificar.isNotEmpty()) {
            val user = auth.currentUser
            val credential = EmailAuthProvider.getCredential(user?.email ?: "", codigoverificar)

            user?.reauthenticate(credential)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Código de verificação correto, fazer o que for necessário (ex: redirecionar para a próxima tela)
                    } else {
                        // Código de verificação incorreto
                        Toast.makeText(this, "Código de verificação incorreto.", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Por favor, insira o código de verificação.", Toast.LENGTH_SHORT).show()
        }
    }
}
