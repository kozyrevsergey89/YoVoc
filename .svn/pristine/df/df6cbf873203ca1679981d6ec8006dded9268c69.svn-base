package com.yovoc.app;

import java.util.List;

import com.yovoc.dao.TermModel;
import com.yovoc.dao.YovocProvider;
import android.app.Application;

/** Yovoc application context*/
public class YovocApplication extends Application{
	
	private YovocProvider dataProvider;
	
	@Override
	public void onCreate() {
		super.onCreate();
		dataProvider = new YovocProvider(this);
		dataProvider.open();
	}
	
	public void setTerm(final String termin, final String description, final String type){
		dataProvider.createTermin(termin, description, type);
	}
	
	public void deleteTerm(final TermModel termin){
		dataProvider.deleteTermin(termin);
	}
	
	public List<TermModel> getAllTerms() {
		return dataProvider.getAllTermins();
	}
	
	public List<TermModel> getAllByType(final String type){
		return dataProvider.selectTerms(type);
	}
	
}
