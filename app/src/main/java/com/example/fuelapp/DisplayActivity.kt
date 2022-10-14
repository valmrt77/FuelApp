package com.example.fuelapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.ImageView
import android.widget.TextView
import java.util.Objects

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Get the Intent that started this activity and extract the gas name
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // API LINK : https://data.economie.gouv.fr/api/v2

        print(getStationData())

        // WRITE HERE THE GAS STATION NAME :
        val gasStationName = findViewById<TextView>(R.id.gas_station_name).apply {
            text = message.gasStationName
        }

        val stationImage = findViewById<ImageView>(R.id.station_image).apply {
            //img = image
        }

        val textView = findViewById<TextView>(R.id.item_detail).apply {
            text = message
        }
    }

    private fun getStationData() {

        val GasStation = object {
            val stationName = "Carrefour"
            val gasPrice = "1.54"
            // object expressions extend Any, so `override` is required on `toString()`
            override fun toString() = "$stationName $gasPrice"
        }

        print(GasStation)
    }
}