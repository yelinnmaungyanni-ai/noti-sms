package com.yanni.notisms.services

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotiListener : NotificationListenerService() {
    override fun onListenerConnected() {
        Log.d("NotiListener", "connected")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val extras = sbn.notification.extras
        val title = extras?.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
        val text  = extras?.getCharSequence(Notification.EXTRA_TEXT )?.toString().orEmpty()
        val body = listOf(title, text).filter { it.isNotBlank() }.joinToString("\n")
        if (body.isNotBlank()) {
            Log.d("NotiListener", "from=${sbn.packageName} body=$body")
        }
    }
}
