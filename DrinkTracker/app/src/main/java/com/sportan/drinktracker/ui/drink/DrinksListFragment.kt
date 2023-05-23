package com.sportan.drinktracker.ui.drink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sportan.drinktracker.R
import com.sportan.drinktracker.databinding.FragmentDrinksListBinding

class DrinksListFragment : Fragment() {

    private lateinit var binding: FragmentDrinksListBinding
    private val viewModel: DrinkViewModel by viewModels{
        DrinkViewModel.factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drinks_list, container, false)
        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_drinksListFragment_to_newDrinkFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DrinkAdapter{
            val bundle = Bundle().apply {
                putString("drinkName", it.name)
                putString("ingredients", it.ingredients)
            }
            findNavController().navigate(R.id.action_drinksListFragment_to_drinkFragment, bundle)
        }
        adapter.submitData(viewModel.getDrinks())

        binding.drinksRecyclerView.adapter = adapter

    }


}