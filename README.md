ListWithDiffRowViewType
=======================

 Demo showing the functionality of getViewTypeCount() and getItemViewType(…)  in list-view.


We all know that listview is the most used and conventional way of displaying list  of data in android. Many-a-times we do encounter a scenario where we want to display list item depending on a specific condition for example have a look at the image below.

Screenshots
-----------------------------------

![List View](https://dl.dropboxusercontent.com/u/61919232/learnNcode/ListViewWithDiffRowType/listView.png "List view")

<br>





The common way of displaying such a data is to inflate one row and depending on the condition you may hide or make a view visible.

Toggling a view between `VIEW.GONE` and `VIEW.VISIBLE` can be a very expensive task inside the `getview(..)` which will sure affect the list scroll. This can be easily managed and tackled with listview’s pre-defined methods `getViewTypeCount()` and `getItemViewType(..)`.

So to begin with you need to create separate layouts for each type of view that will be displayed. This way it will be more efficient and less clustered to manage the data.

To put all this into action i have created a demo project which can be downloaded here.

In this project i ' m showing 3 different types of row in a listview:

1. A simple text

 ![View type one](https://dl.dropboxusercontent.com/u/61919232/learnNcode/ListViewWithDiffRowType/row_type_one.png "View type one")

<br>

2. Text with image view

 ![View type two](https://dl.dropboxusercontent.com/u/61919232/learnNcode/ListViewWithDiffRowType/row_type_two.png "View type two")

<br>

3. Poll with three option

 ![View type three](https://dl.dropboxusercontent.com/u/61919232/learnNcode/ListViewWithDiffRowType/row_type_three.png "View type  three")

<br>

so first create 3 different xmls for different row type.

__1]__ view_row_type_one.xml (for text layout)

```xml
<TextView xmlns:android="http://schemas.android.com/apk/res/android"

android:id="@+id/textview"

android:layout_width="match_parent"

android:layout_height="match_parent"

android:layout_gravity="center"

android:background="@android:color/darker_gray"

android:textColor="@android:color/black"

android:textSize="20sp"

android:padding="10dp"/>

```

__2]__ view_row_type_two.xml (layout with text and image )

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"

android:layout_width="match_parent"

android:layout_height="match_parent"

android:background="@android:color/darker_gray"

android:padding="10dp" >

<ImageView

android:id="@+id/imageView"

android:layout_width="100dp"

android:layout_height="100dp"

android:layout_centerInParent="true"

android:layout_marginBottom="10dp"

android:contentDescription="@null" />

<TextView

android:id="@+id/labelTextView"

android:layout_width="wrap_content"

android:layout_height="wrap_content"

android:layout_alignEnd="@id/imageView"

android:layout_below="@id/imageView"

android:layout_marginTop="15dp"

android:textColor="@android:color/black"

android:textSize="20sp" />

</RelativeLayout>
```

__3]__ view_row_type_three.xml (layout with radio buttons)

```xml
<RadioGroup xmlns:android="http://schemas.android.com/apk/res/android"

android:layout_width="match_parent"

android:layout_height="match_parent"

android:background="@android:color/darker_gray"

android:padding="10dp" >

<TextView

android:id="@+id/questionTextView"

android:layout_width="wrap_content"

android:layout_height="wrap_content"

android:layout_marginLeft="5dp"

android:textColor="@android:color/black"

android:textSize="20sp" />

<RadioButton

android:id="@+id/radioButtonOne"

android:layout_width="wrap_content"

android:layout_height="wrap_content"

android:text="@string/yes"

android:textColor="@android:color/black"

android:textSize="20sp" />

<RadioButton

android:id="@+id/radioButtonTwo"

android:layout_width="wrap_content"

android:layout_height="wrap_content"

android:text="@string/no"

android:textColor="@android:color/black"

android:textSize="20sp" />

<RadioButton

android:id="@+id/radioButtonThree"

android:layout_width="wrap_content"

android:layout_height="wrap_content"

android:text="@string/cant_say"

android:textColor="@android:color/black"

android:textSize="20sp" />

</RadioGroup>
```

What does `getViewTypeCount()` and `getItemViewType(...)` do ?

These methods are called before `getView(...)`.

1] getViewTypeCount()

Returns the count of different type of views. Here we are having three different type of views so this method will return count as 3.

2] getItemViewType(...) 

Here we will write the logic to determine the type of view.

```java
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
```

Inside getView(...) method first we determine the type of view by calling getItemViewType(..) method, this will return the type to be inflated as shown below.

```java
@Override

public View getView(int position, View convertView, ViewGroup parent) {

ViewHolder.DataViewHolder dataViewHolder = null;

ViewHolder.ImageViewHolder imageViewHolder = null;

ViewHolder.QuestionViewHolder questionViewHolder = null;

int type = getItemViewType(position); // to determine type of view.

if(type == VIEW_TYPE_TEXT){

if(convertView == null){

convertView = mInflater.inflate(R.layout.view_row_type_one, parent, false);

convertView.setTag(dataViewHolder);

.................

}else{

dataViewHolder = (DataViewHolder)convertView.getTag();

........

}

}else if(type == VIEW_TYPE_IMAGE){

if(convertView == null){

convertView = mInflater.inflate(R.layout.view_row_type_two, parent, false);

convertView.setTag(imageViewHolder);

..........

}else{

imageViewHolder = (ImageViewHolder)convertView.getTag();

...............

}

}else{

if(convertView == null){

convertView = mInflater.inflate(R.layout.view_row_type_three, parent, false);

convertView.setTag(questionViewHolder);

.................

}else{

questionViewHolder = (ViewHolder.QuestionViewHolder)convertView.getTag();

.......

}

}

return convertView;

}
```

This is all it. You can follow this mechanism of displaying data and you will notice significant improvements in the list scroll and the number of objects created. Hope this is useful to someone.


Happy coding, happy learning. :)
