package can.co.id.mytimepickerdialog

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val myCalender = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPilih = findViewById<Button>(R.id.main_btn_pilih)
        btnPilih.setOnClickListener {
            pilihWaktu()
        }

    }

    fun pilihWaktu() {

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            myCalender.set(Calendar.HOUR_OF_DAY, hour)
            myCalender.set(Calendar.MINUTE, minute)

            val waktu = SimpleDateFormat(" HH:mm").format(myCalender.time)

            val tvWaktu = findViewById<TextView>(R.id.main_tv_jam)
            tvWaktu.text = waktu

        }

        TimePickerDialog(
            this,
            timeSetListener,
            myCalender.get(Calendar.HOUR_OF_DAY),
            myCalender.get(Calendar.MINUTE),
            true
        ).show()

    }

}