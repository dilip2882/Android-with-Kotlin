package com.dilip.alarmexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Vibrator
import android.provider.Settings
import android.widget.Toast


class AlarmManagerReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Alarming", Toast.LENGTH_SHORT).show()

        val media = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI)
        media.start()

//        val vibrator = context!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//        vibrator.vibrate(2000)

    }
}