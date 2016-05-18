package com.example.more.item.listview;

import java.util.ArrayList;
import java.util.List;

import com.example.more.item.listview.CommonAdapter.MultiItemTypeSupportListener;

import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

	private ListView lv;
	private List<String> mDatas = new ArrayList<String>();
	private CommonAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < 200; i++) {
			mDatas.add("当前的位置是=="+i);
		}
		lv = (ListView) findViewById(R.id.lv);
		adapter = new CommonAdapter<String>(this, R.layout.item_list1, mDatas) {
			
			@Override
			public void convert(CommonViewHolder holder, String model,int position) {
				switch (adapter.getItemViewType(position)) {
				case 0:
					holder.<TextView>getView(R.id.posttion).setText(model);;
					break;
				case 1:
					holder.<ImageView>getView(R.id.iv).setBackgroundResource(R.drawable.emotion);
					holder.<TextView>getView(R.id.posttion).setText(model);
					break;
				case 2:
					holder.<ImageView>getView(R.id.iv).setBackgroundResource(R.drawable.emotion);
					holder.<ImageView>getView(R.id.iv1).setBackgroundResource(R.drawable.expression_pressed);
					holder.<TextView>getView(R.id.posttion).setText(model);
					
					break;
				}
				
			}
		};
		adapter.setMultiItemTypeSupportListener(new MultiItemTypeSupportListener() {

			/**
			 * 设置convertView的type类型
			 * @param position
			 * @return
			 */
			@Override
			public int getItemViewType(int position) {
				// TODO Auto-generated method stub
				if (position % 3 == 0) {
					return 0;
				}
				if (position % 10 == 0) {
					return 1;
				}
				return 2;
				
			}

			/**
			 * 设置convertView的type数量
			 * @return
			 */
			@Override
			public int getViewTypeCount() {
				return 3;
			}

			/**
			 * 设置不同位置convertView的布局文件
			 * @param position
			 * @return
			 */
			@Override
			public int getLayoutId(int position) {
				if (position % 3 == 0) {
					return R.layout.item_list;
				}
				if (position % 10 == 0) {
					return R.layout.item_list1;
				}
				return R.layout.item_list2;
			}
		});
		lv.setAdapter(adapter);
	}
}
