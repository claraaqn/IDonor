package com.projeto1.idonor

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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Suppress("PrivatePropertyName")
class TelaInicial : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest
    private val REQ_ONE_TAP = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        auth = Firebase.auth


        val buttonLogin: Button = findViewById(R.id.buttonlogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaLogin::class.java)
            startActivity(intent)
        }

        val buttonIrParaCadastro: Button = findViewById(R.id.button2)
        buttonIrParaCadastro.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaCadastro::class.java)
            startActivity(intent)
        }

        val buttonLoginGoogleAuthProvider: Button = findViewById(R.id.button3)
        buttonLoginGoogleAuthProvider.setOnClickListener {
            signInWithGoogle()
        }

        val buttonIntituicoes: Button = findViewById(R.id.conhecer_as)
        buttonIntituicoes.setOnClickListener {
            val intent = Intent(this@TelaInicial, TelaInicialActivity::class.java)
            startActivity(intent)
        }

        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(getString(R.string.idGoogle))
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
            .build()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // Usuário está conectado, redirecione para a tela principal do aplicativo ou exiba uma mensagem de boas-vindas
            Toast.makeText(
                this, "Bem-vindo(a), ${user.displayName}!", Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
            finish()
            // Fecha a atividade atual para evitar que o usuário retorne à tela de login
        } else {
            // Usuário não está conectado, exiba a tela de login ou uma mensagem indicando que o usuário precisa fazer login
            Toast.makeText(
                this, "Faça login para acessar o aplicativo.", Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun signInWithGoogle() {
        try {
            startActivityForResult(intent, REQ_ONE_TAP)
        } catch (e: ApiException) {
            Log.e(TAG, "Exception during One Tap sign-in: ${e.localizedMessage}")
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_ONE_TAP) {
            // Handle the result of the sign-in flow
            oneTapClient.getSignInCredentialFromIntent(data)
            handleSignInResult()
        }
    }


    private fun handleSignInResult() {
        try {
            getResult()
            // Signed in successfully, show authenticated UI.
            val googleIdToken = null
            // Use the ID token to authenticate with Firebase
            val authCredential = GoogleAuthProvider.getCredential(googleIdToken, null)
            auth.signInWithCredential(authCredential)
                .addOnCompleteListener(this) { authTask ->
                    if (authTask.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", authTask.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        updateUI(null)
                    }
                }
        } catch (e: ApiException) {
            // Sign-in failed, handle failure and update UI
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            Toast.makeText(
                baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT
            ).show()
            updateUI(null)
        }
    }

    companion object {
        const val TAG = "TelaInicial"
    }
}

private fun getResult(): Any {
    TODO("Not yet implemented")
}
