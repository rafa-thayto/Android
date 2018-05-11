package informatica.sp.senai.br.vanbus.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import informatica.sp.senai.br.vanbus.R
import informatica.sp.senai.br.vanbus.dao.VehicleDAO
import informatica.sp.senai.br.vanbus.helper.VehicleFormHelper

class VehiclesFormActivity : AppCompatActivity() {

    private val getImageCode = 1
    val PERMISSION_REQUEST = 1
    lateinit var helper: VehicleFormHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles_form)

        helper = VehicleFormHelper(this)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        helper.imagePath.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, getImageCode)
        }

        btnRegister.setOnClickListener {
            val helper = VehicleFormHelper(this)
            val dao = VehicleDAO(this)
            val vehicle = helper.getVehicle()
            dao.insert(vehicle)
            finish()
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST)
            }
        }

    } // End onCreate

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        helper = VehicleFormHelper(this)

        when (requestCode) {
            getImageCode -> if (resultCode == RESULT_OK) {

                val uri = data?.data
                val projection = arrayOf(MediaStore.Images.Media.DATA)
                val cursor: Cursor = contentResolver.query(uri, projection, null, null, null)
                cursor.moveToFirst()

                val columnIndex = cursor.getColumnIndex(projection[0])
                val filepath = cursor.getString(columnIndex)
                cursor.close()

                Log.e("IMAGE URI ANTES", helper.imageUri)
                this.helper.imageUri = filepath

                val bitmap = BitmapFactory.decodeFile(this.helper.imageUri)
                helper.imagePath.setImageBitmap(bitmap)

                Log.e("IMAGE URI DEPOIS", helper.imageUri)

            }
        }

    } // End onActivityResult
}
