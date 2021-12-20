package com.echithub.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.echithub.shoestore.databinding.FragmentCreateShoeBinding
import com.echithub.shoestore.model.Shoe
import com.echithub.shoestore.viewmodel.ShowViewModel

class CreateShoeFragment : Fragment() {

    private var _binding: FragmentCreateShoeBinding? = null
    private val binding get() = _binding!!

    private val model: ShowViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreateShoeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.shoes.observe(viewLifecycleOwner,Observer<List<Shoe>> { shoes ->
            // Update the UI
            Log.i("CreateShoeFragment","Observing shoes")
        })

        Log.i("CreateShoeFragment",model.shoes.value.toString())
        binding.btnAddCreateShoe.setOnClickListener {
            val shoeName = binding.etShoeName.text
            val ShoeCode = binding.etShoeCode.text
            val ShoePrice = binding.etShoePrice.text
            val shoeSize = binding.etShoeSize.text
            val ShoeColour = binding.etShoeColour.text
            val ShoeQuantity = binding.etShoeQuantity.text

            val shoe = Shoe(
                shoeName.toString(),
                ShoeCode.toString(),
                ShoePrice.toString().toInt(),
                ShoeQuantity.toString().toInt(),
                ShoeColour.toString(),
                shoeSize.toString().toInt(),
                "",
                "Nike"
            )

            model.addShoe(shoe)
            findNavController().navigate(R.id.action_createShoeFragment_to_shoeListFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}