package com.prolearn.mealzapp.viewmodel;

import androidx.lifecycle.ViewModel
import com.prolearn.mealzapp.model.MealCategoriesModel
import com.prolearn.mealzapp.repository.MealCategoriesRepository

//class MealCategoriesViewModel (private val mealCategoriesRepository :MealCategoriesRepository = MealCategoriesRepository() ) : ViewModel() {
class MealCategoriesViewModel  : ViewModel {
    private val mealCategoriesRepository : MealCategoriesRepository;
    constructor(){
        mealCategoriesRepository = MealCategoriesRepository();
    }

    fun getMeals(successCallback : (response: MealCategoriesModel?) -> Unit){
        mealCategoriesRepository.getMeals(successCallback);
    }
}