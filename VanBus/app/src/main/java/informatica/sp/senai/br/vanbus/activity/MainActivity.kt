package informatica.sp.senai.br.vanbus.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.adapter.VehicleListAdapter
import informatica.sp.senai.br.vanbus.model.Vehicle
import informatica.sp.senai.br.vanbus.model.VehicleType
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        // Configuring RecyclerView
        vehiclesList.adapter = VehicleListAdapter(vehicles(), this)
        vehiclesList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        findViewById<FloatingActionButton>(R.id.btnGoToRegister).setOnClickListener{
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

    private fun vehicles(): List<Vehicle> {
        return listOf(
                Vehicle(name = "Bus1", description = "Bus1", type = VehicleType.BUS, price = 110.0),
                Vehicle(name = "Bus2", description = "Bus2", type = VehicleType.BUS, price = 120.0),
                Vehicle(name = "Bus3", description = "Bus3", type = VehicleType.BUS, price = 130.0),
                Vehicle(name = "Van1", description = "Van1", type = VehicleType.VAN, price = 210.0),
                Vehicle(name = "Van2", description = "Van2", type = VehicleType.VAN, price = 220.0),
                Vehicle(name = "Van2", description = "Van2", type = VehicleType.VAN, price = 230.0)
        )
    }
}
