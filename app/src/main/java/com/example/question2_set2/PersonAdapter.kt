package com.example.question2_set2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerstruct.view.*

class PersonAdapter (val context: Context, var arr:ArrayList<Person>)
    : RecyclerView.Adapter<PersonAdapter.ViewHolder>()

{
    class ViewHolder(var view: View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Person)
        {
            view.txtid.setText(p.p_id.toString())
            view.txtPName.setText(p.p_name)
            view.txtPHeight.setText(p.p_height.toString())
            view.txtPWeight.setText(p.p_weight.toString())

            if(p.p_weight>90.0)
            {
                view.txtgreet.setText("You Are Overweight")
            }
            else
            {
                view.txtgreet.setText("You Are Fit")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater= LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.recyclerstruct,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arr[position])
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}