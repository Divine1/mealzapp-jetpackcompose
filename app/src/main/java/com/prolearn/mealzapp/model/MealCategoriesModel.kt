package com.prolearn.mealzapp.model;

import com.google.gson.annotations.SerializedName
import com.prolearn.mealzapp.repository.MealCategoriesRepository


data class MealCategoriesModel (
    val categories : List<MealCategoryItem>
)

data class MealCategoryItem(
    @SerializedName("idCategory")
    val id : String,
    @SerializedName("strCategory")
    val name : String,
    @SerializedName("strCategoryDescription")
    val description : String,
    @SerializedName("strCategoryThumb")
    val imageUrl : String,
)