package br.com.exemplo.sqlite;

import java.util.ArrayList;

import br.com.exemplo.model.WineAdega;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "minhaAdega";

    // Adega table name
    private static final String TABLE_ADEGA = "adega";

    // Adega Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_LABEL = "label";
    private static final String KEY_QUANTIDADE = "quantidade";
    private static final String KEY_COMENTARIO = "comentario";
    private final ArrayList<WineAdega> adega_lista = new ArrayList<WineAdega>();

    public DatabaseHandler(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
	String CREATE_ADEGA_TABLE = "CREATE TABLE " + TABLE_ADEGA + "("
		+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_LABEL + " TEXT,"
		+ KEY_QUANTIDADE + " TEXT," + KEY_COMENTARIO + " TEXT" + ")";
	db.execSQL(CREATE_ADEGA_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	// Drop older table if existed
	db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADEGA);

	// Create tables again
	onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new WINE
    public void Add_Wine(WineAdega wine) {
	SQLiteDatabase db = this.getWritableDatabase();
	ContentValues values = new ContentValues();
	values.put(KEY_LABEL, wine.getLabel()); // wine label
	values.put(KEY_QUANTIDADE, wine.getQuantidade()); // wine quantidade
	values.put(KEY_COMENTARIO, wine.getComentario()); // wine comentario
	// Inserting Row
	db.insert(TABLE_ADEGA, null, values);
	db.close(); // Closing database connection
    }

    // Getting single contact
    WineAdega Get_Wine(int id) {
	SQLiteDatabase db = this.getReadableDatabase();

	Cursor cursor = db.query(TABLE_ADEGA, new String[] { KEY_ID,
		KEY_LABEL, KEY_QUANTIDADE, KEY_COMENTARIO }, KEY_ID + "=?",
		new String[] { String.valueOf(id) }, null, null, null, null);
	if (cursor != null)
	    cursor.moveToFirst();

	WineAdega wine = new WineAdega(Integer.parseInt(cursor.getString(0)),
		cursor.getString(1), cursor.getString(2), cursor.getString(3));
	// return wine
	cursor.close();
	db.close();

	return wine;
    }

    // Getting All Wines
    public ArrayList<WineAdega> Get_Wines() {
	try {
	    adega_lista.clear();

	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_ADEGA;

	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);

	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
		do {
		    WineAdega wine = new WineAdega();
		    wine.setId(Integer.parseInt(cursor.getString(0)));
		    wine.setLabel(cursor.getString(1));
		    wine.setQuantidade(cursor.getString(2));
		    wine.setComentario(cursor.getString(3));
		    // Adding wine to list
		    adega_lista.add(wine);
		} while (cursor.moveToNext());
	    }

	    // return contact list
	    cursor.close();
	    db.close();
	    return adega_lista;
	} catch (Exception e) {
	    // TODO: handle exception
	    Log.e("todos vinhos", "" + e);
	}

	return adega_lista;
    }

    // Updating single wine
    public int Update_Wine(WineAdega wine) {
	SQLiteDatabase db = this.getWritableDatabase();

	ContentValues values = new ContentValues();
	values.put(KEY_LABEL, wine.getLabel());
	values.put(KEY_QUANTIDADE, wine.getQuantidade());
	values.put(KEY_COMENTARIO, wine.getComentario());

	// updating row
	return db.update(TABLE_ADEGA, values, KEY_ID + " = ?",
		new String[] { String.valueOf(wine.getId()) });
    }

    // Deleting single contact
    public void Delete_Wine(int id) {
	SQLiteDatabase db = this.getWritableDatabase();
	db.delete(TABLE_ADEGA, KEY_ID + " = ?",
		new String[] { String.valueOf(id) });
	db.close();
    }

    // Getting contacts Count
    public int Get_Total_Wine() {
	String countQuery = "SELECT  * FROM " + TABLE_ADEGA;
	SQLiteDatabase db = this.getReadableDatabase();
	Cursor cursor = db.rawQuery(countQuery, null);
	cursor.close();

	// return count
	return cursor.getCount();
    }

}
