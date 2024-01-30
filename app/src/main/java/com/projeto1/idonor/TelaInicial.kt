package com.projeto1.idonor

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class TelaInicial : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest
    private val REQ_ONE_TAP = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        auth = Firebase.auth

        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(getString(R.string.idGoogle))
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()


        val buttonIrParaOutraTelaLogin: Button = findViewById(R.id.button)
        buttonIrParaOutraTelaLogin.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaLogin::class.java)
            startActivity(intent)
        }

        val buttonIrParaCadastro: Button = findViewById(R.id.button2)
        buttonIrParaOutraTelaLogin.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaCadastro::class.java)
            startActivity(intent)
        }

        val buttonLoginGoogleAuthProvider: Button = findViewById(R.id.button3)
        buttonLoginGoogleAuthProvider.setOnClickListener {
            signInWithGoogle(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_ONE_TAP) {
            try {
                val credential = oneTapClient.getSignInCredentialFromIntent(data)
                val idToken = credential.googleIdToken
                idToken?.let {
                    val firebaseCredential = GoogleAuthProvider.getCredential(it, null)
                    auth.signInWithCredential(firebaseCredential)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "signInWithCredential:success")
                                val user = auth.currentUser
                                updateUI(user)
                            } else {
                                Log.w(TAG, "signInWithCredential:failure", task.exception)
                                updateUI(null)
                            }
                        }
                }
            } catch (e: ApiException) {
                Log.e(TAG, "Exception during One Tap sign-in: ${e.localizedMessage}")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        var currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // Usuário está conectado, redirecione para a tela principal do aplicativo ou exiba uma mensagem de boas-vindas
            Toast.makeText(
                this, "Bem-vindo(a), ${user.displayName}!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
            finish()
// Fecha a atividade atual para evitar que o usuário retorne à tela de login
        } else {


// Usuário não está conectado, exiba a tela de login ou uma mensagem indicando que o usuário precisa fazer login
            Toast.makeText(


                this, "Faça login para acessar o aplicativo.", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val TAG = "TelaInicial"
    }
    private fun signInWithGoogle(intent: Intent) {
        try {
            val intent = oneTapClient.getSignInIntent(signInRequest)
            startActivityForResult(intent, REQ_ONE_TAP)
        } catch (e: ApiException) {
            Log.e(TAG, "Exception during One Tap sign-in: ${e.localizedMessage}")
        }
    }

    private fun startActivityForResult(intent: Unit, reqOneTap: Int) {
        TODO("Not yet implemented")
    }

    private fun startActivityForResult(intent: Task<PendingIntent>, reqOneTap: Int) {
        TODO("Not yet implemented")
    }

}

private fun SignInClient.getSignInIntent(signInRequest: BeginSignInRequest) {

}


