package com.gmail.neirdag.calculetteouf

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var valueButtons:List<Button>
    lateinit var operationButtons:List<Button>
    lateinit var resultField:TextView
    var calcul:Calculator =  Calculator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }
    private fun initViews(){
        var term:String = "0"

        resultField = findViewById(R.id.resultfield)
        valueButtons = listOf(
            findViewById(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
            findViewById(R.id.buttonComa)

            )
        operationButtons = listOf(
            findViewById(R.id.buttonEquals),
            findViewById(R.id.buttonCancel),
            findViewById(R.id.buttonDivide),
            findViewById(R.id.buttonTimes),
            findViewById(R.id.buttonMinus),
            findViewById(R.id.buttonPlus)
        )

        valueButtons.forEach{button ->
            button.setOnClickListener {
                if (resultField.text == "0" || resultField.text == "0.0"){
                    term = ""
                    resultField.text = ""
                }
                resultField.text = ( resultField.text.toString() + button.text.toString())
                term +=  button.text.toString()
            }
        }
        operationButtons.forEach {button ->
            button.setOnClickListener {
                when(button.id){
                    R.id.buttonEquals -> resultField.text = "${calcul.compute(resultField.text.toString())}"
                    R.id.buttonCancel -> resultField.text = "0"
                    else -> {
                        resultField.text = ( resultField.text.toString() + button.text.toString())
                    }
                }

            }
        }
    }
}
