package com.github.mune0903.qiitaclient_mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mune0903.qiitaclient_mvvm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // databinding使うほどでもないので割愛
        setContentView(R.layout.activity_main)
        // Fragmentをセットする
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance(), MainFragment.TAG)
                .commit()
    }
}
