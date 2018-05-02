package informatica.sp.senai.br.vanbus.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.dao.VehicleDAO
import informatica.sp.senai.br.vanbus.helper.VehicleFormHelper
import informatica.sp.senai.br.vanbus.model.Vehicle

class VehiclesFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles_form)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val helper = VehicleFormHelper(this)

        btnRegister.setOnClickListener {
            val dao = VehicleDAO(this)
            val vehicle: Vehicle = helper.getVehicle()
            dao.insertData(vehicle)
            finish()
        }


    }
}
