package com.echithub.shoestore.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.echithub.shoestore.R
import com.echithub.shoestore.ShoeListFragmentDirections
import com.echithub.shoestore.model.Shoe

class ShoeListAdapter(private val shoeList: ArrayList<Shoe>): RecyclerView.Adapter<ShoeListAdapter.ShoeViewHolder>() {

    class ShoeViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_shoe,parent,false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        var tvShoeName = holder.view.findViewById<TextView>(R.id.tvShoeNameListView)
        tvShoeName.text = shoeList[position].name

        var imageView = holder.view.findViewById<ImageView>(R.id.ivShoeImageListView)
        when(position){
            1 -> imageView.setImageResource(R.drawable.shoe1)
            2 -> imageView.setImageResource(R.drawable.shoe2)
            3 -> imageView.setImageResource(R.drawable.shoe3)
            4 -> imageView.setImageResource(R.drawable.shoe4)
            5 -> imageView.setImageResource(R.drawable.shoe5)
            else -> {
                imageView.setImageResource(R.drawable.shoe_main)
            }
        }
        var layout = holder.view.findViewById<ConstraintLayout>(R.id.itemShoeLayout)

        /*
        Take us to our detailed fragment
         */
        layout.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShowDetailFragment(shoeList[position])
            Navigation.findNavController(holder.view).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }

    fun updateShoeList(newShoeList:List<Shoe>){
        shoeList.clear()
        shoeList.addAll(newShoeList)
        notifyDataSetChanged()
    }
}