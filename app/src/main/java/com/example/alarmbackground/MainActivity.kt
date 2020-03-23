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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnAlarm.setOnClickListener {
            Log.e("TAG", "Start alarm")
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var intent = Intent(this, AlarmRecicver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                this,
                0, intent, 0
            )
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 900000, 900000,
                pendingIntent
            )
        }

        turnOff.setOnClickListener {
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, AlarmRecicver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, 0)
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Turn off alarm ", Toast.LENGTH_SHORT).show()
        }

    }


}
