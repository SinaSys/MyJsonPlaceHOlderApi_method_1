package com.example.myjsonplaceholderapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myjsonplaceholderapi.apiservice.GetPost
import com.example.myjsonplaceholderapi.apiservice.RetrofitInstance
import com.example.myjsonplaceholderapi.model.Post
import com.example.myjsonplaceholderapi.model.PostItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataFromWebService()
    }


    private val getPostItemService: GetPost by lazy {
        RetrofitInstance.getPostApiService
    }


    private fun getDataFromWebService() {
        val call: Call<Post> = getPostItemService.getPostItem()

        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.i("MainActivity", data?.get(1)?.body.toString())

                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.i("MainActivity", t.message.toString())
            }

        })

    }
}
