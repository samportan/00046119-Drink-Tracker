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
import com.sportan.drinktracker.databinding.FragmentDrinkBinding
import com.sportan.drinktracker.databinding.FragmentDrinksListBinding

class DrinkFragment : Fragment() {

    private lateinit var binding: FragmentDrinkBinding
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink, container, false)

        val drinkName = arguments?.getString("drinkName")
        val ingredients = arguments?.getString("ingredients")

        binding.drinkNameTextView.text = drinkName
        binding.ingredientsTextView.text = ingredients


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

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressedCallback?.remove()
        onBackPressedCallback = null
    }

}