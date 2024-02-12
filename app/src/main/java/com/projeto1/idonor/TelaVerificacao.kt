import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.projeto1.idonor.R
import com.projeto1.idonor.TelaCadastro
import com.projeto1.idonor.TelaInicialActivity

class TelaVerificacao : AppCompatActivity() {

    private lateinit var codigo: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teladeverificacao)

        codigo = findViewById(R.id.codigo)
        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")

        val buttonVerificarCodigo: Button = findViewById(R.id.buttonCadastro)
        buttonVerificarCodigo.setOnClickListener {
            val codigoVerificacaoDigitado = codigo.text.toString()
            verificarCodigo(email, codigoVerificacaoDigitado)
        }

        val buttonVoltarCadastroVe: View = findViewById(R.id.voltarTelaVerificar)
        buttonVoltarCadastroVe.setOnClickListener {
            val intent = Intent(this@TelaVerificacao, TelaCadastro::class.java)
            startActivity(intent)
        }
    }

    private fun verificarCodigo(email: String?, codigoVerificacaoDigitado: String) {
        val user = auth.currentUser
        val email = user?.email

        if (!email.isNullOrEmpty()) {
            // Verificar se o código digitado é igual ao código de verificação enviado por email
            if (codigoVerificacaoDigitado == "123456") { // Substitua "123456" pelo código gerado durante o cadastro
                // Código de verificação correto, direcionar para a tela inicial
                val intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
                finish() // Finalizar a tela de verificação para que o usuário não possa voltar para ela pressionando o botão "Voltar"
            } else {
                // Código de verificação incorreto
                Toast.makeText(this, "Código de verificação incorreto.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(
                this,
                "Não foi possível recuperar o email do usuário.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
