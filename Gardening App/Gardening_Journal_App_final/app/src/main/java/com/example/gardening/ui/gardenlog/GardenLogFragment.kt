package com.example.gardening.ui.gardenlog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardening.databinding.FragmentGardenLogBinding
import com.example.gardening.databinding.PopupAddPlantBinding
import com.example.gardening.db.Plant
import com.example.gardening.ui.BaseFragment


class GardenLogFragment : BaseFragment() {
    private lateinit var viewModel: GardenLogViewModel
    private lateinit var binding: FragmentGardenLogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGardenLogBinding.inflate(inflater, container, false)
        binding.addPlantBtn.setOnClickListener {
            addPlant(inflater, container)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GardenLogViewModel::class.java)
        binding.plantRecyclerView.setHasFixedSize(true)
        binding.plantRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allPlants.observe(viewLifecycleOwner,Observer { plantData ->
            if(plantData != null) {
                binding.plantRecyclerView.adapter = GardenLogAdapter(plantData)
            }

        })
    }

    fun addPlant(inflater: LayoutInflater, container: ViewGroup?){
        val popupView = PopupAddPlantBinding.inflate(inflater, container, false)
        val popupWindow = PopupWindow(popupView.root, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true)

        popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        popupView.addBtn.setOnClickListener {
            val name = popupView.name.text.toString()
            val type = popupView.type.text.toString()
            val wateringFrequency = 2
            val plantingDate = popupView.plantingDate.text.toString()

            if(name.isEmpty()){
                popupView.name.error = "Name Required"
                popupView.name.requestFocus()
                return@setOnClickListener
            }
            val tPlant = Plant(name, type, wateringFrequency, plantingDate)
            viewModel.insert(tPlant)
            Toast.makeText(context, "Add successfully", Toast.LENGTH_LONG).show()
            popupWindow.dismiss()
        }

        popupView.cancelBtn.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView.root, Gravity.CENTER, 0, 0)
    }
}