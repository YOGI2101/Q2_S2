package com.example.question2_set2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        var arr = ArrayList<Person>()
        var db = DBHelper(this)
        arr = db.getPersons()

        var ada = PersonAdapter(this,arr)
        myRecyclerOP.adapter = ada

    }
}