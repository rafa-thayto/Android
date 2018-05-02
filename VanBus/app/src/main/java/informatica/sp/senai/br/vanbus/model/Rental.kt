package informatica.sp.senai.br.vanbus.model

class Rental() {
    constructor(quantPersons: Int, driver: Boolean, startDate: String, endDate: String) : this() {
        this.quantPersons = quantPersons
        this.driver = driver
        this.startDate = startDate
        this.endDate = endDate
    }
    var quantPersons: Int? = null
    var driver: Boolean? = null
    var startDate: String? = null
    var endDate: String? = null
}