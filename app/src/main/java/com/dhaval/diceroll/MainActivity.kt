package com.dhaval.diceroll

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    // define spiner
    private val spinner: Spinner? = null
    // define sharedpreferences
    private lateinit var sharedprefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.DiceSide)
        sharedprefs = PreferenceManager.getDefaultSharedPreferences(this)
        Log.i("SaveDataValue", sharedprefs.getBoolean("prefs_save_values", false).toString())
        Log.i("Total value", sharedprefs.getString("prefs_total", getString(R.string.all_side)).toString()
        )
// define list of spinner item
        val from = arrayOf("4", "6", "8", "10", "12")
        // diceside (spinner) is ArrayAdapter and its Integer
        val Diceside: ArrayAdapter<*> = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = Diceside
        val to = arrayOf("4", "6", "8", "10", "12",)


        spinner.adapter = Diceside
        // set click button for dice rolling
        roll_button!!.setOnClickListener {
            val tot: Double

            val Diceside: Double = spinner.getSelectedItem().toString().toDouble()

// if spinner select 4 take a random number between one to four
            if (spinner.selectedItem.toString() == "4") {
                var randomNo = (1..4).random()
                var imageDice: Int
                when (randomNo) {
                    // when random number 1 its show one pictuer and thats get on drawable
                    // and same method for all spinner option
                    1 -> {
                        imageDice = R.drawable.dice_1
                    }
                    2 -> {
                        imageDice = R.drawable.dice_2
                    }
                    3 -> {
                        imageDice = R.drawable.dice_3
                    }
                    else -> {
                        imageDice = R.drawable.dice_4
                    }
                }
                // set resources for image
                Dice_image.setImageResource(imageDice)
            }
            if (spinner.selectedItem.toString() == "6") {
                var randomNo = (1..6).random()
                var imageDice: Int
                when (randomNo) {
                    1 -> {
                        imageDice = R.drawable.dice_1
                    }
                    2 -> {
                        imageDice = R.drawable.dice_2
                    }
                    3 -> {
                        imageDice = R.drawable.dice_3
                    }
                    4 -> {
                        imageDice = R.drawable.dice_4
                    }
                    5 -> {
                        imageDice = R.drawable.dice_5
                    }
                    else -> {
                        imageDice = R.drawable.dice_6
                    }
                }
                Dice_image.setImageResource(imageDice)
            }

            if (spinner.selectedItem.toString() == "8") {
                var randomNo = (1..8).random()
                var imageDice: Int
                when (randomNo) {
                    1 -> {
                        imageDice = R.drawable.dice_1
                    }
                    2 -> {
                        imageDice = R.drawable.dice_2
                    }
                    3 -> {
                        imageDice = R.drawable.dice_3
                    }
                    4 -> {
                        imageDice = R.drawable.dice_4
                    }
                    5 -> {
                        imageDice = R.drawable.dice_5
                    }
                    6 -> {
                        imageDice = R.drawable.dice_6
                    }
                    7 -> {
                        imageDice = R.drawable.dice_7
                    }
                    else -> {
                        imageDice = R.drawable.dice_8
                    }
                }
                Dice_image.setImageResource(imageDice)
            }
            if (spinner.selectedItem.toString() == "10") {
                var randomNo = (0..9).random()
                var imageDice: Int
                when (randomNo) {
                    1 -> {
                        imageDice = R.drawable.dice_1
                    }
                    2 -> {
                        imageDice = R.drawable.dice_2
                    }
                    3 -> {
                        imageDice = R.drawable.dice_3
                    }
                    4 -> {
                        imageDice = R.drawable.dice_4
                    }
                    5 -> {
                        imageDice = R.drawable.dice_5
                    }
                    6 -> {
                        imageDice = R.drawable.dice_6
                    }
                    7 -> {
                        imageDice = R.drawable.dice_7
                    }
                    8 -> {
                        imageDice = R.drawable.dice_8
                    }
                    9 -> {
                        imageDice = R.drawable.dice_9
                    }
                    else -> {
                        imageDice = R.drawable.dice_0
                    }
                }
                Dice_image.setImageResource(imageDice)
            }
           if (spinner.selectedItem.toString() == "12") {
               var randomNo = (1..12).random()
               var imageDice: Int
               when (randomNo) {
                   1 -> {
                       imageDice = R.drawable.dice_1
                   }
                   2 -> {
                       imageDice = R.drawable.dice_2
                   }
                   3 -> {
                       imageDice = R.drawable.dice_3
                   }
                   4 -> {
                       imageDice = R.drawable.dice_4
                   }
                   5 -> {
                       imageDice = R.drawable.dice_5
                   }
                   6 -> {
                       imageDice = R.drawable.dice_6
                   }
                   7 -> {
                       imageDice = R.drawable.dice_7
                   }
                   8 -> {
                       imageDice = R.drawable.dice_8
                   }
                   9 -> {
                       imageDice = R.drawable.dice_9
                   }
                   10 -> {
                       imageDice = R.drawable.dice_10
                   }
                   11 -> {
                       imageDice = R.drawable.dice_11
                   }
                   else -> {
                       imageDice = R.drawable.dice_12
                   }
               }
               Dice_image.setImageResource(imageDice)
           }
// when click on button its show dice is rolled
            Toast.makeText(this, "Dice is Rolled", Toast.LENGTH_SHORT).show()
        }

// define spinner resources
        val adapter =
            ArrayAdapter.createFromResource(
                this,
                R.array.diceside,
                android.R.layout.simple_spinner_dropdown_item
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }



    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        val choice = adapterView.getItemAtPosition(i).toString()
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show()
    }


    override fun onNothingSelected(adapterView: AdapterView<*>?) {}
// define menu set on create option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // when press on setting icon its show onotherlayout
            R.id.Setting -> {
                startActivity(Intent(this, SettingsActivity::class.java))
            }

            else -> return super.onOptionsItemSelected(item)

        }
        return true
    }
}



