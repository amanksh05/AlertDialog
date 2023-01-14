package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDialog1 = findViewById<Button>(R.id.btnDialog1)
        val btnDialog2 = findViewById<Button>(R.id.btnDialog2)
        val btnDialog3 = findViewById<Button>(R.id.btnDialog3)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr. poop to your contact list?")
            .setIcon(R.drawable.ic_add_contacts)
            .setPositiveButton("Yes" ) {_, _->
                Toast.makeText(this,"You added Mr. Poop to your contact List!",Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("No" ) {_, _->
                Toast.makeText(this,"You didn't added Mr. Poop to your contact List!",Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First Item", "Second Item","Third Item")

        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of this options")
            .setSingleChoiceItems(options,0){dialogInterface, i->
                Toast.makeText(this, "You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()

            }
            .setPositiveButton("Accept" ) {_, _->
                Toast.makeText(this,"You clicked on SingleChoiceDialog",Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("Decline" ) {_, _->
                Toast.makeText(this,"You declined the singleChoiceDialog",Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of this options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){_,i,isChecked->
                if(isChecked){
                    Toast.makeText(this,"You Checked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"You Unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }

            }
            .setPositiveButton("Accept" ) {_, _->
                Toast.makeText(this,"You clicked on MultiChoiceDialog",Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("Decline" ) {_, _->
                Toast.makeText(this,"You declined the MultiChoiceDialog",Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }

}
