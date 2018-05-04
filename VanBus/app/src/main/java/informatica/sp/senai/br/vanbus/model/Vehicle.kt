package informatica.sp.senai.br.vanbus.model

class Vehicle() {
    constructor(imagePath: String, model: String, numberOfDoors: String, description: String, type: String, price: String) : this() {
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
    var numberOfDoors: String? = null
    var description: String? = null
    var type: String? = null
    var price: String? = null


    override fun toString(): String {
        return "Vehicle(id=$id, imagePath=$imagePath, model=$model, numberOfDoors=$numberOfDoors, description=$description, type=$type, price=$price)"
    }
//    constructor() : this(name= "Bus", description="Thats a blue bus", type=VehicleType.BUS, price=25.70)



}