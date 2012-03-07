package com.kada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListviewDemoTestActivity extends ListActivity {
	private List<Map<String, Object>> mData;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = getData();
		MyAdapter adapter = new MyAdapter(this);
		setListAdapter(adapter);
		this.getListView().setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("onItemClick","onItemClick"+arg2);
				
			}
			
		});
//        setContentView(R.layout.main);
    }
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "G1");
		map.put("info", "google 1");
		map.put("img", R.drawable.i1);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.i2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.i3);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.i2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.i3);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.i2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.i3);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.i2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.i3);
		list.add(map);
		
		return list;
	}

    
	public final class ViewHolder{
		public ImageView img;
		public TextView title;
		public TextView info;
		public Button viewBtn;
	}
    
    class MyAdapter extends BaseAdapter{
    	
    	private LayoutInflater mInflater;
    	
    	public MyAdapter(Context context){
    		mInflater=LayoutInflater.from(context);
    	}
    	
    	//How many items are in the data set represented by this Adapter.
		@Override
		public int getCount() {
			Log.v("getCount", "getCount");
			return mData.size();
		}

		//Get the data item associated with the specified position in the data set.
		@Override
		public Object getItem(int position) {
			Log.v("getItem", "getItem"+position);
			return null;
		}

		//Get the row id associated with the specified position in the list.
		@Override
		public long getItemId(int position) {
			Log.v("getItemId", "getItemId:"+position);
			return 0;
		}

		/*Get a View that displays the data at the specified position in the data set. 
		 * You can either create a View manually or inflate it from an XML layout file. 
		 * When the View is inflated, the parent View (GridView, ListView...) will apply 
		 * default layout parameters unless you use inflate(int, android.view.ViewGroup, boolean) 
		 * to specify a root view and to prevent attachment to the root
		*/
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Log.v("getView", "getView:"+position);
			ViewHolder holder = null;
			if (convertView == null) {
				Log.w("convertView", "convertView=null");
				holder=new ViewHolder();  
				
				convertView = mInflater.inflate(R.layout.vlist2, null);
				holder.img = (ImageView)convertView.findViewById(R.id.img);
				holder.title = (TextView)convertView.findViewById(R.id.title);
				holder.info = (TextView)convertView.findViewById(R.id.info);
				holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
				convertView.setTag(holder);
				
			}else {
				Log.w("convertView", "convertView!=null");
				holder = (ViewHolder)convertView.getTag();
			}
			
			
			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.title.setText((String)mData.get(position).get("title"));
			holder.info.setText((String)mData.get(position).get("info"));
			
			holder.viewBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.e("click", "click");
				}
			});			
			return convertView;
		}
    	
    }

}