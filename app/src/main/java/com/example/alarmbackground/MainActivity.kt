package com.example.alarmbackground

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAlarm.setOnClickListener{
            val alarmManager  = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var intent = Intent(this,AlarmRecicver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this,
                0, intent, 0)
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime() + 5000, 5000,
                pendingIntent)
        }
    }
}
