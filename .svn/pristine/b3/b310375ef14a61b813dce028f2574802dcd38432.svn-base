package com.yovoc.test;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class ChartView {

	private Context context;
	
	public ChartView(final Context context) {
		this.context = context;
	}
	
	public Intent getChartsIntent() {
		int[] colors =	new int[] { Color.RED, Color.GREEN };
		CategorySeries categorySeries = new CategorySeries("Yovoc results");
		categorySeries.add("correct",30);
		categorySeries.add("wrong",70);
		return ChartFactory.getPieChartIntent(context, categorySeries, buildRenderer(colors), "Yovoc Results");
	}
	
	private DefaultRenderer buildRenderer(final int[] colors) {
		DefaultRenderer renderer = new DefaultRenderer();
		renderer.setBackgroundColor(Color.WHITE);
		for(int color : colors) {
			SimpleSeriesRenderer simpleRenderer = new SimpleSeriesRenderer();
			simpleRenderer.setColor(color);
			renderer.addSeriesRenderer(simpleRenderer);
		}
		return renderer;
	}
	
}
