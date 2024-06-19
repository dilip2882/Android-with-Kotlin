package com.dilip.intentserviceexample

import android.app.IntentService
import android.content.Intent
import android.util.Log

// MyIntentService class that extends IntentService for handling asynchronous task requests in a service on a separate handler thread.
class MyIntentService : IntentService("MyIntentService") {

    // Initializer block that runs when an instance of the class is created.
    init {
        instance = this // Assign the current instance to the companion object variable 'instance'.
    }

    // Companion object to hold static members which can be accessed without having an instance of the class.
    companion object {
        private lateinit var instance: MyIntentService // Lateinit variable to hold the last created instance of MyIntentService.
        var isRunning = false // Flag to keep track of service running state.

        // Function to stop the service from outside.
        fun stopService() {
            Log.d("MyIntentService", "Service is stopping...") // Log message indicating service is stopping.
            isRunning = false // Set the running flag to false.
            instance.stopSelf() // Stop the service instance.
        }
    }

    // This method is invoked on the worker thread with a request to process. Only one Intent is processed at a time, but the processing happens on a worker thread that runs independently from other application logic.
    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true // Set the running flag to true when service starts handling an intent.
            while (isRunning) { // Loop as long as isRunning is true.
                Log.d("MyIntentService","Service is running...") // Log message indicating service is running.
                Thread.sleep(1000) // Sleep for 1 second before next iteration.
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt() // Re-interrupt the thread if it was interrupted during sleep/wait.
        }
    }
}
