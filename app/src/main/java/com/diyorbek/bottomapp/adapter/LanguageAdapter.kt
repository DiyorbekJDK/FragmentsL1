package com.diyorbek.bottomapp.adapter

import Languages
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.bottomapp.databinding.ItemLayoutBinding

class LanguageAdapter : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    lateinit var onClick: (Languages) -> Unit
    var languageList = mutableListOf<Languages>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(languageList[position])
    }

    override fun getItemCount(): Int {1
        return languageList.size
    }

    inner class LanguageViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(languages: Languages) {
            binding.imageView.setImageResource(languages.image)
            binding.textView.text = languages.name
            itemView.setOnClickListener {
                onClick(languages)
            }
        }
    }
}