package com.example.foodplanfinished

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    //Home page

    //ST10469845   Kayrey Maistry

    /*References

     background image: https://za.pinterest.com/pin/911486412112811359/
     Burger image: https://za.pinterest.com/pin/28217935160938262/
     Brownie Image: https://za.pinterest.com/pin/18366310975612652/
     Cakes Image: https://za.pinterest.com/pin/639018634665406095/
     Chicken Image: https://za.pinterest.com/pin/886998089113319806/
     Chips Image: https://za.pinterest.com/pin/802977808608739135/
     Chocolate Image: https://za.pinterest.com/pin/127437864450955470/
     desertone Image: https://za.pinterest.com/pin/464081936622694791/
     deserttwo Image: https://za.pinterest.com/pin/7388786881674810/
     desertthree Image: https://za.pinterest.com/pin/28358672650164504/
     desertFour Image: https://za.pinterest.com/pin/284500901454092564/
     fruit Image: https://za.pinterest.com/pin/56717276552179134/
     stir fry Image: https://za.pinterest.com/pin/112871534412211371/
     milktart Image: https://za.pinterest.com/pin/56083957852516493/
     Mousse Image: https://za.pinterest.com/pin/755478906279326981/
     Muffins Image: https://za.pinterest.com/pin/1055599907854554/
     Pasta Image: https://za.pinterest.com/pin/307300374574041990/
     Pie Image: https://za.pinterest.com/pin/401735229279065602/
     Pizza Image: https://za.pinterest.com/pin/136656169940668720/
     Popcorn Image: https://za.pinterest.com/pin/13370130138395822/
     Salmon Image: https://za.pinterest.com/pin/25684660371229100/
     Smoothie Image: https://za.pinterest.com/pin/328551735336539182/
     Steak Image: https://za.pinterest.com/pin/12173861488560738/
     Toast Image: https://za.pinterest.com/pin/408701734952076783/
     Waffles Image: https://za.pinterest.com/pin/83879611805614120/
     food Logo Image: https://za.pinterest.com/pin/4714774598401680/
     */



    private var TimeET : EditText? = null
    private var DisplayTV : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Call the id

        TimeET = findViewById(R.id.TimeET)
        DisplayTV = findViewById(R.id.DisplayTV)

        val Search = findViewById<Button>(R.id.SearchBtn)    //easy words for what the buttons are for
        val Clear = findViewById<Button>(R.id.ClearText)
        val ExitApp = findViewById<Button>(R.id.ExitApp)
        val MoreOptions = findViewById<Button>(R.id.MoreOptBtn)

        Search.setOnClickListener {
            MealPlan()
        }

        MoreOptions.setOnClickListener {
            /*val intent = Intent(this, DisplayFood::class.java)  //Plan to have extra options incase User is unhappy with the one. Show off multiple display
            startActivity(intent)*/ // Have each time of day go to a certian page when clicked. Read whats inserted.
            val meal = TimeET?.text.toString().trim()
            if (meal.equals("Breakfast", ignoreCase = true)) {
                val intent = Intent(this, breakfastPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Lunch", ignoreCase = true)) {
                val intent = Intent(this, lunchPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Snacks", ignoreCase = true)) {
                val intent = Intent(this, snackPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Snack", ignoreCase = true)) {
                val intent = Intent(this, snackPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Dinner", ignoreCase = true)) {
                val intent = Intent(this, dinnerPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Supper", ignoreCase = true)) {
                val intent = Intent(this, dinnerPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Dessert", ignoreCase = true)) {
                val intent = Intent(this, dessertPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Desserts", ignoreCase = true)) {
                val intent = Intent(this, dessertPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Morning", ignoreCase = true)) {
                val intent = Intent(this, breakfastPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Afternoon", ignoreCase = true)) {
                val intent = Intent(this, lunchPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Evening", ignoreCase = true)) {
                val intent = Intent(this, dinnerPage::class.java)
                startActivity(intent)
            }
            else if (meal.equals("Desert", ignoreCase = true)) {
                val intent = Intent(this, desertPage::class.java)
                startActivity(intent)
            }
            else if(isNotEmpty()){
                DisplayTV?.text = "Invalid"
            }
            else {
                DisplayTV?.text = "Don't leave blank"
            }
        }

        Clear.setOnClickListener {
            TimeET?.text?.clear()
            DisplayTV?.text = ""
        }

        ExitApp.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        /*val DisplayMeal = MealPlan()
        DisplayTV?.text = DisplayMeal.toString()*/   //Will display in TextView. .toString is to call the code
    }

    //When text is empty, produce an error
    private fun isNotEmpty() : Boolean
    {
        var b = true
        if (TimeET?.text.toString().trim().isEmpty())
        {
            println(TimeET)
            TimeET?.error = "Don't leave blank"
            b = false
        }
        return b
    }

    //Produce error when there is incorrect spelling, or when time/ numbers are entered
    //Create private function on what the Search Button will execute

    private fun MealPlan () {
        var Meal : String
        //Rather use a when statement
        if (isNotEmpty()) {

            when (TimeET?.text.toString().trim()) {

                "Breakfast" -> DisplayTV?.text = "Cereal" //Have screen for each time of day, as just displaying
                "breakfast" -> DisplayTV?.text = "Cereal"
                "BREAKFAST" -> DisplayTV?.text = "Cereal" //Maybe instead of displaying on this page, taken to the breakfast page
                "Morning" -> DisplayTV?.text = "Cereal"
                "morning" -> DisplayTV?.text = "Cereal"
                "MORNING" -> DisplayTV?.text = "Cereal"
                "Lunch" -> DisplayTV?.text = "Sandwich" //Have screen for each time of day, as just displaying
                "lunch" -> DisplayTV?.text = "Sandwich"
                "LUNCH" -> DisplayTV?.text = "Sandwich"
                "Afternoon" -> DisplayTV?.text = "Sandwich"
                "afternoon" -> DisplayTV?.text = "Sandwich"
                "AFTERNOON" -> DisplayTV?.text = "Sandwich"
                "Dinner" -> DisplayTV?.text = "Lasagna" //Have screen for each time of day, as just displaying
                "dinner" -> DisplayTV?.text = "Lasagna"
                "DINNER" -> DisplayTV?.text = "Lasagna"
                "Evening" -> DisplayTV?.text = "Lasagna"
                "evening" -> DisplayTV?.text = "Lasagna"
                "EVENING" -> DisplayTV?.text = "Lasagna"
                "Dessert" -> DisplayTV?.text = "Ice Cream" //Have screen for each time of day, as just displaying
                "dessert" -> DisplayTV?.text = "Ice Cream"
                "DESSERT" -> DisplayTV?.text = "Ice Cream"
                "Snack" -> DisplayTV?.text = "Pretzels" //Have screen for each time of day, as just displaying
                "snack" -> DisplayTV?.text = "Pretzels"
                "SNACK" -> DisplayTV?.text = "Pretzels"
                "Snacks" -> DisplayTV?.text = "Pretzels" //Have screen for each time of day, as just displaying
                "snacks" -> DisplayTV?.text = "Pretzels"
                "SNACKS" -> DisplayTV?.text = "Pretzels"
                "Supper" -> DisplayTV?.text = "Lasagna" //Have screen for each time of day, as just displaying
                "supper" -> DisplayTV?.text = "Lasagna"
                "SUPPER" -> DisplayTV?.text = "Lasagna"
                "Desert" -> DisplayTV?.text = "Click 'More Options'" //easter egg
                "desert" -> DisplayTV?.text = "Click 'More Options'"
                "DESERT" -> DisplayTV?.text = "Click 'More Options'"
                "Desserts" -> DisplayTV?.text = "Ice Cream"
                "desserts" -> DisplayTV?.text = "Ice Cream"
                "DESSERTS" -> DisplayTV?.text = "Ice Cream"

                else -> {
                    DisplayTV?.text = "Invalid"

                }

            }


        }
    }

    //Error, when typing "Dinner", "Burger" is still being displayed

    //Create private function that will call an output when specific instruction is entered





}