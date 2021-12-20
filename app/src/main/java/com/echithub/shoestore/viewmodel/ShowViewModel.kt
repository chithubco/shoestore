package com.echithub.shoestore.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.echithub.shoestore.model.Shoe

class ShowViewModel: ViewModel() {

    val shoes by lazy { MutableLiveData<MutableList<Shoe>>() }
    val isLoading by lazy { MutableLiveData<Boolean>() }

    private var shoeList = mutableListOf<Shoe>()

    init {
        Log.i("ShoeViewModel","ShoeViewModel Initialized")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShowViewModel","Show View Model Destroyed")
    }

    fun refresh(){
        if (isLoading?.value == null || isLoading?.value == false){
            getShoes()
            Log.i("Refresh False Function",shoes.value.toString())
        }

    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        isLoading.value == true
        Log.i("Add Function",shoes.value.toString())
    }

    private fun getShoes(){
        val shoe1 = Shoe(
            "Big Kid's Jordan 1 Mid SE Turf Orange",
            "1",
            500,
            12,
            "Green",
            12,
            "@drawable/Shoe1",
            "Nike"
        );
        val shoe2 = Shoe(
            "AndOne Sneakers",
            "2",
            50,
            15,
            "Blue",
            12,
            "@drawable/Shoe2",
            "Nike"
        );
        val shoe3 = Shoe(
            "adidas Women's Cloudfoam Pure Running Shoe",
            "3",
            500,
            12,
            "Green",
            12,
            "@drawable/Shoe3",
            "Adidas"
        );
        val shoe4 = Shoe(
            "Venzo Bicycle Men's Road Cycling Riding Shoes - 3 Straps- Compatible with Peloton Shimano SPD & Look ARC Delta - Perfect for Road Racing",
            "4",
            500,
            12,
            "Green",
            12,
            "@drawable/Shoe4",
            "Nike"
        );
        val shoe5 = Shoe(
            "Under Armour Men's Charged Assert 9 Running Shoe",
            "5",
            500,
            9,
            "Green",
            12,
            "@drawable/Shoe5",
            "Armour"
        );

        shoeList.add(shoe1)
        shoeList.add(shoe2)
        shoeList.add(shoe3)
        shoeList.add(shoe4)
        shoeList.add(shoe5)
        shoes.value = shoeList

        isLoading.value = false
    }
}