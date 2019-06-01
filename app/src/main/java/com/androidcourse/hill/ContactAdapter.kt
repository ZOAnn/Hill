package com.androidcourse.hill

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ContactAdapter (private val context: Context,
                      private val dataSource: ArrayList<Contact>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    companion object {
        private val LABEL_COLORS = hashMapOf(
                "Low-Carb" to R.color.colorLowCarb,
                "Low-Fat" to R.color.colorLowFat,
                "Low-Sodium" to R.color.colorLowSodium,
                "Medium-Carb" to R.color.colorMediumCarb,
                "Vegetarian" to R.color.colorVegetarian,
                "Balanced" to R.color.colorBalanced
        )
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {

            view = inflater.inflate(R.layout.contact_item, parent, false)

            holder = ViewHolder()
            holder.iconImageView = view.findViewById(R.id.contact_image) as ImageView
            holder.nameTextView = view.findViewById(R.id.contact_name) as TextView
            holder.infoTextView = view.findViewById(R.id.contact_info) as TextView

            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6
        val thumbnailImageView = holder.iconImageView
        val titleTextView = holder.nameTextView
        val subtitleTextView = holder.infoTextView


        val contact = getItem(position) as Contact

        titleTextView.text = contact.name
        subtitleTextView.text = contact.info

        Picasso.with(context).load(contact.icon).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)
        return view
    }

    private class ViewHolder {
        lateinit var iconImageView: ImageView
        lateinit var nameTextView: TextView
        lateinit var infoTextView: TextView
    }
}