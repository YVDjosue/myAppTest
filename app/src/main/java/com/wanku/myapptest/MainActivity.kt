package com.wanku.myapptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.wanku.myapptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var user : String
    private lateinit var pass : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            user=binding.etUser.text.toString()
            pass=binding.etPass.text.toString()
            if(login(user,pass)){
                startService(Intent(this,Calculadora::class.java))  //¿Porque no inicia el activity? encuentra el error en esta linea
                finish()
            }else{
                //como borrar el mensaje de error al volver a logear?
                binding.tvError.text=getString(R.string.loginError)
            }
        }
    }
    private fun login(user:String, pass:String): Boolean{
        return (user=="cursokotlin" && pass=="12345")
    }
}