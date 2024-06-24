package com.dilip.contentproviderexample

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.dilip.contentproviderexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View binding
    private lateinit var binding: ActivityMainBinding

    // LiveData to hold contact list
    private val list: MutableLiveData<MutableSet<String>> = MutableLiveData()

    // Permission result callback
    private val registerActivityForResult =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                list.postValue(getContactList())
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch and observe contact list
        list.postValue(getContactList())
        list.observe(this) {
            it?.let {
                binding.rvContacts.adapter = MainAdapter(it.toList())
            }
        }
    }

    @SuppressLint("Range", "Recycle")
    fun getContactList(): MutableSet<String> {
        val set = mutableSetOf<String>()
        sdkIntAboveOreo {
            isPermissionGranted(this, android.Manifest.permission.READ_CONTACTS) {
                if (it) {
                    val contentResolver = applicationContext.contentResolver
                    val cursor = contentResolver.query(
                        ContactsContract.Contacts.CONTENT_URI,
                        null,
                        null,
                        null
                    )
                    if (cursor?.moveToFirst() == true) {
                        do {
                            val name =
                                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                            set.add(name)
                        } while (cursor.moveToNext())
                    }
                } else {
                    registerActivityForResult.launch(android.Manifest.permission.READ_CONTACTS)
                }
            }
        }
        return set
    }

    private inline fun sdkIntAboveOreo(call: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            call.invoke()
        }
    }

    private inline fun isPermissionGranted(
        context: Context,
        permission: String,
        call: (Boolean) -> Unit
    ) {
        if (ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            call.invoke(true)
        } else {
            call.invoke(false)
        }
    }
}





