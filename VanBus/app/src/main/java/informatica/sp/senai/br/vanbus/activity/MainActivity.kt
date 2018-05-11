package informatica.sp.senai.br.vanbus.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.adapter.VehicleListAdapter
import informatica.sp.senai.br.vanbus.dao.VehicleDAO
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.btnGoToRegister).setOnClickListener {
            startActivity(Intent(this, VehiclesFormActivity::class.java))
        }
        findViewById<FloatingActionButton>(R.id.btnGoToRent).setOnClickListener {
            startActivity(Intent(this, RentalFormActivity::class.java))
        }
    }


    override fun onResume() {
        super.onResume()

        val dao = VehicleDAO(this)

        // Configuring RecyclerView
        vehiclesList.adapter = VehicleListAdapter(dao.searchAll(), this)
        vehiclesList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }

    /*
    private fun vehicles(): List<Vehicle> {
        return listOf(
                Vehicle(imagePath = "Caminho da imagem do bang",model = "Bus1", numberOfDoors = 3, description = "Bus1", type = VehicleType.BUS, price = 110.0),
                Vehicle(imagePath = "Caminho da imagem do bang",model = "Bus2", numberOfDoors = 4, description = "Bus2", type = VehicleType.BUS, price = 120.0),
                Vehicle(imagePath = "Caminho da imagem do bang",model = "Bus3", numberOfDoors = 2, description = "Bus3", type = VehicleType.BUS, price = 130.0),
                Vehicle(imagePath = "Caminho da imagem do bang",model = "Van1", numberOfDoors = 3, description = "Van1", type = VehicleType.VAN, price = 210.0),
                Vehicle(imagePath = "Caminho da imagem do bang",model = "Van2", numberOfDoors = 3, description = "Van2", type = VehicleType.VAN, price = 220.0),
                Vehicle(imagePath = "Caminho da imagem do bang",model = "Van2", numberOfDoors = 3, description = "Van2", type = VehicleType.VAN, price = 230.0)
        )
    }
    */
}
