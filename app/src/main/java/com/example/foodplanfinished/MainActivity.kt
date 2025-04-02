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

    /*
    References

    Muffins Image: 		Sweet & Savory, Chocolate Orange Muffins [image online]. Available at: <https://za.pinterest.com/pin/1055599907854554/>[Accessed 26th March 2025].
    Mousse Image: 		Platos y Placeres, [image online]. Available at: <https://za.pinterest.com/pin/755478906279326981/>[Accessed 26th March 2025].
    Milktart Image: 	Life in the South, [image online]. Available at: <https://za.pinterest.com/pin/56083957852516493/>[Accessed 26th March 2025].
    Background Image: 	rawpixel, Download premium psd / image of Gold frame on fresh homemade food. [image online]. Available at: <https://za.pinterest.com/pin/911486412112811359/>[Accessed 1st April 2025]
    Burger Image:		Grandma's Kitchen | Easy & Delicious Family Recipes, Crack Burgers [image online]. Available at: <https://za.pinterest.com/pin/28217935160938262/>[Accessed 26th March 2025]
    Brownie Image:		Good For Recipes, Chocolate Covered Strawberry Brownies [image online]. Available at: <https://za.pinterest.com/pin/18366310975612652/>[Accessed 26th March 2025]
    Cakes Image:		tietheknot.at, Hochzeitstorte war gestern: 10 tolle Alternativen zur Hochzeitstorte [image online]. Available at: <https://za.pinterest.com/pin/639018634665406095/>[Accessed 26th March 2025]
    Chicken Image:		EatRecipo with Jessica, Garlic Herb Roast Chicken [image online]. Available at: <https://za.pinterest.com/pin/886998089113319806/>[Accessed 26th March 2025]
    Chips Image:		Eat This, Not That!, Healthy Smoked Paprika Potato Chips [image online]. Available at: <https://za.pinterest.com/pin/802977808608739135/>[Accessed 26th March 2025]
    Chocolate Image:	Chandrani Ghosh, Chocolate [image online]. Available at: <https://za.pinterest.com/pin/127437864450955470/>[Accessed 26th March 2025]
    Desert One Image:	Sareni, [image online]. Available at: <https://za.pinterest.com/pin/464081936622694791/>[Accessed 26th March 2025]
    Desert Two Image:	Crissy, [image online]. Available at: <https://za.pinterest.com/pin/7388786881674810/>[Accessed 26th March 2025]
    Desert Three Image:	RapidLeaks, How Did The Sand Get Into The Sahara Desert? [online image]. Available at: <https://za.pinterest.com/pin/28358672650164504/>[Accessed at 26th March 2025]
    Desert Four Image:	Freepik, Premium Photo | Dunes in the Sahara desert in the heart of Africa [image online]. Available at: <https://za.pinterest.com/pin/284500901454092564/>[Accessed 26th March 2025]
    Fruit Image:		Platos y Placeres, [image online]. Available at: <https://za.pinterest.com/pin/56717276552179134/>[Accessed 26th March 2025]
    Stir Fry Image:		pailina, [image online]. Available at: <https://za.pinterest.com/pin/112871534412211371/>[Accessed 26th March 2025]
    Waffle Image:		Recipes Vibrant | Quick & Easy Homemade Recipes, Homemade Waffles Recipe [image online]. Available at: <https://za.pinterest.com/pin/83879611805614120/>[Accessed 26th March 2025]
    Toast Image:		Jessica Gavin, Avocado Toast(6 Ways!) [image online]. Available at: <https://za.pinterest.com/pin/408701734952076783/>[Accessed 26th March 2025]
    Steak Image:		Recipes Time | Food Recipes & Cooking, Grilled Steak with Chimichurri Sauce and Roasted Potatoes [image online]. Available at: <https://za.pinterest.com/pin/12173861488560738/>[Accessed 26th March 2025]
    Smoothie Image:		Quick& Easy Recipe, [image online]. Available at: <https://za.pinterest.com/pin/328551735336539182/>[Accessed 26th March 2025]
    Salmon Image:		goorecipes, [image online]. Available at: <https://za.pinterest.com/pin/25684660371229100/>[Accessed 26th March 2025]
    Popcorn Image: 		Pequerecetas - Recetas para ninos, Como hacer palomitas de maiz caseras [online image]. Available at: <https://za.pinterest.com/pin/13370130138395822/>[Accessed 26th March 2025]
    Pizza Image:		Nishu Shanzida, [image online]. Available at: <https://za.pinterest.com/pin/136656169940668720/>[Accessed 26th March 2025]
    Pie Image:		I've Been Cooking, Cornish Pocket from United Kingdom [image online]. Available at: <https://za.pinterest.com/pin/401735229279065602/>[Accessed 26th March 2025]
    Pasta Image: 		RecipeTin Eats, Chicken Pasta recipe of your dreams [image online]. Available at: <https://za.pinterest.com/pin/307300374574041990/>[Accessed 26th March 2025]
    */



}