package com.example.week6_sec3_signupandsignin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper (context: Context) : SQLiteOpenHelper(context, "details1.db", null, 1) {
    var sqliteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table sign ( Myid integer primary key autoincrement , Name text , Location text , Mobile text , Password text)")
        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun save_DB(name: String, location: String, mobile: String, password: String) {
        var cv = ContentValues()
        cv.put("Name", name)
        cv.put("Location", location)
        cv.put("Mobile", mobile)
        cv.put("Password", password)

        sqliteDatabase.insert("sign", null, cv)
    }

    fun retrive(mobile: String): Users {

        var c: Cursor = sqliteDatabase.query("sign", null, "Mobile=?", arrayOf(mobile), null, null, null)

        c.moveToFirst()
        var id=c.getInt(c.getColumnIndex("Myid"))
        var name = c.getString(c.getColumnIndex("Name"))
        var loc = c.getString(c.getColumnIndex("Location"))
        var pas = c.getString(c.getColumnIndex("Password"))
        var mob = c.getString(c.getColumnIndex("Mobile"))

        var u=Users(id,name,loc,mob,pas )
        return u

    }
}