package com.example.alarmbackground

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "reboot")
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED){
//                intent?.action == Intent.ACTION_REBOOT){
//            Log.e("TAG", "reboot")
//            val alarmManager  = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            var intent2 = Intent(context,AlarmReceiver::class.java)
//            val pendingIntent = PendingIntent.getBroadcast(context,
//                0, intent2, 0)
//            alarmManager.setRepeating(
//                AlarmManager.RTC_WAKEUP,
//                System.currentTimeMillis() + 2000, 2000,
//                pendingIntent)
        }
    }

}