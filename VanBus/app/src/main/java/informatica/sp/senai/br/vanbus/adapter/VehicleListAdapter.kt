package informatica.sp.senai.br.vanbus.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.model.Vehicle
import kotlinx.android.synthetic.main.list_item_vehicles.view.*


class VehicleListAdapter(private val vehicles: List<Vehicle>,
                         private val context: Context): Adapter<VehicleListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_vehicles, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicle = vehicles[position]
        val returnedImage: Bitmap = BitmapFactory.decodeFile(vehicle.imagePath)
        holder.image.setImageBitmap(returnedImage)
        holder.name.text = vehicle.name
        holder.type.text = vehicle.type.toString()
        holder.price.text = vehicle.price.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.item_image
        val name = itemView.item_name
        val type = itemView.item_type
        val price = itemView.item_price

        fun bindView(vehicle: Vehicle) {
            val image = itemView.item_image
            val name = itemView.item_name
            val type = itemView.item_type
            val price = itemView.item_price

            val returnedImage: Bitmap = BitmapFactory.decodeFile(vehicle.imagePath)
            image.setImageBitmap(returnedImage)
            name.text = vehicle.name
            type.text = vehicle.type.toString()
            price.text = vehicle.price.toString()
        }
    }



}