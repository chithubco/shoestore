package com.echithub.shoestore

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.echithub.shoestore.databinding.FragmentShoeListBinding
import com.echithub.shoestore.model.Shoe
import com.echithub.shoestore.ui.ShoeListAdapter
import com.echithub.shoestore.viewmodel.ShowViewModel

class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShowViewModel by activityViewModels()

    private val shoeListAdapter = ShoeListAdapter(arrayListOf())

//    private val shoeListDataObserver = Observer<List<Shoe>> {shoes ->
//        shoes?.let{
//            shoeListAdapter.updateShoeList(it)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoeListBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.shoes.observe(viewLifecycleOwner, Observer<List<Shoe>> { shoes ->
            shoes?.let{
                shoeListAdapter.updateShoeList(it)
            }
        })

        viewModel.isLoading.value.let{
            if (viewModel.isLoading.value == null || viewModel.isLoading.value == false){
                viewModel.refresh()
                viewModel.isLoading.value = true
                Log.i("IsLoadingValue",viewModel.isLoading.value.toString())
            }
        }



        binding.rvShowList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = shoeListAdapter
        }
        binding.btnAddShoe.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_createShoeFragment)
        }

        binding.slRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
            binding.slRefreshLayout.isRefreshing = false
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