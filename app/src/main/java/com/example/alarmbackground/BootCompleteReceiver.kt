package com.example.alarmbackground

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED){
            Log.e("TAG", "reboot")
            val alarmManager  = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var intent2 = Intent(context,AlarmRecicver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context,
                0, intent2, 0)
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime() + 2000, 2000,
                pendingIntent)
        }
    }

}