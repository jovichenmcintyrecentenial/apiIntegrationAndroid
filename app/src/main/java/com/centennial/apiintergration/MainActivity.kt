package com.centennial.apiintergration

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {


    var queue: RequestQueue? = null
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queue = Volley.newRequestQueue(this)
        textView = findViewById<TextView>(R.id.textView2)
    }

    fun getUsers(view: View) {

        val url = "https://zv-rest-server.herokuapp.com/users"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response -> // Display the first 500 characters of the response string.
                textView.text = "Response is: $response"
            }) { textView.text = "That didn't work!" }

        queue!!.add(stringRequest);
    }
}