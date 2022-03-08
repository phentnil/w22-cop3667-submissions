package com.jasonstarling.buildinginsomefunctionality;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {
  public static final String TABLE_ROW_ID = "_id";

  /*
      Next we have a public static final string for
      each row/table that we need to refer to both
      inside and outside this class
  */
  private static final String DB_NAME = "food_symptom_db";
  /*
      Next we have a private static final strings for
      each row/table that we need to refer to just
      inside this class
  */
  private static final int DB_VERSION = 1;
  // TODO Create Food and Symptom tables (separate) with different fields
  private static final String TABLE_FOOD = "food";
  private static final String TABLE_SYMPTOM = "symptom";
  private static final String TABLE_ROW_NAME = "name";
  // This is the actual database
  private final SQLiteDatabase db;

  public DataManager(Context context) {
    // Create an instance of our internal CustomSQLiteOpenHelper
    CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
    // Get a writable database
    db = helper.getWritableDatabase();
  }

  // Insert a record
  public void insert(String name, DataType dt) {
    String query = "INSERT INTO ";
    if (dt.equals(DataType.FOOD)) {
      // Insert into the food table
      query += TABLE_FOOD;
    } else if (dt.equals(DataType.SYMPTOM)) {
      // Insert into the symptom table
      query += TABLE_SYMPTOM;
    } else {
      // Should not happen
      Log.e("insert", "DataType not equal to FOOD nor SYMPTOM: " + dt);
    }
    query += " (" + TABLE_ROW_NAME + ") VALUES (" + name + ");";
    Log.i("insert() = ", query);
    db.execSQL(query);
  }

  // Here are all our helper methods

  // Delete a record
  public void delete(String name, DataType dt) {
    String query = "DELETE FROM ";
    if (dt.equals(DataType.FOOD)) {
      query += TABLE_FOOD;
    } else if (dt.equals(DataType.SYMPTOM)) {
      query += TABLE_SYMPTOM;
    } else {
      // Should not happen
      Log.e("delete", "DataType not equal to FOOD nor SYMPTOM: " + dt);
    }
    query += "WHERE " + TABLE_ROW_NAME + " = '" + name + "';";
    Log.i("delete() = ", query);
    db.execSQL(query);
  }

  // Get all the records
  public Cursor selectAll(DataType dt) {
    String query = "SELECT * from ";
    if (dt.equals(DataType.FOOD)) {
      query += TABLE_FOOD;
    } else if (dt.equals(DataType.SYMPTOM)) {
      query += TABLE_SYMPTOM;
    } else {
      // Should not happen
      Log.e("selectAll", "DataType not equal to FOOD nor SYMPTOM: " + dt);
    }
    return db.rawQuery(query, null);
  }

  // Find a specific record
  public Cursor searchName(String name, DataType dt) {
    String query = "SELECT " +
      TABLE_ROW_ID + ", " +
      TABLE_ROW_NAME +
      " from ";
    if (dt.equals(DataType.FOOD)) {
      query += TABLE_FOOD;
    } else if (dt.equals(DataType.SYMPTOM)) {
      query += TABLE_SYMPTOM;
    } else {
      // Should not happen
      Log.e("selectAll", "DataType not equal to FOOD nor SYMPTOM: " + dt);
    }
    query += " WHERE " + TABLE_ROW_NAME + " = '" + name + "';";
    Log.i("searchName() = ", query);
    return db.rawQuery(query, null);
  }

  public enum DataType {FOOD, SYMPTOM, BOTH, NONE}

  // This class is created when our DataManager is initialized
  private static class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
    public CustomSQLiteOpenHelper(Context context) {
      super(context, DB_NAME, null, DB_VERSION);
    }

    // This runs the first time the database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
      String newFoodTableQueryString = "create table " +
        TABLE_FOOD + " (" +
        TABLE_ROW_ID + " integer primary key autoincrement not null," +
        TABLE_ROW_NAME + " text not null);";
      String newSymptomTableQueryString = "create table " +
        TABLE_SYMPTOM + " (" +
        TABLE_ROW_ID + " integer primary key autoincrement not null," +
        TABLE_ROW_NAME + " text not null);";
      db.execSQL(newFoodTableQueryString);
      db.execSQL(newSymptomTableQueryString);
    }

    // This method only runs when we increment DB_VERSION
    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
      // Not needed in this app
      // but we must still override it
    }
  }
}