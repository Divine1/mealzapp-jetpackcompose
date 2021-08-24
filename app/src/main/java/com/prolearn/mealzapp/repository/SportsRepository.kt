package com.prolearn.mealzapp.repository

import com.google.gson.Gson
import com.prolearn.mealzapp.model.SportsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.JsonObject
import com.prolearn.mealzapp.model.FootballRequestModel
import com.prolearn.mealzapp.model.FootballResponseModel
import retrofit2.http.*
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class SportsRepository {
    // http://localhost:3000/sports/cricket
    interface SportsApi{
        @GET("cricket")
        fun getCricket() : Call<SportsModel>

        @GET("football/{pid}")
        fun getFootball(@Path("pid")  pid : String,@Query("sname") sname : String) : Call<SportsModel>;

        @POST("football")
        fun postFootball(@Body  footballRequestModel : FootballRequestModel):Call<FootballResponseModel>;
    }
    private lateinit var api : SportsApi;

    init{

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        // baseurl must end with slash as per retrofit otherwise error will be thrown
        // https://apiprojectdemo.wdc-np.tas.vmware.com/sports/cricket
        // http://localhost:3000/sports/
        val retrofit = Retrofit.Builder()
            .baseUrl("https://apiprojectdemo.wdc-np.tas.vmware.com/sports/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

            .build();
        api = retrofit.create(SportsApi::class.java);

    }
    fun getFootball(successCallback: (response: SportsModel?) -> Unit){
        api.getFootball("121","fyou").enqueue(object  : Callback<SportsModel>{
            override fun onResponse(call: Call<SportsModel>, response: Response<SportsModel>) {
                //TODO("Not yet implemented")
                println("sports football response ")
                println(response.isSuccessful)
                println("response")
                println(response)

                println("response.body")
                successCallback(response.body());
            }

            override fun onFailure(call: Call<SportsModel>, t: Throwable) {
                //TODO("Not yet implemented")
                println("sports football onFailure")

            }

        })
    }
    fun getSports(successCallback : (response: SportsModel?)->Unit){
        api.getCricket().enqueue(object : Callback<SportsModel>{
            override fun onResponse(call: Call<SportsModel>, response: Response<SportsModel>) {
                //TODO("Not yet implemented")
                println("sports cricket response ")
                println(response.isSuccessful)
                println("response")
                println(response)


                if(response.isSuccessful){
                    println("response.success body")
                    successCallback(response.body());
                }
                else{
                    println("response.errorBody() ");

                    val error_string = response.errorBody()?.string();
                    println(error_string)
                    val convertedObject: JsonObject = Gson().fromJson(error_string, JsonObject::class.java)

                    println("convertedObject ")
                    println(convertedObject)
                    println("convertedObject.get(\"data\")")
                    println(convertedObject.get("data"))

                }


            }

            override fun onFailure(call: Call<SportsModel>, t: Throwable) {
                //TODO("Not yet implemented")
                println("sports cricket onFailure")
            }

        })
    }

    fun postFootball( footballRequestModel : FootballRequestModel,successCallback: (response: FootballResponseModel?) -> Unit){

        println("SportsRepository postFootball")

        api.postFootball(footballRequestModel).enqueue(object : Callback<FootballResponseModel>{
            override fun onResponse(
                call: Call<FootballResponseModel>,
                response: Response<FootballResponseModel>
            ) {
                println("SportsRepository postFootball onResponse")

                //TODO("Not yet implemented")
                if(response.isSuccessful){
                    println("postFootball response.success body")
                    successCallback(response.body());
                }
                else{
                    println("postFootball response.errorBody() ");

                    val error_string = response.errorBody()?.string();
                    println(error_string)
                    val convertedObject: JsonObject = Gson().fromJson(error_string, JsonObject::class.java)

                    println("convertedObject ")
                    println(convertedObject)
                    println("convertedObject.get(\"data\")")
                    println(convertedObject.get("data"))

                }
            }

            override fun onFailure(call: Call<FootballResponseModel>, t: Throwable) {
                //TODO("Not yet implemented")
                println("SportsRepository postFootball onFailure ")
                println(t.message)
                println(t.cause.toString())
                t.printStackTrace()
            }

        })
    }
}