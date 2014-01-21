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
import java.util.Collections;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.learnncode.listviewwithdiffrowtype.model.DataModel;
import com.learnncode.listviewwithdiffrowtype.model.ImageModel;
import com.learnncode.listviewwithdiffrowtype.model.QuestionModel;

public class MainActivity extends Activity {

	private ListView mListView;
	private ArrayList<Object> mList = new ArrayList<Object>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView)findViewById(android.R.id.list);
		createModel();

	}

	private void createModel() {

		//Data Model
		for(int i = 0; i < 5; i++){
			DataModel dataModel = new DataModel();
			dataModel.simpleText = " " + i;
			mList.add(dataModel);
		}

		QuestionModel questionModel = new QuestionModel();
		questionModel.question = getString(R.string.do_you_like_coding);
		mList.add(questionModel);
		questionModel = null;

		questionModel = new QuestionModel();
		questionModel.question = getString(R.string.do_you_like_android);
		mList.add(questionModel);
		questionModel = null;

		questionModel = new QuestionModel();
		questionModel.question = getString(R.string.do_you_like_comedy);
		mList.add(questionModel);
		questionModel = null;

		questionModel = new QuestionModel();
		questionModel.question = getString(R.string.do_you_like_action);
		mList.add(questionModel);
		questionModel = null;

		questionModel = new QuestionModel();
		questionModel.question = getString(R.string.do_you_like_drama);
		mList.add(questionModel);
		questionModel = null;




		ImageModel imageModel = new ImageModel();
		imageModel.drawable = getResources().getDrawable(R.drawable.ic_1);
		mList.add(imageModel);
		imageModel = null;

		imageModel = new ImageModel();
		imageModel.drawable = getResources().getDrawable(R.drawable.ic_2);
		mList.add(imageModel);
		imageModel = null;

		imageModel = new ImageModel();
		imageModel.drawable = getResources().getDrawable(R.drawable.ic_3);
		mList.add(imageModel);
		imageModel = null;

		imageModel = new ImageModel();
		imageModel.drawable = getResources().getDrawable(R.drawable.ic_4);
		mList.add(imageModel);
		imageModel = null;

		imageModel = new ImageModel();
		imageModel.drawable = getResources().getDrawable(R.drawable.ic_5);
		mList.add(imageModel);
		imageModel = null;


		long seed = System.nanoTime();
		Collections.shuffle(mList, new Random(seed));

		mListView.setAdapter(new Adapter(getApplicationContext(), 0, mList));

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Toast.makeText(getApplicationContext(), "Position : " + position, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
