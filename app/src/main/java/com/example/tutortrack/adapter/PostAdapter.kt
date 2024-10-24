package com.example.tutortrack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutortrack.data.Post
import com.example.tutortrack.databinding.ItemPostCommentBinding

class PostAdapter(private val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val binding: ItemPostCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.profileImage.setImageResource(post.profileImageResId)
            binding.profileName.text = post.userName
            binding.commentDate.text = post.date
            binding.commentText.text = post.comment

            binding.likeButton.setOnClickListener {
                // Handle like action
            }

            binding.shareButton.setOnClickListener {
                // Handle share action
            }

            binding.replyButton.setOnClickListener {
                // Handle reply action
            }

            binding.moreOptions.setOnClickListener {
                // Show more options
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
