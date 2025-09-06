package com.yanni.notisms.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.view.setPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ရိုးရိုး UI (XML မသုံး)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32)
        }

        val title = TextView(this).apply {
            text = "NotiSms"
            textSize = 22f
        }
        val info = TextView(this).apply {
            text = "• Notification access ကို Allow လိုအပ်\n• SMS လာရင် background မှာ လက်ခံမယ်"
            textSize = 14f
        }
        val openNotifAccess = Button(this).apply {
            text = "Open Notification Access"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            }
        }

        root.addView(title)
        root.addView(info)
        root.addView(openNotifAccess)

        setContentView(root)
    }
}
