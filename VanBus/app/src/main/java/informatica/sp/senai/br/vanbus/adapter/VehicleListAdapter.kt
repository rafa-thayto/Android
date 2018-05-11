package informatica.sp.senai.br.vanbus.adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.activity.VehiclesFormActivity
import informatica.sp.senai.br.vanbus.model.Vehicle
import kotlinx.android.synthetic.main.list_item_vehicles.view.*


class VehicleListAdapter(private val vehicles: List<Vehicle>,
                         private val context: Context) : Adapter<VehicleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_vehicles, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicle = vehicles[position]
//        val returnedImage: Bitmap = BitmapFactory.decodeFile(vehicle.imagePath)
//        holder.itemView.item_image.setImageBitmap(returnedImage)

        val bitmap = BitmapFactory.decodeFile(vehicle.imagePath)

        holder.itemView.item_image.setImageBitmap(bitmap)

        holder.itemView.item_model.text = vehicle.model
        holder.itemView.item_doors.text = vehicle.numberOfDoors
        holder.itemView.item_type.text = vehicle.type
        holder.itemView.item_price.text = vehicle.price

        Log.e("titleD", vehicle.toString())
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, VehiclesFormActivity::class.java)

                itemView.context.startActivity(intent)
            }
        }
    }


}