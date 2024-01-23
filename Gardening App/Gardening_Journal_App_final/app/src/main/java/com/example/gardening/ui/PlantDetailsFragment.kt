package com.example.gardening.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gardening.databinding.FragmentPlantDetailsBinding
import com.example.gardening.db.Plant
import com.example.gardening.ui.plaindetails.PlainDetailsViewModel

class PlantDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPlantDetailsBinding
    private lateinit var viewModel: PlainDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentPlantDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val plantId = com.example.gardening.ui.PlantDetailsFragmentArgs.fromBundle(it).plantId
            viewModel = ViewModelProvider(this).get(PlainDetailsViewModel::class.java)
            viewModel.getPlantById(plantId)
            viewModel.plantLiveData.observe(viewLifecycleOwner, Observer {plant ->
                displayPlantDetails(plant)
            })

        }
    }

    private fun displayPlantDetails(plant: Plant) {
        binding.name.text = plant.name
        binding.type.text = "Type: ${plant.type}"
        binding.wateringFrequency.text = "Watering Frequency: ${plant.wateringFrequency} days"
        binding.plantingDate.text = "Planting Date: ${plant.plantingDate.toString()}"
    }
}