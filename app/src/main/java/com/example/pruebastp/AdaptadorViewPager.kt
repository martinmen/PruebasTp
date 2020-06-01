package com.example.pruebastp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.pruebastp.data.Pictures
import com.squareup.picasso.Picasso


class AdaptadorViewPager(val imageUrls: Array<String>, val context: Context) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        Picasso.get()
            .load(imageUrls[position])
            .fit()
            .centerCrop()
            .into(imageView)
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView((`object` as View?))
    }

    override fun getCount(): Int {
        return imageUrls.size
    }
}


/*   override fun instantiateItem(container: ViewGroup, position: Int): Any {
           val imageView = ImageView(context)
        Picasso.get()
            .load(imageUrls[position].secure_url)
            .fit()
            .centerCrop()
            .into(imageView)
        container.addView(imageView)
        return imageView
     }*/