package com.example.tutortrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tutortrack.databinding.FragmentCoachingBinding

class CoachingFragment : Fragment() {

    private var _binding: FragmentCoachingBinding? = null
    private val binding get() = _binding!!

    private lateinit var coachingAdapter: CoachingAdapter
    private val coachingList = listOf(
        Coach("Coach 1", "5 years", "$30", R.drawable.logo),
        Coach("Coach 2", "3 years", "$25", R.drawable.logo),
        // Add more coaches as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoachingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewCoaching.layoutManager = GridLayoutManager(context, 2) // 2 columns
        coachingAdapter = CoachingAdapter(coachingList)
        binding.recyclerViewCoaching.adapter = coachingAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
