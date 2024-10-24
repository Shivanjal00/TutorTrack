package com.example.tutortrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tutortrack.adapter.LibraryAdapter
import com.example.tutortrack.data.Library
import com.example.tutortrack.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    private lateinit var libraryAdapter: LibraryAdapter
    private val libraryList = listOf(
        Library("Owner 1", "5 km", "$20", R.drawable.logo),
        Library("Owner 2", "3 km", "$25", R.drawable.logo),
        // Add more libraries as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewLibrary.layoutManager = GridLayoutManager(context, 2) // 2 columns
        libraryAdapter = LibraryAdapter(libraryList)
        binding.recyclerViewLibrary.adapter = libraryAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
