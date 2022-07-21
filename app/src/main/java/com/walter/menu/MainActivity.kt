package com.walter.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.buttonContextMenu)

        button.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this, button)
            popupMenu.menuInflater.inflate(R.menu.pop_up_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.pop_menu_delete->Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show()
                    R.id.pop_menu_edit -> Toast.makeText(this, "Editing", Toast.LENGTH_SHORT).show()
                }
                true
            }

            popupMenu.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_item_share->{
                Toast.makeText(this, "Sharing", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}