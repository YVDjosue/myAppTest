package com.wanku.myapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wanku.myapptest.databinding.ActivityCalculadoraBinding

class Calculadora : AppCompatActivity() {
    private lateinit var binding : ActivityCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //implementar la gestión de los posibles errores generados por validación de datos,
        //datos nulos, datos inválidos, entre otros

        //no olvides geenrar funciones de extensión, alias y funciones de alcance para un codigo mas ordenado

        binding.btnAdd.setOnClickListener {
            val num1 =binding.etNumber1.text.toString()
            val num2 =binding.etNumber2.text.toString()
            binding.tvResul.text=calc(num1.toInt(), num2.toInt(), ::add)
        }

        binding.btnSus.setOnClickListener {
            val num1 =binding.etNumber1.text.toString()
            val num2 =binding.etNumber2.text.toString()
            binding.tvResul.text=calc(num1.toInt(), num2.toInt(), ::sus)
        }

        binding.btnMul.setOnClickListener {
            val num1 =binding.etNumber1.text.toString()
            val num2 =binding.etNumber2.text.toString()
            binding.tvResul.text=calc(num1.toInt(), num2.toInt(), ::mul)
        }

        binding.btnDiv.setOnClickListener {
            val num1 =binding.etNumber1.text.toString()
            val num2 =binding.etNumber2.text.toString()
            binding.tvResul.text=calc(num1.toInt(), num2.toInt(), ::div)
        }

        binding.btnExit.setOnClickListener { close() }
    }

    private fun add(a:Int,b:Int):Int = a+b
    private fun sus(a:Int,b:Int):Int = a-b
    private fun mul(a:Int,b:Int):Int = a*b
    private fun div(a:Int,b:Int):Int = a/b

    //implementar mas operaciones matematicas, modificar el layout para añadir mas botones

    private fun calc(a:Int,b:Int,fn:(Int,Int)->Int):String{
        //Implementar los casos en que se generará un error, con try y catch
        //retornar un texto adecuado de ser el caso
        val rpta = fn(a,b)
        return "El resultado es: $rpta"
    }

    private fun close(){
        finishAffinity()
    }
}