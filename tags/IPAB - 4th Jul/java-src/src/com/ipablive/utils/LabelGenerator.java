/**
 * 
 */
package com.ipablive.utils;

import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;

/**
 * @author 
 *
 */
public class LabelGenerator extends StandardCategoryItemLabelGenerator 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  
     * Generates an item label.  
     *   
     * @param dataset  the dataset.  
     * @param series  the series index.  
     * @param category  the category index.  
     *   
     * @return the label.  
     */   
    public String generateLabel(CategoryDataset dataset, int series, int category) 
    {   
        return dataset.getRowKey(series).toString()+"-"+dataset.getValue(series, category);   
    }   
	
}
