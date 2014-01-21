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

package com.learnncode.listviewwithdiffrowtype.viewHolder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ViewHolder {

	public TextView textView; 

	public OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View view) {
			RadioButton button = (RadioButton) view;
			Toast.makeText(view.getContext(), "You have selected : " + button.getText(), Toast.LENGTH_SHORT).show();
		}
	};


	public class DataViewHolder extends ViewHolder{ }



	public class ImageViewHolder extends ViewHolder {

		public ImageView imageView;
	}



	public class QuestionViewHolder extends ViewHolder {

		public RadioButton radioButtonOne;
		public RadioButton radioButtonTwo;
		public RadioButton radioButtonthree;

	}
}
