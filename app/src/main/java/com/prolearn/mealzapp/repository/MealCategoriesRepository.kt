package com.prolearn.mealzapp.repository;

import com.prolearn.mealzapp.model.MealCategoriesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealCategoriesRepository {

    private lateinit var api : MealsApi;

    init{
        // baseurl must end with slash as per retrofit otherwise error will be thrown
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        api = retrofit.create(MealsApi::class.java);

    }

    interface MealsApi{
        @GET("categories.php")
        fun getMeals(): Call<MealCategoriesModel>
    }

    fun getMeals(successCallback : (response: MealCategoriesModel?) -> Unit){
        api.getMeals().enqueue(object : Callback<MealCategoriesModel> {
            override fun onResponse(
                call: Call<MealCategoriesModel>,
                response: Response<MealCategoriesModel>
            ) {
                //TODO("Not yet implemented")
                println("MealCategoriesRepository getMeals response ")
                println(response.isSuccessful)
                successCallback(response.body())
            }

            override fun onFailure(call: Call<MealCategoriesModel>, t: Throwable) {
                //TODO("Not yet implemented")
                println("MealCategoriesRepository getMeals onFailure ")

            }


        })
    }
}