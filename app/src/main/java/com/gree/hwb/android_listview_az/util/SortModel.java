package com.gree.hwb.android_listview_az.util;

/**
 * Created by Administrator on 2016/08/13.
 */
public class SortModel
{
	private String name; // 显示的数据
	private String sortLetters; // 显示数据拼音的首字母
	public String getSortLetters()
	{
		return sortLetters;
	}

	public void setSortLetters(String sortLetters)
	{
		this.sortLetters = sortLetters;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
