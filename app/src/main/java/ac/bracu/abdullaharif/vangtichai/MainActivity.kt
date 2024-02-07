package ac.bracu.abdullaharif.vangtichai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // variable declaration
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnClear: Button

    private lateinit var tvTotal: TextView

    // restoring key-value pair declaration
    private var KEY_TOTAL_AMOUNT = "totalAmount"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // catching button values
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnClear = findViewById(R.id.btnClear)

        tvTotal = findViewById(R.id.tvTotal)

        // sending the button values for processing
        setNumberButtonClickListener(btn1, "1")
        setNumberButtonClickListener(btn2, "2")
        setNumberButtonClickListener(btn3, "3")
        setNumberButtonClickListener(btn4, "4")
        setNumberButtonClickListener(btn5, "5")
        setNumberButtonClickListener(btn6, "6")
        setNumberButtonClickListener(btn7, "7")
        setNumberButtonClickListener(btn8, "8")
        setNumberButtonClickListener(btn9, "9")
        setNumberButtonClickListener(btn0, "0")

        // Set click listener for clear button
        btnClear.setOnClickListener {
            clearTextView()
        }

        // restore the saved state ***NEED TO BE SOLVED***
        savedInstanceState?.let {
            val totalAmount = it.getInt(KEY_TOTAL_AMOUNT)
            tvTotal.text = totalAmount.toString()
            calculateNotes()
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        // Save the current total amount when the activity is about to be destroyed ***NEED TO BE SOLVED***
        outState.putInt(KEY_TOTAL_AMOUNT, tvTotal.text.toString().toInt())
        super.onSaveInstanceState(outState)

    }

    private fun clearTextView() {
        tvTotal.text = ""
        updateTextView("tv500notes", 0)
        updateTextView("tv100notes", 0)
        updateTextView("tv50notes", 0)
        updateTextView("tv20notes", 0)
        updateTextView("tv10notes", 0)
        updateTextView("tv5notes", 0)
        updateTextView("tv2notes", 0)
        updateTextView("tv1notes", 0)
    }

    private fun setNumberButtonClickListener(button: Button, number: String) {
        // appends to total amount textview
        button.setOnClickListener {
            appendToTextView(number)
        }
    }

    private fun appendToTextView(number: String) {
        val currentText = tvTotal.text.toString()
        tvTotal.text = currentText + number
        calculateNotes()
    }

    private fun calculateNotes() {
        var baseAmount = tvTotal.text.toString().toInt()
        val denominations = listOf(500, 100, 50, 20, 10, 5, 2, 1)

        for (denomination in denominations) {
            val notesCount = baseAmount / denomination
            baseAmount %= denomination

            // Update the corresponding TextView based on the denomination
            when (denomination) {
                500 -> updateTextView("tv500notes", notesCount)
                100 -> updateTextView("tv100notes", notesCount)
                50 -> updateTextView("tv50notes", notesCount)
                20 -> updateTextView("tv20notes", notesCount)
                10 -> updateTextView("tv10notes", notesCount)
                5 -> updateTextView("tv5notes", notesCount)
                2 -> updateTextView("tv2notes", notesCount)
                1 -> updateTextView("tv1notes", notesCount)
            }
        }
    }

    private fun updateTextView(textViewId: String, notesCount: Int) {
        val textView = findViewById<TextView>(resources.getIdentifier(textViewId, "id", packageName))
        textView.text = notesCount.toString()
    }

}