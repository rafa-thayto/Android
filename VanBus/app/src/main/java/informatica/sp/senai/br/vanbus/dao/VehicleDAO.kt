package informatica.sp.senai.br.vanbus.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import informatica.sp.senai.br.vanbus.model.Vehicle

val DATABASE_NAME = "Vanbus"
val TABLE_NAME = "Vehicles"
val COL_ID = "id"
val COL_NAME = "name"
val COL_DESCRIPTION = "description"
val COL_PRICE = "price"
val COL_TYPE = "type"

class VehicleDAO : SQLiteOpenHelper {

    private val context : Context

    constructor(context: Context) : super(context, DATABASE_NAME, null, 1) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "" +
                ")"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF NOT EXISTS $TABLE_NAME"
        db?.execSQL(sql)
    }

    fun insertData(vehicle: Vehicle) {
        val db = writableDatabase
        var cv = ContentValues().apply {
//            put()
        }
        val res = db.insert(TABLE_NAME, null, cv)
        if (res == -1.toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

}