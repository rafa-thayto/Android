package informatica.sp.senai.br.vanbus.helper

import android.widget.*
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.activity.VehiclesFormActivity
import informatica.sp.senai.br.vanbus.model.Vehicle
import informatica.sp.senai.br.vanbus.model.VehicleType

class VehicleFormHelper {

    private val imagePath: ImageView
    private val model: EditText
    private val doors: EditText
    private val description: EditText
    private val price: EditText
    private lateinit var type: VehicleType
    private val radioGroup: RadioGroup
    private val vehicle: Vehicle

    constructor(form: VehiclesFormActivity) {
        imagePath = form.findViewById(R.id.imgVehicle)
        model = form.findViewById(R.id.etModel)
        doors = form.findViewById(R.id.etDoors)
        price = form.findViewById(R.id.etPrice)
        description = form.findViewById(R.id.etDescription)
        radioGroup = form.findViewById(R.id.rgVanBus)

        // Setting type of vehicle
        radioGroup.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                // Van Type
                R.id.rbVan -> type = VehicleType.VAN
                // Bus Type
                R.id.rbBus -> type = VehicleType.BUS
                else -> Toast.makeText(form, "Erro ao definir tipo de veículo", Toast.LENGTH_SHORT).show()
            }
        }

        vehicle = Vehicle()
    }

    fun getVehicle(): Vehicle {
        this.vehicle.imagePath = imagePath.toString()
        this.vehicle.model = model.toString()
        this.vehicle.numberOfDoors = doors.toString().toInt()
        this.vehicle.description = description.toString()
        this.vehicle.type = this.type
        this.vehicle.price = price.toString().toDouble()

        return vehicle
    }

}