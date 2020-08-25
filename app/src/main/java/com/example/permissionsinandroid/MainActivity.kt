package com.example.permissionsinandroid

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCameraPermission.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"You already have the Camera access permission",Toast.LENGTH_LONG).show()
            }else{
                //Request Permission
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE)
            }
        }

        btnContactPermission.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"You already have Contact access permission",Toast.LENGTH_LONG).show()
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),
                    CONTACT_PERMISSION_CODE)
            }
        }

        btnLocationPermission.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"You already have Location access permission",Toast.LENGTH_LONG).show()
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    FINE_LOCATION_PERMISSION_CODE)
            }
        }

        btnCameraContactLocationPermission.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    ){
                Toast.makeText(this,"You already have Camera,Contact and Location access permission",Toast.LENGTH_LONG).show()
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA,Manifest.permission.READ_CONTACTS,Manifest.permission.ACCESS_FINE_LOCATION),
                    CAMERA_CONTACT_FINE_LOCATION_PERMISSION_CODE)
            }
        }

         fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if(requestCode == CAMERA_PERMISSION_CODE){

                //This code check is necessary to write

                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permission granted for camera",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Oops you just denied the permission for camera",Toast.LENGTH_LONG).show()
                }
            }

             if(requestCode == CONTACT_PERMISSION_CODE){
                 if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                     Toast.makeText(this,"Permission granted for Contact",Toast.LENGTH_LONG).show()
                 }else{
                     Toast.makeText(this,"Oops you just denied the Contact permission",Toast.LENGTH_LONG).show()
                 }
             }
        }
    }

    companion object{
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CONTACT_PERMISSION_CODE =2
        private const val FINE_LOCATION_PERMISSION_CODE =3
        private const val CAMERA_CONTACT_FINE_LOCATION_PERMISSION_CODE = 4
    }
}
