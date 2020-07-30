package rebekahcafe.example.RebekahCafe

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.RebekahCafe.R


class MainActivity : AppCompatActivity() {
    private var mOrderMessage: String = ""

    companion object {
        const val EXTRA_MESSAGE = "com.example.RebekahCafe.extra.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View?): Boolean {
        when (item.getItemId()) {
            R.id.action_order -> {
                val intent = Intent(this@MainActivity, OrderActivity::class.java)
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage)
                startActivity(intent)
                return true
            }
        }
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_order -> {
                displayToast(getString(R.string.action_order_message))
                return true
            }
            R.id.action_status -> {
                displayToast(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                displayToast(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                displayToast(getString(R.string.action_contact_message))
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}