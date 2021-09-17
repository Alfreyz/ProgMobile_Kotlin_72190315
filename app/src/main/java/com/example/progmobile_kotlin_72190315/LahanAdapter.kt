package com.example.progmobile_kotlin_72190315

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class LahanAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var lahans = arrayListOf<Lahan>()

    override fun getCount(): Int {
        return lahans.size
    }

    override fun getItem(position: Int): Any {
        return lahans[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_lahan, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val lahan = getItem(position) as Lahan
        viewHolder.bind(lahan)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvDescription: TextView = view.findViewById(R.id.tv_description)

        internal fun bind(lahan: Lahan) {
            tvName.text = lahan.name
            tvDescription.text = lahan.description
        }
    }
}