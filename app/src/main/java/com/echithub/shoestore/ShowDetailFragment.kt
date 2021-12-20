package com.echithub.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.echithub.shoestore.databinding.FragmentShowDetailBinding
import com.echithub.shoestore.model.Shoe


class ShowDetailFragment : Fragment() {

    var shoe: Shoe? = null

    private var _binding: FragmentShowDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowDetailBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            shoe = ShowDetailFragmentArgs.fromBundle(it).shoe
        }
        binding.tvShoeNameShoeDetailFr.text = shoe?.name
        binding.tvCompanyShoeDetailFr.text = shoe?.company
        binding.tvSizeShoeDetailFr.text = shoe?.size.toString()

        when(shoe?.code?.toInt()){
            1 -> binding.ivShowImageShoeDetailFr.setImageResource(R.drawable.shoe1)
            2 -> binding.ivShowImageShoeDetailFr.setImageResource(R.drawable.shoe2)
            3 -> binding.ivShowImageShoeDetailFr.setImageResource(R.drawable.shoe3)
            4 -> binding.ivShowImageShoeDetailFr.setImageResource(R.drawable.shoe4)
            5 -> binding.ivShowImageShoeDetailFr.setImageResource(R.drawable.shoe5)
            else -> {
                binding.ivShowImageShoeDetailFr.setImageResource(R.drawable.shoe_main)
            }
        }

        binding.btNavigateBackToShoeList.setOnClickListener{
            findNavController().navigate(R.id.action_showDetailFragment_to_shoeListFragment)
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