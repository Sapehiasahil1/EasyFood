package com.example.easyfood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.databinding.MealItemBinding
import com.example.easyfood.pojo.MealList
import com.example.easyfood.pojo.MealsByCategory
import com.example.easyfood.viewModel.CategoryMealsViewModel

class CategoriesMealAdapter : RecyclerView.Adapter<CategoriesMealAdapter.CategoriesMealsViewModel>() {

    private var mealsList = ArrayList<MealsByCategory>()

    fun setMealsList(mealsList: List<MealsByCategory>){
        this.mealsList = mealsList as ArrayList<MealsByCategory>
        notifyDataSetChanged()

    }

    inner class CategoriesMealsViewModel(val binding : MealItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesMealsViewModel {
        return CategoriesMealsViewModel(
            MealItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: CategoriesMealsViewModel, position: Int) {
        Glide.with(holder.itemView).load(mealsList[position].strMealThumb).into(holder.binding.imgMeal)
        holder.binding.tvMealName.text = mealsList[position].strMeal
    }
}