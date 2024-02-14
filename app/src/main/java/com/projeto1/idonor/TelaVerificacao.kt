package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlin.random.Random

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
        val codigoVerificacao = gerarCodigoVerificacao()
        val codigoDigitado = codigo.text.toString()
        if (codigoVerificacao.isNotEmpty()) {
            if (codigoVerificacao == codigoDigitado) {
                Toast.makeText(this, "Código verificado com sucesso.", Toast.LENGTH_SHORT).show()

                // Após verificar o código com sucesso, redirecione para a tela inicial
                val intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
                finish() // Finaliza a atividade atual para que o usuário não possa voltar para a tela de verificação pressionando o botão "Voltar"
            } else {
                Toast.makeText(
                    this,
                    "Por favor, insira o código de verificação.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun gerarCodigoVerificacao(): String {
        // Gera um código de verificação de 6 dígitos
        return "%06d".format(Random.nextInt(0, 999999))
    }
}

