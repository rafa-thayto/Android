package informatica.sp.senai.br.vanbus.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import informatica.sp.senai.br.vanbus.model.Vehicle
import informatica.sp.senai.br.vanbus.model.VehicleType

// Constants for database
const val DATABASE_NAME = "Vanbus"
const val DATABASE_VERSION = 3
const val TABLE_VEHICLES = "Vehicle"
const val COL_ID = "id"
const val COL_IMAGE_PATH = "image_path"
const val COL_MODEL = "model"
const val COL_NUMBER_DOORS = "doors"
const val COL_TYPE = "type"
const val COL_DESCRIPTION = "description"
const val COL_PRICE = "price"

class VehicleDAO : SQLiteOpenHelper {

    private val context: Context

    constructor(context: Context) : super(context, DATABASE_NAME, null, DATABASE_VERSION) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableVehicles = "CREATE TABLE $TABLE_VEHICLES (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_IMAGE_PATH TEXT," +
                "$COL_MODEL TEXT," +
                "$COL_NUMBER_DOORS INTEGER," +
                "$COL_TYPE TEXT," +
                "$COL_DESCRIPTION TEXT," +
                "$COL_PRICE REAL" +
                ")"
        db?.execSQL(createTableVehicles)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_VEHICLES"
        db?.execSQL(sql)
    }

    fun insert(vehicle: Vehicle) {
        val db = writableDatabase
        val cv = ContentValues().apply {
            put(COL_IMAGE_PATH, vehicle.imagePath)
            put(COL_MODEL, vehicle.model)
            put(COL_NUMBER_DOORS, vehicle.numberOfDoors)
            put(COL_TYPE, vehicle.type)
            put(COL_DESCRIPTION, vehicle.description)
            put(COL_PRICE, vehicle.price)
        }
        val res = db.insert(TABLE_VEHICLES, null, cv)
        if (res == (-1).toLong()) {
            Toast.makeText(context, "Não foi possivel inserir o veículo", Toast.LENGTH_SHORT).show()
        }
    }

    fun searchAll(): ArrayList<Vehicle> {
        val sql = "SELECT * FROM $TABLE_VEHICLES"
        val db = readableDatabase
        val c = db.rawQuery(sql, null)
        val vehicles = arrayListOf<Vehicle>()
        while (c.moveToNext()) {
            val vehicle: Vehicle = Vehicle()
            vehicle.id = c.getLong(c.getColumnIndex(COL_ID))
            vehicle.imagePath = c.getString(c.getColumnIndex(COL_IMAGE_PATH))
            vehicle.model = c.getString(c.getColumnIndex(COL_MODEL))
            vehicle.numberOfDoors = c.getString(c.getColumnIndex(COL_NUMBER_DOORS))
            vehicle.description = c.getString(c.getColumnIndex(COL_DESCRIPTION))
            vehicle.type = c.getString(c.getColumnIndex(COL_TYPE))
            vehicle.price = c.getString(c.getColumnIndex(COL_PRICE))
            vehicles.add(vehicle)
        }
        c.close()
        return vehicles
    }

}