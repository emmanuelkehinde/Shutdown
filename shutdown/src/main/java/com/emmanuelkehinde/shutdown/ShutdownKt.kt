package com.emmanuelkehinde.shutdown

import android.app.Activity
import android.widget.Toast

class ShutdownKt {
    companion object {
        private const val DEFAULT_TIMEOUT: Long = 3000
        private const val DEFAULT_MESSAGE = "Press back again to close"
        private var lastClickTime: Long = 0

        /**
         * Static method to be called that handles closing of the app interactively
         *
         * @param context the Activity as a context
         * @param message the message to be displayed
         * @param timeout the time before it resets, whereby user is required to press back twice again
         */

        fun now(context: Activity?, message: String= DEFAULT_MESSAGE, timeout: Long = DEFAULT_TIMEOUT) {
            context?.let { init(it, message, timeout) }
        }

        /**
         * Helper method
         *
         * @param context the Activity as a context
         * @param message the message to be displayed
         * @param timeout the time before it resets, whereby user is required to press back twice again
         */
        private fun init(context: Activity, message: String, timeout: Long) {
            if (lastClickTime + timeout > System.currentTimeMillis()) {
                context.finish()
            } else {
                makeText(context, message)
                lastClickTime = System.currentTimeMillis()
            }
        }

        /**
         * Shows a toast with the specified message in given context
         *
         * @param context the Activity as a context
         * @param message the message to be displayed
         */
        private fun makeText(context: Activity, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}