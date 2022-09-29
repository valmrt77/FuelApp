package com.example.fuelapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var ansSP95: Button? = null
    private var ansSP98: Button? = null
    private var ansE85: Button? = null
    private var ansDiesel: Button? = null

    private var submitBtn: Button? = null
    private var selectedAnswer = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ansSP95 = findViewById(R.id.ans_SP95)
        ansSP98 = findViewById(R.id.ans_SP98)
        ansE85 = findViewById(R.id.ans_E85)
        ansDiesel = findViewById(R.id.ans_Diesel)
        submitBtn = findViewById(R.id.submit_btn)

        ansSP95?.setOnClickListener(this)
        ansSP98?.setOnClickListener(this)
        ansE85?.setOnClickListener(this)
        ansDiesel?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        ansSP95!!.setBackgroundColor(Color.WHITE)
        ansSP98!!.setBackgroundColor(Color.WHITE)
        ansE85!!.setBackgroundColor(Color.WHITE)
        ansDiesel!!.setBackgroundColor(Color.WHITE)


        val clickedButton = view as Button
        //choices button clicked

        if (clickedButton.id == R.id.submit_btn) {
            //submit button clicked

            if (selectedAnswer !== "") {
                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, selectedAnswer)
                }
                startActivity(intent)
            }

        } else {
            //choices button clicked
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.rgb(42, 157, 143))
        }
    }
}
