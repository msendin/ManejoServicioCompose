package com.example.manejoserviciocompose

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ElServicio: Service() {

    private lateinit var player1: MediaPlayer
    private lateinit var player2: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show()
        player1 = MediaPlayer.create(this, R.raw.train)
        player1.setLooping(true)
        player2 = MediaPlayer.create(this, R.raw.bob_marley_cybl)
        player2.setLooping(true)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if (intent!!.extras!!.getString(MainActivity.MYDEFAULTSTRING_ID).equals(R.string.key1.toString())) {
            Toast.makeText(this, R.string.audioinc, Toast.LENGTH_LONG).show()
            player1.start()
        } else if (intent.extras!!.getString(MainActivity.MYDEFAULTSTRING_ID).equals(R.string.key2.toString())) {
            Toast.makeText(this, R.string.songinc, Toast.LENGTH_LONG).show()
            player2.start()
        }
        return startId
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show()
        if (player1.isPlaying) player1.stop()
        if (player2.isPlaying) player2.stop()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }
}