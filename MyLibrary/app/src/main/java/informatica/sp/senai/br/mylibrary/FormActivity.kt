package informatica.sp.senai.br.mylibrary

import android.Manifest
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.ImageView
import informatica.sp.senai.br.mylibrary.form.FormHelper
import kotlinx.android.synthetic.main.activity_form.*

val GALERY_CODE: Int = 1
val PERMISSION_REQUEST: Int = 1
val PERMISSION_GRANTED: Int = 0
class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        var helper: FormHelper = FormHelper(this)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val bookCover = findViewById<ImageView>(R.id.ivBookCover)

        btnRegister.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(intent.action, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, GALERY_CODE)
        })

        bookCover.setOnClickListener(View.OnClickListener {

        })

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            }
        }

    } // End onCreate

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && resultCode == GALERY_CODE) {
            var imageUri: Uri? = data?.data
            var directories: Array<String> = arrayOf<String>(MediaStore.Images.Media.DATA)
            var c: Cursor = contentResolver.query(imageUri, directories, null, null, null)
            c.moveToFirst()
            val collumIndex: Int = c.getColumnIndex(directories[0])
            var imageRoute: String = c.getString(collumIndex)
            c.close()
            var returnImage: Bitmap = BitmapFactory.decodeFile(imageRoute)
            ivBookCover.setImageBitmap(returnImage)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == 0) {
                // A permissão foi concedida. Pode continuar
            } else {
                // A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
        }
    }

}
