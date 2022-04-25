package com.example.question2_set2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsert.setOnClickListener {
            if(edtPName.text.toString().equals("") || edtPHeight.text.toString().equals("")||edtPWeight.text.toString().equals(""))
            {
                Toast.makeText(this,"Enter Data Accurately",Toast.LENGTH_SHORT).show()
            }
            else{
                var per =Person(edtPName.text.toString(),edtPHeight.text.toString().toDouble(),edtPWeight.text.toString().toDouble())

                var db = DBHelper(this)
                var res = db.insertPerson(per)
               if(res>0)
               {
                   Toast.makeText(this,"Values Inserted Successfully",Toast.LENGTH_LONG).show()
                   edtPName.setText("")
                   edtPHeight.setText("")
                   edtPWeight.setText("")
               }
                else
               {
                   Toast.makeText(this,"Facing Some Issues",Toast.LENGTH_LONG).show()
               }
            }
        }
        btnViewAll.setOnClickListener {
            var intent = Intent(this,ViewAllActivity::class.java)
            startActivity(intent)
        }
    }
}