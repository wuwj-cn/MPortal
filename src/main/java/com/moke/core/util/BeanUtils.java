package com.moke.core.util;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;

public class BeanUtils {

	public static String[] getNullPropertyNames(Object source) {
		Assert.notNull(source, "Source must not be null");
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<String>();
		for(PropertyDescriptor pd : pds) {
			Object value = src.getPropertyValue(pd.getName());
			if(null == value) emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
	
	public static void copyProperties(Object source, Object target) {
		String[] ignoreProperties = getNullPropertyNames(source);
		org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);;
	}
}
