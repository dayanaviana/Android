package com.android_training.class30

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var notificationId = 1
    var channelId = "Personal_info"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        btn_simple_notification.setOnClickListener {createSimpleNotification()}
        btn_click_notification.setOnClickListener {createNotificationWithClick()}
        btn_action_notification.setOnClickListener {createNotificationWithActionButton()}
        btn_bigText_notification.setOnClickListener {createNotificationWithLargeText() }
        btn_bigImage_notification.setOnClickListener { createNotificationWithLargeImage() }
    }

    private fun createNotificationWithLargeImage() {
        createNotificationChannel()

        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.news)

        var builder = NotificationCompat.Builder(this, channelId)
        builder
            //Set style to support large Texts
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setSmallIcon(R.drawable.ic_info)
            .setContentTitle("My Notification Title")
            .setContentText("This is my notification description")
            .setAutoCancel(true)
            .priority = NotificationCompat.PRIORITY_DEFAULT
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, builder.build())
    }

    private fun createNotificationWithLargeText() {
        createNotificationChannel()

        var myText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

        var builder = NotificationCompat.Builder(this, channelId)
        builder
                //Set style to support large Texts
            .setStyle(NotificationCompat.BigTextStyle().bigText(myText))
            .setSmallIcon(R.drawable.ic_info)
            .setContentTitle("My Notification Title")
            .setContentText("This is my notification description")
            .setAutoCancel(true)
            .priority = NotificationCompat.PRIORITY_DEFAULT
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, builder.build())
    }

    private fun createNotificationWithActionButton() {
        createNotificationChannel()

        var yesIntent = Intent(this, YesActivity::class.java)
        var yesPendingIntent = PendingIntent.getActivity(this,
            0, yesIntent, PendingIntent.FLAG_ONE_SHOT)

        var noIntent = Intent(this, NoActivity::class.java)
        var noPendingIntent = PendingIntent.getActivity(this,
            0, noIntent, PendingIntent.FLAG_ONE_SHOT)

        var builder = NotificationCompat.Builder(this, channelId)
        builder
            .setSmallIcon(R.drawable.ic_info)
            .setContentTitle("My Notification Title")
            .setContentText("This is my notification description")
                //ADD ACTIONS
            .addAction(R.drawable.ic_check, "Yes", yesPendingIntent)
            .addAction(R.drawable.ic_close, "No", noPendingIntent)
            .setAutoCancel(true)
            .priority = NotificationCompat.PRIORITY_DEFAULT
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, builder.build())
    }

    private fun createNotificationWithClick() {
        createNotificationChannel()

        var intent = Intent(this, LandingActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        var builder = NotificationCompat.Builder(this, channelId)
        builder
            .setSmallIcon(R.drawable.ic_info)
            .setContentTitle("My Notification Title")
            .setContentText("This is my notification description")
                // Clickable Notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .priority = NotificationCompat.PRIORITY_DEFAULT
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, builder.build())
    }

    private fun createSimpleNotification() {
        createNotificationChannel()

        var builder = NotificationCompat.Builder(this, channelId)
        builder
                .setSmallIcon(R.drawable.ic_info)
                .setContentTitle("My Notification Title")
                .setContentText("This is my notification description")
                .priority = NotificationCompat.PRIORITY_DEFAULT
        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(2, builder.build())
    }

    private fun createNotificationChannel() {
        //If android version higher than OREO
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var name = "Personal_Info"
            var description = "Include all your personal information"
            var importance = NotificationManager.IMPORTANCE_DEFAULT
            var notificationChannel = NotificationChannel(channelId, name, importance)

            notificationChannel.description = description

            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //To clear notification
            //notificationManager.cancelAll()
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}