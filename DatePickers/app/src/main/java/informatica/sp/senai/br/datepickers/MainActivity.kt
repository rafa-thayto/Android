package informatica.sp.senai.br.datepickers

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class MainActivity : AppCompatActivity() {

    var dateListenerIn: DatePickerDialog.OnDateSetListener? = null
    var dateListenerOut: DatePickerDialog.OnDateSetListener? = null
    lateinit var entradaTratada: LocalDate
    lateinit var saidaTratada: LocalDate

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataEntrada = findViewById<TextView>(R.id.tvDataEntrada)
        val dataSaida = findViewById<TextView>(R.id.tvDataSaida)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        dataEntrada.setOnClickListener({
            val calendar: Calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog: DatePickerDialog = DatePickerDialog(
                    this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    dateListenerIn,
                    year,
                    month,
                    day)
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }) // Fim onclick listener

        dataSaida.setOnClickListener({
            val calendar: Calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog: DatePickerDialog = DatePickerDialog(
                    this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    dateListenerIn,
                    year,
                    month,
                    day)
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }) // Fim onclick listener

        dateListenerIn = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            var dataEntradaRetornado = "$dayOfMonth/${monthOfYear.inc()}/$year"
            entradaTratada = LocalDate.of(year, monthOfYear, dayOfMonth)
            dataEntrada.text = dataEntradaRetornado
        }

        dateListenerOut = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            var dataEntradaRetornado = "$dayOfMonth/${monthOfYear.inc()}/$year"
            entradaTratada = LocalDate.of(year, monthOfYear, dayOfMonth)
            dataEntrada.text = dataEntradaRetornado
        }

        btnCalcular.setOnClickListener({
            var diferencaDeData: Long = entradaTratada.until(saidaTratada, ChronoUnit.DAYS)
            resultado.text = diferencaDeData.toString()
        })

    }
}
