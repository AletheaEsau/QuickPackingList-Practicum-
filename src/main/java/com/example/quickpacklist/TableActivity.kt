package com.example.quickpacklist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val names = intent.getStringArrayListExtra("names") ?: arrayListOf()
        val categories = intent.getStringArrayListExtra("categories") ?: arrayListOf()
        val quantities = intent.getStringArrayListExtra("quantities") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val backBtn = findViewById<Button>(R.id.backBtnTable)

        val headerRow = TableRow(this)
        listOf("Name", "Category", "Qty", "Comments").forEach {
            val textView = TextView(this)
            textView.text = it
            textView.setPadding(10, 10, 10, 10)
            headerRow.addView(textView)
        }
        tableLayout.addView(headerRow)

        for (i in names.indices) {
            val row = TableRow(this)
            listOf(names[i], categories[i], quantities[i], comments[i]).forEach {
                val cell = TextView(this)
                cell.text = it
                cell.setPadding(10, 10, 10, 10)
                row.addView(cell)
            }
            tableLayout.addView(row)
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}
