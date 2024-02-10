package com.projeto1.idonor

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class TelaLogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_logo)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@TelaLogoActivity, TelaInicial::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}