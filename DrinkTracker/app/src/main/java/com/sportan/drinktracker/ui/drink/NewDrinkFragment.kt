package com.sportan.drinktracker.ui.drink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sportan.drinktracker.R
import com.sportan.drinktracker.data.model.DrinkModel
import com.sportan.drinktracker.databinding.FragmentDrinksListBinding
import com.sportan.drinktracker.databinding.FragmentNewDrinkBinding

class NewDrinkFragment : Fragment() {

    private lateinit var binding: FragmentNewDrinkBinding
    private val viewModel: DrinkViewModel by viewModels{
        DrinkViewModel.factory
    }

    private var onBackPressedCallback: OnBackPressedCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_drink, container, false)
        binding.actionSave.setOnClickListener {
            var drinkName = binding.nameTextText.text.toString()
            var ingredients = binding.ingEditText.text.toString()
            viewModel.addDrinks(DrinkModel(drinkName, ingredients))
            it.findNavController().navigateUp()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            onBackPressedCallback as OnBackPressedCallback
        )
    }

}