package com.example.tutortrack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutortrack.databinding.ItemCoachingBinding

class CoachingAdapter(private val coachingList: List<Coach>) :
    RecyclerView.Adapter<CoachingAdapter.CoachingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoachingViewHolder {
        val binding = ItemCoachingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoachingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoachingViewHolder, position: Int) {
        val coach = coachingList[position]
        holder.bind(coach)
    }

    override fun getItemCount(): Int = coachingList.size

    inner class CoachingViewHolder(private val binding: ItemCoachingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coach: Coach) {
            binding.coachImage.setImageResource(coach.imageResId)
            binding.coachName.text = coach.name
            binding.coachExperience.text = coach.experience
            binding.coachPrice.text = coach.price
        }
    }
}
