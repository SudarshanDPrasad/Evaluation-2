package com.example.listfragment

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataBaseHandler(val context: Context) :
    SQLiteOpenHelper(context, "addTask", null, 1) {

    companion object {
        val DB_NAME = "ItemDB"
        val DB_VERSION = 1
        val TABLE_NAME = "item"
        val ID = "id"
        val ITEM_NAME = "itemname"
        val DESCRIPTION = "description"
        val PRICE = "price"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY ," +
                "$ITEM_NAME TEXT ," +
                "$DESCRIPTION TEXT ," +
                "$PRICE INTEGER )"

        db?.execSQL(CREATE_TABLE_QUERY)

    }

    fun inserTask(itemname: String, description: String, price: Int) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(ITEM_NAME, itemname)
        values.put(DESCRIPTION, description)
        values.put(PRICE, price)

        val idvalue = db.insert(
            TABLE_NAME,
            null,
            values
        )
        if (idvalue.toInt() == -1) {
            Toast.makeText(context, "Failed to Add the Item ", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success to Add the Item ", Toast.LENGTH_SHORT).show()

        }
    }

    fun getAllTask(): MutableList<AddModel> {
        val tasklist = mutableListOf<AddModel>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()


            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val item = cursor.getString(cursor.getColumnIndex(ITEM_NAME))
                val desc = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
                val itemprice = cursor.getInt(cursor.getColumnIndex(PRICE))

                val addModel = AddModel()
                addModel.id = id
                addModel.addDescription = desc
                addModel.addItemName = item
                addModel.addPrice = itemprice

                tasklist.add(addModel)
            } while (cursor.moveToNext())
        }
        return tasklist
    }

    fun searchItem(){

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}