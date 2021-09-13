package com.example.listfragment

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHandler(val context: Context) :
SQLiteOpenHelper(context,"addTask",null,1){

    companion object{
        val DB_NAME = "ItemDB"
        val DB_VERSION = 1
        val TABLE_NAME = "item"
        val ID = "id"
        val ITEM_NAME = "itemname"
        val DESCRIPTION = "description"
        val PRICE = 0
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY ," +
                "$ITEM_NAME TEXT ,"+
                "$DESCRIPTION TEXT ," +
                "$PRICE INTEGER )"

        db?.execSQL(CREATE_TABLE_QUERY)

    }

    fun inserTask(itemname: String,description:String,price:Int)

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}