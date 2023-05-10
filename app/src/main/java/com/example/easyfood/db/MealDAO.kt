package com.example.easyfood.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.easyfood.pojo.Meal

@Dao
interface MealDAO {

    // onConflict is used that if the user tries to add the same meal again in the db then it will update the db.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(meal : Meal)

    @Delete
    suspend fun delete(meal : Meal)

    @Query ("SELECT * FROM mealInformation")
    fun getAllMeals() : LiveData<List<Meal>>


}