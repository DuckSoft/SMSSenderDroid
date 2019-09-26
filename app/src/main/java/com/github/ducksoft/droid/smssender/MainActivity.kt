package com.github.ducksoft.droid.smssender

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ktor.util.KtorExperimentalAPI
import org.jetbrains.anko.AnkoLogger

class MainActivity : AppCompatActivity(), AnkoLogger {
    @KtorExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
