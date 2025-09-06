package com.yanni.notisms.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION != intent.action) return
        val msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        val body = msgs.joinToString(separator = "") { it.displayMessageBody }
        Log.d("SmsReceiver", "SMS: $body")
    }
}
