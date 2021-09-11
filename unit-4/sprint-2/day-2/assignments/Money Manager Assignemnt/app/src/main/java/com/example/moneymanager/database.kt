package com.example.moneymanager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class database(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "moneyDB"
        val DB_VERSION = 1
        val TABLE_NAME = "money"
        val ID = "id"
        val DESCRIPTION = "title"
        val AMOUNT = "descprition"
        val TYPE = "type"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE_QUERY = "CREATE TABLE " +
                "$TABLE_NAME(" +
                "$ID INTEGER PRIMARY KEY," +
                "$DESCRIPTION TEXT, " +
                "$AMOUNT INTEGER , $TYPE TEXT)"

        db?.execSQL(CREATE_TABLE_QUERY)
    }

    fun insertTask(title: String, amount: Double, type : String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(DESCRIPTION, title)
        values.put(AMOUNT, amount)
        values.put(TYPE,type)

        val idValue = db.insert(
            TABLE_NAME,
            null,
            values
        )
        if (idValue.toInt() == -1) {
            Toast.makeText(context, "Failed to insert Data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully inserted the row", Toast.LENGTH_SHORT).show()
        }


    }
    fun getAllTasks(): MutableList<Money> {
        val taskList = mutableListOf<Money>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        //it will execute and return all the value which it had
        val cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()

            do {
                //got the data
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val title = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
                val desc = cursor.getDouble(cursor.getColumnIndex(AMOUNT))
                val type = cursor.getString(cursor.getColumnIndex(TYPE))

                val money = Money()
                money.mId = id
                money.mTvDescription = title
                money.amount = desc
                money.type = type

                taskList.add(money)

            } while (cursor.moveToNext())

        }
        return taskList
    }

    fun editTask(money: Money) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DESCRIPTION, money.mTvDescription)
        contentValues.put(AMOUNT, money.amount)
        //update tasks where id = task.id
        val result = db.update(TABLE_NAME, contentValues, "id=${money.mId}", null)
        if (result == 1) {
            Toast.makeText(context, "Task Updated Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Updating failed", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteTask(money: Money) {
        val db = writableDatabase
        val result = db.delete(TABLE_NAME, "id=${money.mId}", null)
        if (result == 1) {
            Toast.makeText(context, "Task Deleted Successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Failed To  Delete", Toast.LENGTH_SHORT).show()
        }

    }


    fun getIncomeExpneses(): Double{
        val db = readableDatabase
        val query = "Select SUM($AMOUNT) as Total from $TABLE_NAME where  $TYPE = 'Income'"
        val cursor= db?.rawQuery(query, null)
        var total=0.0
        if(cursor?.moveToFirst()!!){
            total=cursor.getDouble(0)
        }
        return total;

    }

    fun getExpenseExpneses(): Double{
        val db = readableDatabase
        val query = "Select SUM($AMOUNT) as Total from $TABLE_NAME where $TYPE = 'Expenses'"

        val cursor= db?.rawQuery(query, null)
        var total=0.0
        if(cursor?.moveToFirst()!!){
            total=cursor.getDouble(0)
        }
        return total;

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}

