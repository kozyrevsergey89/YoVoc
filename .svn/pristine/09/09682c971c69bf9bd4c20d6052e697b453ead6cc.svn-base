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
	private String[] columns = {DBHelper.COLUMN_ID, 
								DBHelper.COLUMN_WORD, 
								DBHelper.COLUMN_DESC, 
								DBHelper.COLUMN_TYPE};
	
	public YovocProvider(final Context context) {
		dbHelper = new DBHelper(context);
	}
	
	public void open() throws SQLException {
		dataBase =	dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public TermModel createTermin(final String termin, final String descript, final String type) {
		ContentValues values = new ContentValues();
		values.put(DBHelper.COLUMN_WORD, termin);
		values.put(DBHelper.COLUMN_DESC, descript);
		values.put(DBHelper.COLUMN_TYPE, type);
		long insertId = dataBase.insert(DBHelper.TABLE_TERMS, null, values);
		Cursor cursor = dataBase.query(DBHelper.TABLE_TERMS, columns, 
										DBHelper.COLUMN_ID + " = " + insertId,
										null, null, null, null);
		cursor.moveToFirst();
		TermModel term = cursorToTermin(cursor);
		cursor.close();
		return term;
	}
	
	
	public List<TermModel> selectTerms(final String type) {
		Cursor cursor = dataBase.rawQuery("select * from" 
											+ DBHelper.DB_NAME 
											+ " where " + DBHelper.COLUMN_TYPE 
											+ " = " + type, null);
		return getSelections(cursor);
	}
	
	public void deleteTermin(final TermModel termin) {
		long id = termin.getId();
		dataBase.delete(DBHelper.TABLE_TERMS, DBHelper.COLUMN_ID + " = " + id, null);
	}
	
	private List<TermModel> getSelections(final Cursor cursor) {
		List<TermModel> termins = new ArrayList<TermModel>();
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			TermModel model = cursorToTermin(cursor);
			termins.add(model);
			cursor.moveToNext();
		}
		cursor.close();
		return termins;
	}
	
	public List<TermModel> getAllTermins() {
		Cursor cursor = dataBase.query(DBHelper.TABLE_TERMS, columns, 
										null, null, null, null, null);
		return getSelections(cursor);
	}
	
	private TermModel cursorToTermin(final Cursor cursor) {
		TermModel termin = new TermModel();
		termin.setId(cursor.getLong(0));
		termin.setTermin(cursor.getString(1));
		termin.setDescription(cursor.getString(2));
		termin.setTermType(cursor.getString(3));
		return termin;
	}
}	
