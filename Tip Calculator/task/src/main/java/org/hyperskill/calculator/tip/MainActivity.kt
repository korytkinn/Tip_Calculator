package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.Slide
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edittext: EditText = findViewById(R.id.edit_text)
        val slider: Slider = findViewById(R.id.slider)
        val textview: TextView = findViewById(R.id.text_view)

        var final: Double = 0.0

        slider.addOnChangeListener { slider, value, fromUser ->
            // Responds to when slider's value is changed
            if (edittext.getText().toString().equals("")) {
                textview.setText("")
            } else {

                final = (edittext.text.toString().toDouble() * slider.value.toDouble()) / 100.0

                textview.setText("Tip amount:" + " " + "%.2f".format(final))

            }

        }


        findViewById<EditText>(R.id.edit_text).addTextChangedListener(object : TextWatcher {
            var old = ""
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                old = s?.toString() ?: ""
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (edittext.getText().toString().equals("")) {
                    textview.setText("")
                } else {
                    final = (edittext.text.toString().toDouble() * slider.value.toDouble()) / 100.0

                    textview.setText("Tip amount:" + " " + "%.2f".format(final))


                }
            }
        })


    }


}