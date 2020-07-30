package com.example.RebekahCafe

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity


class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = intent
        val message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView: TextView = findViewById(R.id.order_textview)
        textView.text = message

        // Create the spinner.

        // Create the spinner.
        val spinner: Spinner = findViewById(R.id.label_spinner)
        spinner.onItemSelectedListener = this

        // Create ArrayAdapter using the string array and default spinner layout.

        // Create ArrayAdapter using the string array and default spinner layout.
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.labels_array, android.R.layout.simple_spinner_item
        )

        // Specify the layout to use when the list of choices appears.
        setDropDownViewResource()
        (android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner.
        spinner.adapter = adapter

    }

    private fun displayToast(message: String?) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        // Check which radio button was clicked.
        when (view.getId()) {
            R.id.sameday -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))
            else -> {
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val spinnerLabel = parent.getItemAtPosition(i).toString()
        displayToast(spinnerLabel)
    }
}

private fun setDropDownViewResource() {}



