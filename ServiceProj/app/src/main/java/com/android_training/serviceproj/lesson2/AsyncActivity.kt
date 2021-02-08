package com.android_training.serviceproj.lesson2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android_training.serviceproj.R
import kotlinx.android.synthetic.main.activity_async.*
import java.io.BufferedInputStream
import java.net.URL

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        progressBar.visibility = View.GONE
        progressBar2.visibility = View.GONE

        btn_download.setOnClickListener {
            var myTask = MyTask()
            myTask.execute()
        }

        btn_download_image.setOnClickListener {
//            var url = "https://i.pinimg.com/originals/52/bc/39/52bc3928fd63daa22ebfb555f9ae07dd.jpg"
            var imgTask = DownloadImageTask()
            imgTask.execute()
        }
    }

    inner class MyTask : AsyncTask<String,Int,String>() {
        override fun doInBackground(vararg params: String?): String {
            for (i in 1..10) {
                Thread.sleep(1000)
                publishProgress(i)
            }
            var downloadedString = "Downloaded the Data"
            return downloadedString
        }

        //Small setup: Load progress bar
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            //Receive data as array
            var data = values[0]
            txt_async_result.text = "Downloading $data%"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            txt_async_result.text = result
            progressBar.visibility = View.GONE
        }
    }

    inner class DownloadImageTask: AsyncTask<String, Int, Bitmap>(){
        override fun doInBackground(vararg params: String?): Bitmap {
            var url = URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzgWcxMVoaRo8P3sE4pEWetUGSB1z_To4O0g&usqp=CAU")
            var connection = url.openConnection()
            var inputStream = connection.getInputStream()
            var bufferedInputStream = BufferedInputStream(inputStream)
            return BitmapFactory.decodeStream(bufferedInputStream)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar2.visibility = View.VISIBLE
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            progressBar2.visibility = View.GONE
            img_downloaded.setImageBitmap(result)
        }

    }
}