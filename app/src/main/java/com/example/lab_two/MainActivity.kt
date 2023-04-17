package com.example.lab_two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private fun Descriminant(a:Double, b:Double, c:Double):Double{
        val desk = b*b-4*a*c
        return desk
    }
    private fun x1orx2(b:Double, deskriminant:Double, a:Double, c:Double):String{
        if (a == 0.0 && b!=0.0 &&c!=0.0){
            val oneSolution = String.format("%.2f",-c/b)
            return "Линейное уравнение - x= $oneSolution"
        }
        val x1 = String.format("%.2f",(-b+ sqrt(deskriminant))/2*a)
        val x2 = String.format("%.2f",(-b- sqrt(deskriminant))/2*a)
        if(b == 0.0 && a == 0.0 && c ==0.0){
            return "Выполняется при всех х"
        }
        if(b == 0.0 && a == 0.0 && c !=0.0){
            return "Нет решений"
        }
        if (deskriminant == 0.0) return "x1 = x2 = $x2"
        return "x1 = $x1\nx2 = $x2"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = findViewById<EditText>(R.id.editTextTextPersonName)
        val result = findViewById<TextView>(R.id.textView4)
        val b = findViewById<EditText>(R.id.editTextTextPersonName2)
        val c = findViewById<EditText>(R.id.editTextTextPersonName3)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            if (a.text.toString()==""){
                a.setText("0")
            }
            if(b.text.toString()==""){
                b.setText("0")
            }
            if(c.text.toString()==""){
                c.setText("0")
            }
            val deskriminantion = Descriminant(a.text.toString().toDouble(),b.text.toString().toDouble(),c.text.toString().toDouble())
            if(deskriminantion<0){
                result.text = "Корней нет"
            }
            else if (deskriminantion == 0.0){
                result.text =x1orx2(b.text.toString().toDouble(), deskriminantion, a.text.toString().toDouble(), c.text.toString().toDouble())
            }
            else result.text = x1orx2(b.text.toString().toDouble(), deskriminantion, a.text.toString().toDouble(), c.text.toString().toDouble())
        }
    }

}