package informatica.sp.senai.br.mylibrary.form

import android.widget.EditText
import android.widget.ImageView
import informatica.sp.senai.br.mylibrary.FormActivity
import informatica.sp.senai.br.mylibrary.R
import informatica.sp.senai.br.mylibrary.model.Book

class FormHelper {

    constructor(form: FormActivity) {
        val bookCover = form.findViewById<ImageView>(R.id.ivBookCover)
        val bookTitle = form.findViewById<EditText>(R.id.etBookTitle)
        val bookAuthor = form.findViewById<EditText>(R.id.etBookAuthor)
        val book: Book = Book()
    }

    fun getBook() {

    }
}