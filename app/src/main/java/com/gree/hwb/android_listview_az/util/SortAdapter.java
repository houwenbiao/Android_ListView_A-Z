package com.gree.hwb.android_listview_az.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/08/13.
 */
public abstract class SortAdapter<T> extends BaseAdapter implements SectionIndexer
{
	private List<SortModel> list = null;
	private Context mContext;
	protected LayoutInflater mInflater;
	private int layoutId;
	public SortAdapter(Context mContext, int layoutId,List<SortModel> list)
	{
		this.mContext = mContext;
		this.list = list;
		mInflater = LayoutInflater.from(mContext);
		this.layoutId = layoutId;
	}

	/**
	 * 当ListView数据发生变化时,调用此方法来更新ListView
	 *
	 * @param list
	 */
	public void updateListView(List<SortModel> list)
	{
		this.list = list;
		notifyDataSetChanged();
	}

	public int getCount()
	{
		return this.list.size();
	}

	public SortModel getItem(int position)
	{
		return list.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	public View getView(final int position, View view, ViewGroup arg2)
	{
		com.zhy.base.adapter.ViewHolder holder = com.zhy.base.adapter.ViewHolder.get(mContext,view,arg2,layoutId,position);
		convert(holder , getItem(position));
		return holder.getConvertView();
	}

	public abstract void convert(com.zhy.base.adapter.ViewHolder holder, SortModel t);

	final static class ViewHolder
	{
		TextView tvTitle;
	}

	/**
	 * 根据ListView的当前位置获取分类的首字母的Char ascii值
	 */
	public int getSectionForPosition(int position)
	{
		return list.get(position).getSortLetters().charAt(0);
	}

	/**
	 * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
	 */
	public int getPositionForSection(int section)
	{
		for (int i = 0; i < getCount(); i++)
		{
			String sortStr = list.get(i).getSortLetters();
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section)
			{
				return i;
			}
		}

		return -1;
	}

	/**
	 * 提取英文的首字母，非英文字母用#代替。
	 *
	 * @param str
	 * @return
	 */
	private String getAlpha(String str)
	{
		String sortStr = str.trim().substring(0, 1).toUpperCase();
		// 正则表达式，判断首字母是否是英文字母
		if (sortStr.matches("[A-Z]"))
		{
			return sortStr;
		} else
		{
			return "#";
		}
	}

	@Override
	public Object[] getSections()
	{
		return null;
	}
}
