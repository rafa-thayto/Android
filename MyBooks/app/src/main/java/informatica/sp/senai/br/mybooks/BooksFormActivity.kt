package informatica.sp.senai.br.mybooks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_books_form.*

class BooksFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_form)

        val context = this

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val validation =
                    etBookName.text.toString().length > 0 &&
                    etBookAuthor.text.toString().length > 0 &&
                    etBookGenre.text.toString().length > 0 &&
                    etBookPublishCompany.text.toString().length > 0 &&
                    etBookYear.text.toString().length > 0
            if (validation)

            else
                Toast.makeText(context, "Please fill Data's", Toast.LENGTH_SHORT).show()

        }
    }
}
