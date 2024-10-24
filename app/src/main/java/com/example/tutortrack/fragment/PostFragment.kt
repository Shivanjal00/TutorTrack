package com.example.tutortrack.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tutortrack.R
import com.example.tutortrack.adapter.PostAdapter
import com.example.tutortrack.data.Post

class PostFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    private val postList = listOf(
        Post(R.drawable.logo, "Alice", "2024-10-24", "This is a comment from Alice."),
        Post(R.drawable.logo, "Bob", "2024-10-24", "This is a comment from Bob."),
        // Add more posts as needed
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        postAdapter = PostAdapter(postList)
        recyclerView.adapter = postAdapter

        return view
    }
}
