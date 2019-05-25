package omuomugin.io.runningrustonandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import omuomugin.io.rustclient.RustClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RustClient.initialize()

        findViewById<Button>(R.id.add_result).setOnClickListener {
            val result = RustClient.additionOnRust(this, 1, 1)
            findViewById<TextView>(R.id.text_view).text = result.toString()
        }
    }
}
