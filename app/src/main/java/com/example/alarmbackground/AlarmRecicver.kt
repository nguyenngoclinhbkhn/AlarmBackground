package com.example.alarmbackground

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.alarmbackground.client.ClientAPI
import com.example.alarmbackground.model.Posts
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlarmRecicver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val getPosts = ClientAPI.Companion.createApi().getNotify();
        getPosts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                Log.e("TAG", "notify ${it.notification_enable}" )
                showNotify(it.notification_enable, context)
            })

    }

    private fun showNotify(show: Boolean, context: Context?){
        val notification = NotificationCompat.Builder(context)
        notification.setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText("Notification")

        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        if (show){
            notificationManager.notify(1, notification.build())
        }else {
            notificationManager.cancel(1)

        }
    }
}