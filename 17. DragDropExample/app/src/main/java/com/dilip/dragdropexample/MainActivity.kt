package com.dilip.dragdropexample

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dilip.dragdropexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set drag listeners for top and bottom LinearLayouts
        binding.llTop.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)

        // Set a long click listener on the view to be dragged
        binding.dragView.setOnLongClickListener {
            // Define the clip data with a label, mime type, and actual text data
            val clipText = "This is our clipData text"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            // Create a new DragShadowBuilder for the view
            val dragShadowBuilder = View.DragShadowBuilder(it)
            // Start the drag-and-drop operation
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            // Make the view invisible while dragging
            it.visibility = View.INVISIBLE
            true // Return true to indicate the listener has consumed the event
        }
    }

    // Define an OnDragListener to handle drag events
    val dragListener = View.OnDragListener { view, event ->
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                // Determine if this view can accept the dragged data
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                // Redraw the view when the dragged item enters its bounds
                view.invalidate()
                true // Return true to indicate the listener has consumed the event
            }

            DragEvent.ACTION_DRAG_LOCATION -> true // Continue to receive drag events

            DragEvent.ACTION_DRAG_EXITED -> {
                // Redraw the view when the dragged item exits its bounds
                view.invalidate()
                true // Return true to indicate the listener has consumed the event
            }

            DragEvent.ACTION_DROP -> {
                // Get the dragged data and display it in a Toast message
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                // Redraw the view after dropping
                view.invalidate()

                // Move the dragged view and make it visible again
                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v) // Remove from its previous parent
                val destination = view as LinearLayout
                destination.addView(v) // Add to its new parent (LinearLayout)
                v.visibility = View.VISIBLE // Make it visible again
                true // Return true to indicate the listener has consumed the event
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                // Redraw the view when drag ends
                view.invalidate()
                true // Return true to indicate the listener has consumed the event
            }

            else -> false // Return false for unhandled events
        }
    }
}
