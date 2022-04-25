package com.example.question2_set2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VER)
{
    companion object{
        private val DB_NAME = "PersonDB"
        private val TB_NAME = "Person"
        private val DB_VER = 1

        private val F1_PERSON = "p_id"
        private val F2_PERSON = "p_name"
        private val F3_PERSON = "p_height"
        private val F4_PERSON = "p_weight"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE $TB_NAME ($F1_PERSON INTEGER PRIMARY KEY AUTOINCREMENT, $F2_PERSON TEXT, $F3_PERSON DOUBLE, $F4_PERSON DOUBLE)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertPerson(per:Person) : Long
    {
        var db =writableDatabase
        var cv = ContentValues()
        cv.put(F2_PERSON,per.p_name)
        cv.put(F3_PERSON,per.p_height)
        cv.put(F4_PERSON,per.p_weight)

        var res= db.insert(TB_NAME,null,cv)
        return res
        db.close()
    }
    fun getPersons() : ArrayList<Person>
    {
        var db = readableDatabase
        var arr = ArrayList<Person>()
        var cursor = db.query(TB_NAME,null,null,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var height = cursor.getDouble(2)
            var weight = cursor.getDouble(3)

            var per = Person(id,name,height,weight)

            arr.add(per)
        }
        return arr
    }
}