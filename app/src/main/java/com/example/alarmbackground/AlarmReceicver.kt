package com.example.alarmbackground

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.alarmbackground.client.ClientAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.random.Random

class AlarmReceicver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val getPosts = ClientAPI.Companion.createApi().getNotify();
        Log.e("TAG", "receiver create")
        getPosts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                Log.e("TAG", "notify ${it.notification_enable}" )
                showNotify(it.notification_enable, context)
            }

    }

    private fun createNotify(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mNotificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notifyID = 1
            val CHANNEL_ID = "my_channel_01" // The id of the channel.
            val name = "Hello"// The user-visible name of the channel.
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            val notification: Notification =
                Notification.Builder(context)
                    .setContentTitle("Alarm")
                    .setContentText("Request API")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setChannelId(CHANNEL_ID)
                    .build()
            mNotificationManager.createNotificationChannel(mChannel)
            mNotificationManager.notify(Random(100).nextInt(), notification)
        } else {
            val notification = NotificationCompat.Builder(context)
            notification.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(com.example.alarmbackground.R.mipmap.ic_launcher)
                .setContentText("Request API")

            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
            notificationManager.notify(Random(100).nextInt(), notification.build())
        }
    }

    private fun showNotify(show: Boolean, context: Context?){
        if (show){
            createNotify(context)
        }else {
        }
    }
}