package com.example.quickpacklist

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val names = ArrayList<String>()
    private val categories = ArrayList<String>()
    private val quantities = ArrayList<String>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val categoryInput = findViewById<EditText>(R.id.categoryInput)
        val quantityInput = findViewById<EditText>(R.id.quantityInput)
        val commentInput = findViewById<EditText>(R.id.commentInput)

        val addButton = findViewById<Button>(R.id.addButton)
        val viewListButton = findViewById<Button>(R.id.viewListButton)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val category = categoryInput.text.toString()
            val quantity = quantityInput.text.toString()
            val comment = commentInput.text.toString()

            if (name.isBlank() || category.isBlank() || quantity.isBlank()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (quantity.toIntOrNull() == null) {
                Toast.makeText(this, "Quantity must be a number!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            names.add(name)
            categories.add(category)
            quantities.add(quantity)
            comments.add(comment)

            nameInput.text.clear()
            categoryInput.text.clear()
            quantityInput.text.clear()
            commentInput.text.clear()

            Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show()
        }

        viewListButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putStringArrayListExtra("names", names)
            intent.putStringArrayListExtra("categories", categories)
            intent.putStringArrayListExtra("quantities", quantities)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }
    }
}
