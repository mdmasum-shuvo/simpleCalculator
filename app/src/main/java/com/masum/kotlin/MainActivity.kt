package com.masum.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var totalStr = ""
    var firstNumber: Double = 0.0
    var secondNumber: Double = 0.0
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun onclickNumber(view: View) {
        lateinit var numberStr: String
        val button: Button = view as Button
        numberStr = button.text.toString()
        totalStr += numberStr
        editNumber.setText(totalStr)

    }

    fun onOperator(view: View) {
        val button: Button = view as Button
        when (totalStr) {
            "" -> toast("please enter a number first")
            else -> {
                operator = button.text.toString()
                firstNumber = totalStr.toDouble()
                totalStr = ""
            }

        }

    }

    fun onCalculate(view: View) {
        when (totalStr) {
            "" -> toast("please enter a number first")
            else -> {
                secondNumber = totalStr.toDouble()
                when (operator) {
                    "+" -> {
                        var result: Double = firstNumber + secondNumber
                        totalStr = "" + result
                        editNumber.setText("" + result)
                    }
                    "-" -> {
                        var result: Double = firstNumber - secondNumber
                        totalStr = "" + result
                        editNumber.setText("" + result)
                    }
                    "/" -> {
                        var result: Double = firstNumber / secondNumber
                        totalStr = "" + result
                        editNumber.setText("" + result)
                    }
                    "x" -> {
                        var result: Double = firstNumber * secondNumber
                        totalStr = "" + result
                        editNumber.setText("" + result)
                    }

                }
                //toast("number is ok")
            }

        }
    }


    fun cancel(view: View) {

        totalStr = ""
        editNumber.setText("")
    }


    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    }


}
