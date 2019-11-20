package com.plusinfosys.viewpager.horizontal

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity);

        val horizontal: Button = findViewById(R.id.horizontal)
        val vertical: Button = findViewById(R.id.vertical)

        val back : ImageView = findViewById(R.id.imageBack);
        val title : TextView = findViewById(R.id.title);
        back.visibility= View.GONE
        title.text= "Viewpager Demo"

        horizontal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("isFromHorizontal", true)
            startActivity(intent)
        }

        vertical.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("isFromHorizontal", false)
            startActivity(intent)
        }
    }
}
