package com.example.foodorderingappui

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Ana Yemekleri tanımı
        val checkbox1 = findViewById<CheckBox>(R.id.main_1)
        val checkbox2 = findViewById<CheckBox>(R.id.main_2)
        val checkbox3 = findViewById<CheckBox>(R.id.main_3)
        //Aperatiflerin tanımı
        val groupAppetizer = findViewById<RadioGroup>(R.id.aperatifler)

        //içeceklerin tanımı
        val groupDrinks = findViewById<RadioGroup>(R.id.icecekler)
        val orderButton = findViewById<ImageButton>(R.id.orderButton)
        val foodSelection = FoodItemSelection(
            mainCourses = listOf(checkbox1, checkbox2, checkbox3),
            appetizers = groupAppetizer,
            drinks = groupDrinks
        )
        orderButton.setOnClickListener {
            val selectedItems = StringBuilder()
            selectedItems.append(foodSelection.getSelectedMainCourses())
            selectedItems.append(foodSelection.getSelectedAppetizer())
            selectedItems.append(foodSelection.getSelectedDrink())
            if (selectedItems.isEmpty()) {
                Toast.makeText(this, "Lütfen en az bir ürün seçin.", Toast.LENGTH_LONG).show()
            } else {
                // Siparişi tamamladıktan sonra seçilen ürünleri Toast ile göster
                Toast.makeText(this, "Siparişiniz alınmıştır en kısa sürede servis edilecektir. Afiyet olsun.", Toast.LENGTH_LONG).show()
            }
        }
    }
}