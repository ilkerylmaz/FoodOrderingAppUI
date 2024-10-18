package com.example.foodorderingappui

import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup

class FoodItemSelection(
    val mainCourses: List<CheckBox>,
    val appetizers: RadioGroup,
    val drinks: RadioGroup
) {

    fun getSelectedMainCourses(): String {
        val selectedItems = StringBuilder()
        for (mainCourse in mainCourses) {
            if (mainCourse.isChecked) {
                selectedItems.append("${mainCourse.text}\n")
            }
        }
        return selectedItems.toString()
    }

    fun getSelectedAppetizer(): String {
        val selectedAppetizerId = appetizers.checkedRadioButtonId
        return if (selectedAppetizerId != -1) {
            val selectedAppetizer: RadioButton = appetizers.findViewById(selectedAppetizerId)
            "Aperatif: ${selectedAppetizer.text}\n"
        } else {
            ""
        }
    }

    fun getSelectedDrink(): String {
        val selectedDrinkId = drinks.checkedRadioButtonId
        return if (selectedDrinkId != -1) {
            val selectedDrink: RadioButton = drinks.findViewById(selectedDrinkId)
            "İçecek: ${selectedDrink.text}\n"
        } else {
            ""
        }
    }
}