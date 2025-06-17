package com.example.quickpacklist

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val names = intent.getStringArrayListExtra("names") ?: arrayListOf()
        val categories = intent.getStringArrayListExtra("categories") ?: arrayListOf()
        val quantities = intent.getStringArrayListExtra("quantities") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val listView = findViewById<ListView>(R.id.listView)
        val backBtn = findViewById<Button>(R.id.backBtn)
        val tableBtn = findViewById<Button>(R.id.tableBtn)

        val listItems = names.mapIndexed {
                i, name -> "$name (${quantities[i]}) - ${categories[i]}"
        }

        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)

        backBtn.setOnClickListener {
            finish()
        }

        tableBtn.setOnClickListener {
            val intent = Intent(this, TableActivity::class.java)
            intent.putStringArrayListExtra("names", names)
            intent.putStringArrayListExtra("categories", categories)
            intent.putStringArrayListExtra("quantities", quantities)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }
    }
}
