package informatica.sp.senai.br.vanbus.helper

import android.util.Log
import android.util.LogPrinter
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.activity.VehiclesFormActivity
import informatica.sp.senai.br.vanbus.model.Vehicle
import informatica.sp.senai.br.vanbus.model.VehicleType

class VehicleFormHelper {

    val imagePath: ImageView
    val model: EditText
    val doors: EditText
    val description: EditText
    val price: EditText
    var type: VehicleType? = VehicleType.VAN
    val radioGroup: RadioGroup
    private val vehicle: Vehicle

    var imageUri: String? = ""

    constructor(form: VehiclesFormActivity) {
        imagePath = form.findViewById(R.id.imgVehicle)
        model = form.findViewById(R.id.etModel)
        doors = form.findViewById(R.id.etDoors)
        price = form.findViewById(R.id.etPrice)
        description = form.findViewById(R.id.etDescription)
        radioGroup = form.findViewById(R.id.rgVanBus)

        vehicle = Vehicle()
        // Setting type of vehicle
//        radioGroup.setOnCheckedChangeListener { _, isChecked ->
//            when (isChecked) {
//                // Van Type
//                R.id.rbVan -> this.vehicle.type = VehicleType.VAN.name
//                // Bus Type
//                R.id.rbBus -> this.vehicle.type = VehicleType.BUS.name
//                else -> Toast.makeText(form, "Erro ao definir tipo de veículo", Toast.LENGTH_SHORT).show()
//            }
//        }

    }

    fun getVehicle(): Vehicle {

        Log.e("IMAGE URI NESSA PORRA", "String")
        Log.e("IMAGE URI NESSA PORRA: ", imageUri)
        Log.e("IMAGE PATH NESSA PORRA", imagePath.toString())

        this.vehicle.imagePath = imageUri
        this.vehicle.model = model.text.toString()
        this.vehicle.numberOfDoors = doors.text.toString()
        this.vehicle.description = description.text.toString()
        this.vehicle.price = price.text.toString()

        when (radioGroup.checkedRadioButtonId) {
        // Van Type
            R.id.rbVan -> this.vehicle.type = VehicleType.VAN.name
        // Bus Type
            R.id.rbBus -> this.vehicle.type = VehicleType.BUS.name
        }

        return vehicle
    }

}