package informatica.sp.senai.br.mybooks.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import informatica.sp.senai.br.mybooks.models.Book

val DATABASE_NAME = "MyBooks"
val TABLE_NAME = "Book"
val COL_ID = "id"
val COL_NAME = "name"
val COL_AUTHOR = "author"
val COL_GENRE = "genre"
val COL_PUBLISH_COMPANY = "publish_company"
val COL_YEAR = "year"

class BookDAO: SQLiteOpenHelper {

    val context: Context

    constructor(context: Context) : super(context, DATABASE_NAME, null, 1) {
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ( " +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_NAME VARCHAR(120) NOT NULL, " +
                "$COL_AUTHOR VARCHAR(60) NOT NULL, " +
                "$COL_GENRE VARCHAR(60) NOT NULL, " +
                "$COL_PUBLISH_COMPANY VARCHAR(60) NOT NULL, " +
                "$COL_YEAR DATETIME('now','localtime') NOT NULL )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF NOT EXISTS $TABLE_NAME"
        db?.execSQL(sql)
    }

    fun insertData (book: Book) {
        val db = this.writableDatabase
        var cv = ContentValues().apply {
            put(COL_NAME, book.name)
            put(COL_AUTHOR, book.author)
            put(COL_GENRE, book.genre)
            put(COL_PUBLISH_COMPANY, book.publishCompany)
            put(COL_YEAR, book.year)
        }
        var res = db.insert(TABLE_NAME, null, cv)
        if (res == -1.toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

}