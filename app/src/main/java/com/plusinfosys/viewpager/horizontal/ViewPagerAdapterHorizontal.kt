package com.plusinfosys.viewpager.horizontal

import android.content.Context
import android.support.annotation.NonNull
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.util.*

class ViewPagerAdapterHorizontal : PagerAdapter {
    var context: Context? = null
    private var layoutInflater: LayoutInflater? = null
    //private Integer [] images={R.drawable.one,R.drawable.four,R.drawable.three,R.drawable.four};
    var list_data: ArrayList<ListData>? = null


    constructor(context: Context, list_data: ArrayList<ListData>)  {
        this.context = context
        this.list_data = list_data
    }

    override fun getCount(): Int {
        return list_data!!.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.myfragment, null)
        val img = view.findViewById<ImageView>(R.id.img_view)
        Picasso.with(context).load(this.list_data!![position].imageurl).into(img)

        val viewPager = container as ViewPager
        viewPager.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)

    }
}
