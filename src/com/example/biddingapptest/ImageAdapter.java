package com.example.biddingapptest;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.tekle.oss.android.animation.AnimationFactory;
import com.tekle.oss.android.animation.AnimationFactory.FlipDirection;

public class ImageAdapter extends BaseAdapter {

	private static final String TAG = ImageAdapter.class.getSimpleName();

	private Context context;
	private BiddingAppMainActivity activity;
	private static LayoutInflater inflater = null;
	public int time = 0;
	public int counter = 0;
	private ViewAnimator viewAnimator;

	// references to our images
	public static Integer[] bidImageUrlArray = { R.drawable.sample_2,
			R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
			R.drawable.sample_2, R.drawable.sample_2, R.drawable.sample_2,
			R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_3,
			R.drawable.sample_3, R.drawable.sample_3, R.drawable.sample_4,
			R.drawable.sample_4, R.drawable.sample_4, R.drawable.sample_4 };

	// references to our name
	public static String[] bidNameArray = { "Item 1", "Item 2", "Item 3",
			"Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9",
			"Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15",
			"Item 16" };

	public static int[] timeArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16 };

	public ImageAdapter(Context context, int time) {
		// TODO Auto-generated constructor stub
		this.context = context;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (context instanceof BiddingAppMainActivity) {
			activity = (BiddingAppMainActivity) context;
		}

		this.time = time;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		ImageView imageIV = null;
		ImageView backImageIV = null;
		TextView timeTV = null;
		TextView categoryNameTV = null;
		if (convertView == null) {
			vi = inflater.inflate(R.layout.bid_entry_layout, null);
			Log.d(TAG, "counter: " + counter);

			categoryNameTV = (TextView) vi.findViewById(R.id.category_name_TV);
			timeTV = (TextView) vi.findViewById(R.id.time_TV);
			imageIV = (ImageView) vi.findViewById(R.id.image_IV);
			backImageIV = (ImageView) vi.findViewById(R.id.back_image_IV);
			final ViewAnimator viewAnimator = (ViewAnimator) vi
					.findViewById(R.id.viewFlipper);

			if (counter > 0 && counter <= 16) {
				imageIV.setImageResource(bidImageUrlArray[counter - 1]);
				categoryNameTV.setText(bidNameArray[counter - 1]);
//				timeTV.setText("" + timeArray[counter - 1]);
			}

			vi.setBackgroundColor(Color.BLACK);

			/**
			 * Bind a click listener to initiate the flip transitions
			 */
			// viewAnimator.setOnClickListener(new OnClickListener() {
			// @Override
			// public void onClick(View v) {
			// // This is all you need to do to 3D flip
			// }
			//
			// });

			categoryNameTV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// This is all you need to do to 3D flip
					AnimationFactory.flipTransition(viewAnimator,
							FlipDirection.LEFT_RIGHT);
				}

			});

			backImageIV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// This is all you need to do to 3D flip
					AnimationFactory.flipTransition(viewAnimator,
							FlipDirection.LEFT_RIGHT);
				}

			});
			counter++;
		}

		return vi;
	}
}
