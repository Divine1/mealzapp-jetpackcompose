package com.prolearn.mealzapp.model

data class SportsModel (
    val name :String,
    val description:String,
    val players:Int,
    val bowlers:Int,
    val batsman:Int
)

data class FootballRequestModel(
    val playername : String,
    val country : String
)

data class FootballResponseModel(
    val data : String
)