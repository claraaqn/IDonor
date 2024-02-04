package com.projeto1.idonor

import TelaInicial
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser

class TelaCadastro : AppCompatActivity() {


    private lateinit var nomeUser: EditText
    private lateinit var emailUser: EditText
    private lateinit var senhaUser: EditText
    private lateinit var telefoneUser: EditText
    private lateinit var enderecoUser: EditText
    private lateinit var dataUser: EditText
    private lateinit var button: Button
    private val mensagens = arrayOf("Preencha todos os campos!", "Cadastro realizado com sucesso")
    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teladecadastro)
        iniciarComponentes()


        val buttonIrParaVoltar: View = findViewById(R.id.voltar)

        buttonIrParaVoltar.setOnClickListener {
            val intent = Intent(this@TelaCadastro, TelaInicial::class.java)

            startActivity(intent)
        }

        fun cadastrarUsuario() {
            val nome = nomeUser.text.toString()
            val email = emailUser.text.toString()
            val senha = senhaUser.text.toString()
            val data = dataUser.text.toString()
            val telefone = telefoneUser.text.toString()
            val enedereco = enderecoUser.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Usuário criado com sucesso
                            enviarCodigoVerificacao(auth.currentUser)
                        } else {
                            // Erro ao criar usuário
                            Toast.makeText(this, "Erro ao criar usuário: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || enedereco.isEmpty() || data.isEmpty()) {
                exibirSnackbar(mensagens[0])
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val userId = FirebaseAuth.getInstance().currentUser?.uid
                            userId?.let {
                                exibirSnackbar(mensagens[1])
                            }
                        } else {
                            handleFirebaseAuthException(task.exception)
                        }
                    }
            }
        }

        setContentView(R.layout.teladecadastro)
        iniciarComponentes()

        button.setOnClickListener {
            cadastrarUsuario()
            val buttonIrParaOutraTelaVerificar: Button = findViewById(R.id.button)

            buttonIrParaOutraTelaVerificar.setOnClickListener {
                val intent = Intent(this@TelaCadastro, TelaVerificacao::class.java)

                startActivity(intent)
            }
        }



    }

private fun iniciarComponentes() {
    nomeUser = findViewById(R.id.nome_comple)
    emailUser = findViewById(R.id.nome_comple3)
    senhaUser = findViewById(R.id.senha)
    dataUser = findViewById(R.id.nome_comple2)
    enderecoUser = findViewById(R.id.nome_comple6)
    telefoneUser = findViewById(R.id.telefone)
    button = findViewById(R.id.button)
}

    private fun handleFirebaseAuthException(exception: Exception?) {
        val erro: String = when (exception) {
            is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres"
            is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada"
            is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido"
            else -> "Erro ao cadastrar usuário"
        }

        val snackbar = Snackbar.make(button, erro, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.WHITE)
        snackbar.setTextColor(Color.BLACK)
        snackbar.show()
    }
    private fun enviarCodigoVerificacao(user: FirebaseUser?) {
        user?.sendEmailVerification()
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Um código de verificação foi enviado para o seu email.", Toast.LENGTH_SHORT).show()
                    // Redirecionar para a próxima tela onde o usuário pode inserir o código
                    val intent = Intent(this, TelaVerificacao::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Erro ao enviar código de verificação: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun exibirSnackbar(mensagem: String) {
        val snackbar = Snackbar.make(button, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.WHITE)
        snackbar.setTextColor(Color.BLACK)
        snackbar.show()
    }


}

