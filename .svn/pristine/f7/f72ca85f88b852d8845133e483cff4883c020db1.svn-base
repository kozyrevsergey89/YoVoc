package com.yovoc;

import java.util.List;
import com.yovoc.app.YovocApplication;
import com.yovoc.dao.TermModel;
import android.app.Activity;

public class BasicActivity extends Activity{

	private void setTermin(final String termin, final String description, final String type){
		((YovocApplication)getApplicationContext()).setTerm(termin, description, type);
	}
	
	private List<TermModel> getTerminsByType(final String type) {
		return ((YovocApplication)getApplicationContext()).getAllByType(type);
	}
	
	protected void deleteTermin(final TermModel termin) {
		((YovocApplication)getApplicationContext()).deleteTerm(termin);
	}
	
	protected List<TermModel> getAudioTerms() { return getTerminsByType(TermModel.AUDIO_TYPE); }
	
	protected List<TermModel> getImageTerms() { return getTerminsByType(TermModel.IMAGE_TYPE); }
	
	protected List<TermModel> getTextTerms() { return getTerminsByType(TermModel.TEXT_TYPE); }

	protected void setAudioTypeTerm(final String termin, final String description){
		setTermin(termin, description, TermModel.AUDIO_TYPE);
	}
	
	protected void setTextTypeTerm(final String termin, final String description) {
		setTermin(termin, description, TermModel.TEXT_TYPE);
	}
	
	protected void setImageTypeTerm(final String termin, final String description) {
		setTermin(termin, description, TermModel.IMAGE_TYPE);
	}
}