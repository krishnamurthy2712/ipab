package com.ipablive.utils;

import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;

public class CustomToolTipGenerator implements CategoryToolTipGenerator 
{

	@Override
	public String generateToolTip(CategoryDataset dataset, int row, int column) 
	{
		return row + ": " + column;
	}

}
