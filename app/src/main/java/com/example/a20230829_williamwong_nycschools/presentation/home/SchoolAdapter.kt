package com.example.a20230829_williamwong_nycschools.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a20230829_williamwong_nycschools.databinding.SchoolItemBinding
import com.example.a20230829_williamwong_nycschools.domain.school.model.School

/**
 * @author by William Wong on 08/29/2023
 */
class SchoolAdapter(private val onClick: ((schoolId: String) -> Unit)) : ListAdapter<School, SchoolAdapter.SchoolViewHolder>(DiffCallback()) {
    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val binding = SchoolItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SchoolViewHolder(binding)
    }
    inner class SchoolViewHolder(private val binding: SchoolItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val id = getItem(adapterPosition).id
                onClick(id)
            }
        }
        fun bind(school: School) {
            binding.name.text = school.schoolName
            binding.location.text = school.location
            binding.city.text = school.city
            binding.zipCode.text = school.zipCode
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<School>() {
    override fun areItemsTheSame(oldItem: School, newItem: School): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: School, newItem: School): Boolean {
        return oldItem == newItem
    }
}