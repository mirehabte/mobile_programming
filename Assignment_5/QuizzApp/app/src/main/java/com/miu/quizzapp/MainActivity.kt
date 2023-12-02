package com.miu.quizzapp

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit.setOnClickListener {
            var id = rGDrinks.checkedRadioButtonId
            if (id == R.id.rbJuice){
                score += 50
            }

            if ((!kfc.isChecked()) && (raisin.isChecked() && potato.isChecked())) {
                score += 50
            }
            val dialogBuilder = AlertDialog.Builder(this)

            val sdf = SimpleDateFormat("M/d/yyyy hh:mm")
            val currentDate = sdf.format(Date())

            dialogBuilder.setMessage("Congratulations! You submitted on $currentDate \n You achieved $score%")
                .setCancelable(false)
                .setPositiveButton("Done", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id ->
                    run {
                        dialog.cancel()
                        this.score = 0
                    }
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Quiz Result")
            alert.show()
        }

        reset.setOnClickListener{

            rGDrinks.clearCheck()
            kfc.setChecked(false)
            raisin.setChecked(false)
            potato.setChecked(false)
            score=0
        }
    }
}