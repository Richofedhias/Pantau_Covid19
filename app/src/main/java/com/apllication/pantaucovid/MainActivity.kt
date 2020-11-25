package com.apllication.pantaucovid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apllication.pantaucovid.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData(){
        ApiService.endpoint.getData()
            .enqueue(object : Callback<List<MainModel>>{
                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                    if (response.isSuccessful){
                        val mainModel: List<MainModel> = response.body()!!
                        setResponse(mainModel)
                    }
                }
            })
    }


    private fun setResponse(mainModel: List<MainModel>){
        val response = mainModel[0]
        tV_positif.setText(
            "${response.positif}"
        )

        tV_meninggal.setText(
            "${response.meninggal}"
        )

        tV_sembuh.setText(
            "${response.sembuh}"
        )
    }
}