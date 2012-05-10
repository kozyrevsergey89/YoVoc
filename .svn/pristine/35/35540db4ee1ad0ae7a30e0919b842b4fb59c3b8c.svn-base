package com.yovoc.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/** Database helper .*/
public class DBHelper extends SQLiteOpenHelper{

	public static final String TABLE_TERMS = "terms";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_WORD = "termin";
	public static final String COLUMN_DESC = "desc";
	public static final String DB_NAME = "yovoc.db";
	public static final int DB_VERSION = 1;
	
	private static final String CREATE_DATABASE = "create table "
										+ TABLE_TERMS + "(" + COLUMN_ID
										+ " integer primary key autoincrement, "
										+ COLUMN_WORD + " text not null, "
										+ COLUMN_DESC + " text not null);";
	
	
	public DBHelper(final Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(final SQLiteDatabase db) {
		db.execSQL(CREATE_DATABASE);
	}

	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TERMS);
		onCreate(db);
	}

}
