package co.zsmb.rainbowcake.ninetysixpoems

import android.os.Bundle
import android.widget.Toast
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import co.zsmb.rainbowcake.ninetysixpoems.ui.list.ListFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import timber.log.Timber


class MainActivity : SimpleNavActivity() {
    private val TAG = "co.zsmb.rainbowcake.ninetysixpoems.MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(ListFragment())
        }

        val database = Firebase.database
        val myRef = database.getReference("message")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Timber.d(TAG, "Value is: $value")
                Toast.makeText(applicationContext, "$value", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Timber.w(error.toException(), "Failed to read value.")
            }
        })

    }

}
