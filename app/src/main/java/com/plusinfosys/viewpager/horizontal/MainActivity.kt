package com.plusinfosys.viewpager.horizontal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var datalist: ArrayList<ListData> = ArrayList()
    var isFromHorizontal: Boolean = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isFromHorizontal = intent.getBooleanExtra("isFromHorizontal", false)

        val back: ImageView = findViewById(R.id.imageBack);
        val title: TextView = findViewById(R.id.title);
        back.visibility = View.VISIBLE
        if (isFromHorizontal)
            title.text = "Horizontal ViewPager"
        else
            title.text = "Vertical ViewPager"

        back.setOnClickListener{
            finish()
        }

        val data = ListData(1, "https://i.pinimg.com/736x/59/1a/59/591a59b19a84d06738241713ecfdcbb2.jpg", "First Page")
        datalist.add(data)

        val data1 = ListData(
            2,
            "https://3.bp.blogspot.com/-CreoWkuyjEo/XGso01hQa8I/AAAAAAAACns/THRjmWV1GKASC_qLnbeeY1nJ8BEbIn-4gCKgBGAs/w720-h1280-c/landscape-nature-forest-scenery-moon-4K-154.jpg",
            "Second Page"
        )
        datalist.add(data1)

        val data2 = ListData(
            3,
            "https://www.setaswall.com/wp-content/uploads/2017/10/Colorful-Sky-Wallpaper-720x1280-380x676.jpg",
            "Third Page"
        )
        datalist.add(data2)

        val data3 =
            ListData(4, "https://i.pinimg.com/736x/a9/36/34/a9363414866c68bd0c7c31246b596929.jpg", "Fourth Page")
        datalist.add(data3)

        val viewPagerHorizontal = findViewById(R.id.horizontalViewPager) as MyHorizontalViewPager
        val viewPagerVertical = findViewById(R.id.verticalViewPager) as MyVerticalViewPager

        val adapter = ViewPagerAdapterHorizontal(this@MainActivity, datalist)
        if (isFromHorizontal) {
            viewPagerHorizontal.visibility = View.VISIBLE
            viewPagerVertical.visibility = View.GONE
            viewPagerHorizontal.adapter = adapter
        } else {
            viewPagerHorizontal.visibility = View.GONE
            viewPagerVertical.visibility = View.VISIBLE
            viewPagerVertical.adapter = adapter
        }

    }
}
