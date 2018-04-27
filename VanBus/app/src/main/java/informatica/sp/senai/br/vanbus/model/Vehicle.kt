package informatica.sp.senai.br.vanbus.model

class Vehicle(val id: Long,
              val imagePath: String,
              val name: String,
              val description: String,
              val type: VehicleType,
              val price: Double) {
    constructor() : this(id = 1, imagePath = "\n" +
            "/storage/emulated/0/Pictures/vehicles/blue_bus.jpeg", name= "Bus", description="Thats a blue bus", type=VehicleType.BUS, price=25.70)
    constructor(imagePath: String, name: String, description: String, type: VehicleType, price: Double) : this()
}