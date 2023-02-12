package mx.edu.itson.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToLong
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etC: EditText = findViewById(R.id.etC)
        val etF: EditText = findViewById(R.id.etF)
        val etK: EditText = findViewById(R.id.etK)
        val btnGC: Button = findViewById(R.id.btnGC)
        val btnGF: Button = findViewById(R.id.btnGF)
        val btnGK: Button = findViewById(R.id.btnGK)
        val msj: TextView = findViewById(R.id.msj)


        btnGC.setOnClickListener {
            try {
                val valorC = etC.getText().toString().trim()

                val valorK=etK.getText().toString().trim()
                val valorF = etF.getText().toString().trim()



                    if (valorK != "" && valorF != "") {
                        msj.setText("Hay mas de una temperatura ingresada")

                }else {

                        if(valorC!=""){
                            msj.setText("Tipo emperatura a convertir igual al tipo ingresada")
                            limpiar(etC,etF,etK)
                    } else if (valorK != "") {
                        etC.setText(convertir(valorK.toString().toDouble(), "k-c").toString())
                        msj.setText("")

                    } else if (valorF != "") {
                        etC.setText(convertir(valorF.toString().toDouble(), "f-c").toString())
                        msj.setText("")
                    } else {
                        msj.setText("Campos vacios")
                    }
                }
            }catch (ex: java.lang.Exception)
            {
                msj.setText("Ingrese numeros")
            }
        }

        btnGF.setOnClickListener {
            try {


                val valorC = etC.getText().toString().trim()

                val valorK=etK.getText().toString().trim()
                val valorF = etF.getText().toString().trim()


                    if (valorC != "" && valorK != "") {
                        msj.setText("Hay mas de una temperatura ingresada")
                }else {
                        if(valorF!="") {
                            msj.setText("Tipo emperatura a convertir igual al tipo ingresada")
                            limpiar(etC,etF,etK)


                    } else if (valorC != "") {
                        etF.setText(convertir(valorC.toString().toDouble(), "c-f").toString())
                        msj.setText("")
                    } else if (valorK != "") {
                        etF.setText(convertir(valorK.toString().toDouble(), "k-f").toString())
                        msj.setText("")
                    } else {
                        msj.setText("Campos vacios")
                    }
                }
            }catch (ex: java.lang.Exception)
            {
                msj.setText("Ingrese numeros")
            }


        }

        btnGK.setOnClickListener {
            try {
                val valorC = etC.getText().toString().trim()

                val valorK=etK.getText().toString().trim()
                val valorF = etF.getText().toString().trim()
                if ((valorC != "" && valorF != "")) {
                    msj.setText("Hay mas de una temperatura ingresada")
                }

                else {
                        if(valorK!=""){
                            msj.setText("Tipo emperatura a convertir igual al tipo ingresada")
                            limpiar(etC,etF,etK)

                    } else if (valorC != "") {
                        etK.setText(convertir(valorC.toString().toDouble(), "c-k").toString())
                        msj.setText("")
                    } else if (valorF != "") {
                        etK.setText(convertir(valorF.toString().toDouble(), "f-k").toString())
                        msj.setText("")
                    } else {
                        msj.setText("Campos vacios")
                    }
                }
            }catch (ex: java.lang.Exception)
            {
                msj.setText("Ingrese numeros")
            }
        }


    }

    fun convertir(grados: Double, tipo: String): Double {
        when (tipo) {
            "c-k" -> return grados + 273.15
            "c-f" -> return grados * 1.8 + 32
            "k-c" -> return grados - 273.15
            "k-f" -> return ((9 * (grados - 273.15) / 5) + 32)
            "f-k" -> return ((5 * (grados - 32) / 9) + 273.15)
            "f-c" -> return (grados - 32) / 1.8
        }

        return 0.0

    }

    fun limpiar(cCelsius:EditText,cFahrenheit:EditText,cKelvin:EditText )
    {
        cCelsius.setText("")
        cFahrenheit.setText("")
        cKelvin.setText("")

    }






}