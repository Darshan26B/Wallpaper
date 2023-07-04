package com.example.wallpaper

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: WallpaperAdapter
    var auth = "OgaZ8JxwYFn6MS5T4iqRiAZWFlunLNE1iyBnwOqiCFO7SqEM7rLZlbRk"

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallpaperAdapter()

        Enter_clickSearch()
        binding.btnSearch.setOnClickListener {
            WallPaperCallApi()
        }
        binding.searchIcon.setOnClickListener {
            WallPaperCallApi()
        }


    }

    private fun WallPaperCallApi() {
        var  edt =binding.edtSearch.text.toString()

        var api = WallpaperClient.getWPClient()?.create(WallpaperInterface ::class.java)
        api?.getWP(auth,edt)?.enqueue(object :retrofit2.Callback<WallpaperModel>{
            override fun onResponse(
                call: Call<WallpaperModel>,
                response: Response<WallpaperModel>
            ) {
                if (response.isSuccessful) {
                    var photos = response.body()?.photos
                    adapter.setphotos(photos)

                    binding.rcvWallpaper.layoutManager =GridLayoutManager(this@MainActivity,2)
                    binding.rcvWallpaper.adapter = adapter
                }
            }

            override fun onFailure(call: Call<WallpaperModel>, t: Throwable) {
            }

        })
    }
    fun  Enter_clickSearch() {
        binding.edtSearch.setOnKeyListener(View.OnKeyListener{v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action==KeyEvent.ACTION_UP ) {
               WallPaperCallApi()
                CloseSearch()
                return@OnKeyListener true
            }
            false

        })
    }
    fun CloseSearch() {
        val View =this.currentFocus
        if(View !=null) {
            var close  =getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
            close.hideSoftInputFromWindow(View.windowToken,0)
        }
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}