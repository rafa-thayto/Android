package informatica.sp.senai.br.vanbus.model

class Vehicle() {
    constructor(imagePath: String, model: String, numberOfDoors: Int, description: String, type: VehicleType, price: Double) : this() {
        this.imagePath = imagePath
        this.model = model
        this.numberOfDoors = numberOfDoors
        this.description = description
        this.type = type
        this.price = price
    }
    var id: Long? = null
    var imagePath: String? = null
    var model: String? = null
    var numberOfDoors: Int? = null
    var description: String? = null
    var type: VehicleType? = null
    var price: Double? = null
//    constructor() : this(name= "Bus", description="Thats a blue bus", type=VehicleType.BUS, price=25.70)

}