package co.zsmb.rainbowcake.ninetysixpoems

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import co.zsmb.rainbowcake.ninetysixpoems.ui.linelist.LineListFragment


class MainActivity : SimpleNavActivity() {
    private val TAG = "co.zsmb.rainbowcake.ninetysixpoems.MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(LineListFragment())
        }
    }

}
