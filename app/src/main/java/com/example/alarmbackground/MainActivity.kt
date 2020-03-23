package com.example.alarmbackground

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    val broadCastRecicver = BootCompleteReceiver()

    companion object {
        const val ZYYX_ALARM_CODE = 12344
        const val REPEAT_TIME: Long = 1000 * 60 * 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAlarm.setOnClickListener {
            Log.e("TAG", "Start alarm")
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var intent = Intent(this, AlarmReceicver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                this,
                ZYYX_ALARM_CODE,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(), REPEAT_TIME,
                pendingIntent
            )
        }

        turnOff.setOnClickListener {
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, AlarmReceicver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(applicationContext,
                ZYYX_ALARM_CODE,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT)
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Turn off alarm ", Toast.LENGTH_SHORT).show()
        }
    }
}
