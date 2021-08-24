package com.prolearn.mealzapp.viewmodel

import androidx.lifecycle.ViewModel
import com.prolearn.mealzapp.model.FootballRequestModel
import com.prolearn.mealzapp.model.FootballResponseModel
import com.prolearn.mealzapp.model.SportsModel
import com.prolearn.mealzapp.repository.SportsRepository

class SportsViewModel : ViewModel {
    private val sportsRepository:SportsRepository;
    constructor(){
        sportsRepository = SportsRepository();
    }
    fun getSports(successCallback : (response:SportsModel?)->Unit ){
        println("SportsViewModel getSports")
        sportsRepository.getSports(successCallback)
    }

    fun getFootball(successCallback : (response:SportsModel?)->Unit ){
        println("SportsViewModel getFootball")
        sportsRepository.getFootball(successCallback)
    }
    fun postFootball(footballRequestModel : FootballRequestModel, successCallback : (response:FootballResponseModel?)->Unit ){
        println("SportsViewModel postFootball")
        sportsRepository.postFootball(footballRequestModel, successCallback)
    }
}