/*
 * Copyright 2014 - learnNcode (learnncode@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.learnncode.listviewwithdiffrowtype;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.learnncode.listviewwithdiffrowtype.model.DataModel;
import com.learnncode.listviewwithdiffrowtype.model.ImageModel;
import com.learnncode.listviewwithdiffrowtype.model.QuestionModel;
import com.learnncode.listviewwithdiffrowtype.viewHolder.ViewHolder;
import com.learnncode.listviewwithdiffrowtype.viewHolder.ViewHolder.DataViewHolder;
import com.learnncode.listviewwithdiffrowtype.viewHolder.ViewHolder.ImageViewHolder;

public class Adapter extends ArrayAdapter<Object> {

	private final int VIEW_TYPE_TEXT 		= 0;
	private final int VIEW_TYPE_IMAGE 		= 1;
	private final int VIEW_TYPE_QUESTION 	= 2;

	private ArrayList<Object> mList = new ArrayList<Object>();
	private LayoutInflater mInflater;


	public Adapter(Context context, int resource, ArrayList<Object> objects) {
		super(context, resource, objects);

		mList = objects;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder.DataViewHolder dataViewHolder 			= null;
		ViewHolder.ImageViewHolder imageViewHolder 			= null;
		ViewHolder.QuestionViewHolder questionViewHolder 	= null;

		int type = getItemViewType(position);

		if(type == VIEW_TYPE_TEXT){
			if(convertView == null){
				convertView 			= mInflater.inflate(R.layout.view_row_type_one, parent, false);
				dataViewHolder 			= new ViewHolder().new DataViewHolder();
				dataViewHolder.textView = (TextView) convertView.findViewById(R.id.textview);
				convertView.setTag(dataViewHolder);

				imageViewHolder 	= null;
				questionViewHolder 	= null;

			}else{
				dataViewHolder 		= (DataViewHolder)convertView.getTag();
				imageViewHolder 	= null;
				questionViewHolder 	= null;
			}
			dataViewHolder.textView.setText(((DataModel)mList.get(position)).simpleText);

		}else if(type == VIEW_TYPE_IMAGE){

			if(convertView == null){
				convertView 				= mInflater.inflate(R.layout.view_row_type_two, parent, false);
				imageViewHolder 			= new ViewHolder().new ImageViewHolder();
				imageViewHolder.textView 	= (TextView) convertView.findViewById(R.id.labelTextView);
				imageViewHolder.imageView	= (ImageView) convertView.findViewById(R.id.imageView);
				
				convertView.setTag(imageViewHolder);
				dataViewHolder 		= null;
				questionViewHolder 	= null;

			}else{
				
				imageViewHolder 	= (ImageViewHolder)convertView.getTag();
				dataViewHolder 		= null;
				questionViewHolder 	= null;
			}
			imageViewHolder.imageView.setBackgroundDrawable(((ImageModel)mList.get(position)).drawable);
			imageViewHolder.textView.setText("Position : " + position);

		}else{

			if(convertView == null){
				convertView = mInflater.inflate(R.layout.view_row_type_three, parent, false);
				questionViewHolder = new ViewHolder(). new QuestionViewHolder();
				questionViewHolder.textView 		= (TextView) convertView.findViewById(R.id.questionTextView);
				questionViewHolder.radioButtonOne 	= (RadioButton) convertView.findViewById(R.id.radioButtonOne);
				questionViewHolder.radioButtonTwo 	= (RadioButton) convertView.findViewById(R.id.radioButtonTwo);
				questionViewHolder.radioButtonthree = (RadioButton) convertView.findViewById(R.id.radioButtonThree);
				
				convertView.setTag(questionViewHolder);
				dataViewHolder 	= null;
				imageViewHolder = null;

			}else{
				questionViewHolder = (ViewHolder.QuestionViewHolder)convertView.getTag();
				dataViewHolder 	= null;
				imageViewHolder = null;
			}
			
			questionViewHolder.radioButtonOne.setOnClickListener(questionViewHolder.clickListener);
			questionViewHolder.radioButtonTwo.setOnClickListener(questionViewHolder.clickListener);
			questionViewHolder.radioButtonthree.setOnClickListener(questionViewHolder.clickListener);
			questionViewHolder.textView.setText(((QuestionModel)mList.get(position)).question);
		}

		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		return 3;
	}

	@Override
	public int getItemViewType(int position) {
		if(mList.get(position) instanceof DataModel){
			return VIEW_TYPE_TEXT;

		}else if(mList.get(position) instanceof ImageModel){
			return VIEW_TYPE_IMAGE;

		}else{
			return VIEW_TYPE_QUESTION;
		}
	}

	@Override
	public int getCount() {
		return null == mList ? 0 : mList.size();
	}

}
