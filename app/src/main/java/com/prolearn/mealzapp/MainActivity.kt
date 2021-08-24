package com.prolearn.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prolearn.mealzapp.model.FootballRequestModel
import com.prolearn.mealzapp.ui.theme.MealzAppTheme
import com.prolearn.mealzapp.viewmodel.MealCategoriesViewModel
import com.prolearn.mealzapp.viewmodel.SportsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                // A surface container using the 'background' color from the theme
                MealCategoriesScreen("Android")
            }
        }
    }
}

@Composable
fun MealCategoriesScreen(name: String) {

//    val viewModel : MealCategoriesViewModel = viewModel();
//
//
//    viewModel.getMeals({response  ->
//        println(response);
//    })

    val viewModelSports : SportsViewModel= viewModel();
//    viewModelSports.getSports({
//        response ->
//        println("main response");
//
//        println(response);
//    })
//
//
//
//    viewModelSports.getFootball({ response ->
//        println("football response");
//
//        println(response);
//    })


    viewModelSports.postFootball(FootballRequestModel("ronaldo","brazil"), { response ->
        println("postFootball response");

        println(response);
    })

    Surface(color = Color.Blue,
    modifier = Modifier.fillMaxSize()){
        Text(
            text = "Hello $name!",
            color = Color.Green
        )
//        Button(onClick = { /*TODO*/ }) {
//            Text("click here")
//        }

    }
}

@Composable
fun DemoButton(text : String){
//    Text("click here")
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                shape = MaterialTheme.shapes.medium,
                onClick = { }) {
                Text("Demo here")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        DemoButton("Android")
    }
}