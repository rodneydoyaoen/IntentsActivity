package com.example.loginactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.webkit.URLUtil
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        findViewById<Button>(R.id.openYt).setOnClickListener{ (playMusic()) }
        findViewById<Button>(R.id.openGoogleP).setOnClickListener{ (openGooglePlay()) }
        findViewById<Button>(R.id.dialNumber).setOnClickListener{ (composeText()) }
        findViewById<Button>(R.id.searchBrowser).setOnClickListener{ (searchBrowser()) }
        findViewById<Button>(R.id.getFile).setOnClickListener{ (openDoc()) }

    }
    private fun playMusic(){

        val webpage:Uri = Uri.parse("https://www.youtube.com/")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }
    private fun openGooglePlay(){
        val gp = Uri.parse("market://details?id=com.mobile.legends")
        val intent = Intent(Intent.ACTION_VIEW, gp)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun composeText(){
        val dateSet = Intent(Intent.ACTION_DIAL, Uri.parse("tel:09179309264"))
        startActivity(dateSet)
    }
    private fun searchBrowser(){
        val uri_t: Uri = Uri.parse("nothing")
        val search= Intent(Intent.ACTION_VIEW, uri_t)
        if(URLUtil.isValidUrl("nothing")){
            startActivity(search)
        }
        else{
            Toast.makeText(this, "The intent failed due to an invalid URI.", Toast.LENGTH_LONG).show()
        }
    }
    private fun openDoc(){
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator.toString() +
                "content://com.android.providers.downloads.documents/image1.jpg")
        val path = Uri.fromFile(file)
        val openFile = Intent(Intent.ACTION_VIEW)
        if(file.exists()) {
            startActivity(openFile)
        }
        else {
            Toast.makeText(this, "The intent failed due to file that does not exist.", Toast.LENGTH_LONG).show()
        }
    }
}