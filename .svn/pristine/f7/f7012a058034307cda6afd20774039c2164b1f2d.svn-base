package com.yovoc.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**Terms data source */
public class YovocProvider {

	private SQLiteDatabase dataBase;
	private DBHelper dbHelper;
	private String[] columns = {DBHelper.COLUMN_ID, DBHelper.COLUMN_WORD, DBHelper.COLUMN_DESC};
	
	public YovocProvider(final Context context) {
		dbHelper = new DBHelper(context);
	}
	
	public void open() throws SQLException {
		dataBase =	dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public TermModel createTermin(final String termin, final String descript) {
		ContentValues values = new ContentValues();
		values.put(DBHelper.COLUMN_WORD, termin);
		values.put(DBHelper.COLUMN_DESC, descript);
		long insertId = dataBase.insert(DBHelper.TABLE_TERMS, null, values);
		Cursor cursor = dataBase.query(DBHelper.TABLE_TERMS, columns, DBHelper.COLUMN_ID + " = " + insertId,
					null, null, null, null);
		cursor.moveToFirst();
		TermModel term = cursorToTermin(cursor);
		cursor.close();
		return term;
	}
	
	public void deleteTermin(final TermModel termin) {
		long id = termin.getId();
		dataBase.delete(DBHelper.TABLE_TERMS, DBHelper.COLUMN_ID + " = " + id, null);
	}
	
	public List<TermModel> getAllTermins() {
		List<TermModel> termins = new ArrayList<TermModel>();
		Cursor cursor = dataBase.query(DBHelper.TABLE_TERMS, columns, 
					null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			TermModel model = cursorToTermin(cursor);
			termins.add(model);
			cursor.moveToNext();
		}
		cursor.close();
		return termins;
	}
	
	private TermModel cursorToTermin(final Cursor cursor) {
		TermModel termin = new TermModel();
		termin.setId(cursor.getLong(0));
		termin.setTermin(cursor.getString(1));
		termin.setDescription(cursor.getString(2));
		return termin;
	}
	
}	
