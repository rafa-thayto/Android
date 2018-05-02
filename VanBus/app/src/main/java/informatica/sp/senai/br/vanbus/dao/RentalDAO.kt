package informatica.sp.senai.br.vanbus.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import informatica.sp.senai.br.vanbus.model.Rental

const val TABLE_RENTS = "Rental"
const val COL_AMOUNT_PEOPLES = "amount_peoples"
const val COL_DRIVER = "driver"
const val COL_START_DATE = "start_date"
const val COL_END_DATE = "end_date"

class RentalDAO : SQLiteOpenHelper {

    private val context: Context

    constructor(context: Context) : super(context, DATABASE_NAME, null, DATABASE_VERSION) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableRents = "CREATE TABLE $TABLE_RENTS (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_AMOUNT_PEOPLES INTEGER," +
                "$COL_DRIVER TEXT," +
                "$COL_START_DATE TEXT," +
                "$COL_END_DATE TEXT" +
                ")"
        db?.execSQL(createTableRents)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_RENTS"
        db?.execSQL(sql)
    }

    fun insertData(rental: Rental) {

    }

    fun searchAll(): ArrayList<Rental> {
        val sql = "SELECT * FROM $TABLE_RENTS"
        val db = readableDatabase
        val c = db.rawQuery(sql, null)
        val rents = arrayListOf<Rental>()
        while (c.moveToNext()) {
            val rental: Rental = Rental()
            rental.id = c.getLong(c.getColumnIndex(COL_ID))
            rental.amountPeoples = c.getInt(c.getColumnIndex(COL_AMOUNT_PEOPLES))
            rental.driver = c.getString(c.getColumnIndex(COL_DRIVER)).toBoolean()
            rental.startDate = c.getString(c.getColumnIndex(COL_START_DATE))
            rental.endDate = c.getString(c.getColumnIndex(COL_END_DATE))
            rents.add(rental)
        }
        c.close()
        return rents
    }

}