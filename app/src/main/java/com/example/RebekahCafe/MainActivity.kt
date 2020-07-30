package com.example.RebekahCafe

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mOrderMessage: String = ""

    companion object {
        val EXTRA_MESSAGE = "com.example.droidcafe.extra.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View?) {
        val intent = Intent(this@MainActivity, OrderActivity::class.java)
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, mOrderMessage)
        startActivity(intent)
    }

    private fun displayToast(message: String?) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

    /**
     * Shows a message that the froyo sandwich image was clicked.
     */
    fun ShowFroyoOrder(view: View) {
        mOrderMessage = getString(R.string.froyo_order_message)
        displayToast(mOrderMessage)

    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    fun ShowIceCreamOrder(view: View) {
        mOrderMessage = getString(R.string.ice_cream_order_message)
        displayToast(mOrderMessage)
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    fun ShowDonutOrder(view: View) {
        mOrderMessage = getString(R.string.donut_order_message)
        displayToast(mOrderMessage)
    }
}