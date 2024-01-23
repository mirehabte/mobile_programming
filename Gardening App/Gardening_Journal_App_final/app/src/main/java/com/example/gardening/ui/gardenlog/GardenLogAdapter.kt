package com.example.gardening.ui.gardenlog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.gardening.databinding.PlantItemBinding
import com.example.gardening.db.Plant

class GardenLogAdapter (private var plants: List<Plant>): RecyclerView.Adapter<GardenLogAdapter.GardenLogViewHolder>(){

    class GardenLogViewHolder(var binding: PlantItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.name.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenLogViewHolder {
        val binding = PlantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GardenLogViewHolder(binding)
    }

    override fun getItemCount() = plants.count()

    override fun onBindViewHolder(holder: GardenLogViewHolder, position: Int) {
        val plant = plants[position]
        holder.bind(plant.name)

        holder.binding.root.setOnClickListener{
            val action = GardenLogFragmentDirections.actionViewDetails(plant.id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}