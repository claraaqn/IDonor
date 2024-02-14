package com.projeto1.idonor

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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

        auth = Firebase.auth

        button.setOnClickListener {
            cadastrarUsuario()
        }

        val buttonIrParaVoltar: View = findViewById(R.id.voltar)
        buttonIrParaVoltar.setOnClickListener {
            val intent = Intent(this@TelaCadastro, TelaInicial::class.java)
            startActivity(intent)
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
    private fun exibirSnackbar(mensagem: String) {
        val snackbar = Snackbar.make(button, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.WHITE)
        snackbar.setTextColor(Color.BLACK)
        snackbar.show()
    }
        private fun cadastrarUsuario() {
            val nome = nomeUser.text.toString()
            val email = emailUser.text.toString()
            val senha = senhaUser.text.toString()
            val data = dataUser.text.toString()
            val telefone = telefoneUser.text.toString()
            val enedereco = enderecoUser.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || enedereco.isEmpty() || data.isEmpty()) {
                exibirSnackbar(mensagens[0])
            } else {
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Usuário criado com sucesso
                            // Salvar detalhes do usuário em SharedPreferences
                            salvarDetalhesUsuario(nome, email, telefone)
                            // Envie o email de verificação
                            enviarCodigoVerificacaoPorEmail(email)
                        } else {
                            // Erro ao criar usuário
                            handleFirebaseAuthException(task.exception)
                        }
                    }
            }
        }
    private fun enviarCodigoVerificacaoPorEmail(email: String) {
        Firebase.auth.currentUser?.let { user ->
            user.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Email de verificação enviado com sucesso
                    // Redireciona para a tela de verificação
                    val intent = Intent(this@TelaCadastro, TelaInicial::class.java)
                    intent.putExtra("email", email)
                    startActivity(intent)
                } else {
                    // Ocorreu um erro ao enviar o email de verificação
                    // Você pode lidar com o erro de acordo com os requisitos do seu aplicativo
                }
            }
        }
    }
    private fun salvarDetalhesUsuario(nome: String, email: String, telefone: String) {
        val sharedPreferences = getSharedPreferences("USER_PREFS", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("NOME", nome)
        editor.putString("EMAIL", email)
        editor.putString("TELEFONE", telefone)
        editor.apply()
    }
}
