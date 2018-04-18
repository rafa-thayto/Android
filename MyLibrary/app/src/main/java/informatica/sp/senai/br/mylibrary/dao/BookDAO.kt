package informatica.sp.senai.br.mylibrary.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import informatica.sp.senai.br.mylibrary.model.Book

val DB_NAME = "LibraryAfternoon"
val TABLE_NAME = "Book"

class BookDAO(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql: String = "DROP TABLE IF EXISTS Book"
        db?.execSQL(sql)
    }

    fun insert (book: Book) {
        writableDatabase
    }
}