package com.example.alarmbackground

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        if (intent?.action == Intent.ACTION_BOOT_COMPLETED ||
//                intent?.action == Intent.ACTION_REBOOT){
        Log.e("TAG", "ZYYX-boot-completed")
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intentArlamReceiver = Intent(context, AlarmReceicver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            MainActivity.ZYYX_ALARM_CODE,
            intentArlamReceiver,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            MainActivity.REPEAT_TIME,
            pendingIntent
        )
//        }
    }
}