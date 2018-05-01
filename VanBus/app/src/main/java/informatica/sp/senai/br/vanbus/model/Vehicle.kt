package informatica.sp.senai.br.vanbus.model

class Vehicle(val name: String,
//            val imagePath: String,
              val description: String,
              val type: VehicleType,
              val price: Double) {
//    constructor() : this(name= "Bus", description="Thats a blue bus", type=VehicleType.BUS, price=25.70)
//    constructor(name: String, description: String, type: VehicleType, price: Double) : this()
}