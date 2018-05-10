package informatica.sp.senai.br.vanbus.model

class Rental() {
    constructor(amountPeoples: Int, driver: Boolean, startDate: String, endDate: String) : this() {
        this.amountPeoples = amountPeoples
        this.driver = driver
        this.startDate = startDate
        this.endDate = endDate
    }
    var id: Long? = null
    var amountPeoples: Int? = null
    var driver: Boolean? = null
    var startDate: String? = null
    var endDate: String? = null
}