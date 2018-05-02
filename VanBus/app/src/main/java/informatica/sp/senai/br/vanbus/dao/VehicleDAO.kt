package informatica.sp.senai.br.vanbus.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import informatica.sp.senai.br.vanbus.model.Vehicle
import informatica.sp.senai.br.vanbus.model.VehicleType

// Constants for database
val DATABASE_NAME = "Vanbus"
val TABLE_NAME = "Vehicles"
val COL_ID = "id"
val COL_IMAGE_PATH = "image_path"
val COL_MODEL = "model"
val COL_NUMBER_DOORS = "doors"
val COL_TYPE = "type"
val COL_DESCRIPTION = "description"
val COL_PRICE = "price"

class VehicleDAO : SQLiteOpenHelper {

    private val context: Context

    constructor(context: Context) : super(context, DATABASE_NAME, null, 2) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_IMAGE_PATH TEXT," +
                "$COL_MODEL TEXT," +
                "$COL_NUMBER_DOORS INTEGER," +
                "$COL_TYPE TEXT," +
                "$COL_DESCRIPTION TEXT," +
                "$COL_PRICE REAL" +
                ")"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF NOT EXISTS $TABLE_NAME"
        db?.execSQL(sql)
    }

    fun insertData(vehicle: Vehicle) {
        val db = writableDatabase
        val cv = ContentValues().apply {
            put(COL_IMAGE_PATH, vehicle.imagePath)
            put(COL_MODEL, vehicle.model)
            put(COL_NUMBER_DOORS, vehicle.numberOfDoors)
            put(COL_TYPE, vehicle.type?.name)
            put(COL_DESCRIPTION, vehicle.description)
            put(COL_PRICE, vehicle.price)
        }
        val res = db.insert(TABLE_NAME, null, cv)
        if (res == (-1).toLong()) {
            Toast.makeText(context, "Não foi possivel inserir o veículo", Toast.LENGTH_SHORT).show()
        }
    }

    fun searchAll() {
        val sql = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase
        val c = db.rawQuery(sql, null)
        val vehicles = arrayListOf<Vehicle>()
        while (c.moveToNext()) {
            val vehicle: Vehicle = Vehicle()
            vehicle.id = c.getLong(c.getColumnIndex(COL_ID))
            vehicle.imagePath = c.getString(c.getColumnIndex(COL_IMAGE_PATH))
            vehicle.model = c.getString(c.getColumnIndex(COL_MODEL))
            vehicle.numberOfDoors = c.getInt(c.getColumnIndex(COL_NUMBER_DOORS))
            vehicle.description = c.getString(c.getColumnIndex(COL_DESCRIPTION))
            vehicle.type = VehicleType.valueOf(c.getString(c.getColumnIndex(COL_TYPE)))
            vehicle.price = c.getDouble(c.getColumnIndex(COL_PRICE))
        }
    }

}