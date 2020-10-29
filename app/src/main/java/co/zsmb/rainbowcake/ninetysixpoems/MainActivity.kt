package co.zsmb.rainbowcake.ninetysixpoems

import android.os.Bundle
import co.zsmb.rainbowcake.ninetysixpoems.ui.list.ListFragment
import co.zsmb.rainbowcake.navigation.SimpleNavActivity

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(ListFragment())
        }
    }

}
