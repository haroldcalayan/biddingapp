package com.example.biddingapptest;

import com.tekle.oss.android.animation.AnimationFactory;
import com.tekle.oss.android.animation.AnimationFactory.FlipDirection;

import android.R.anim;
import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class GridViewAdapter extends BaseAdapter {

	private static final String TAG = GridViewAdapter.class.getSimpleName();

	BiddingAppMainActivity activity;
	private static LayoutInflater inflater = null;
	private ImageAdapter img;
	private final int verticalAndHorizontalSpace = 2;
	boolean toggleForSmallToLargeView = false;
	ViewAnimator viewAnimator;
	int pos;

	private String[] categories = { "Foods", "Gadgets", "Travels", "Shopping" };

	public GridViewAdapter(BiddingAppMainActivity biddingAppMainActivity) {
		// TODO Auto-generated constructor stub
		activity = biddingAppMainActivity;

		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		img = new ImageAdapter(activity.getApplicationContext(), 30);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return categories.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return categories[position];
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
		TextView categoryNameTV;
		ImageView showIV;
		ImageView backImageIV;
//		ImageView ltIV;
//		ImageView gtIV;
		GridView gv;
		int counter = 0;

		if (convertView == null) {
			vi = inflater.inflate(R.layout.bid_category_layout, null);
			counter++;
			Log.d(TAG, "position: " + position);
		}

		gv = (GridView) vi.findViewById(R.id.category_GV);
		categoryNameTV = (TextView) vi.findViewById(R.id.category_name_TV);
		showIV = (ImageView) vi.findViewById(R.id.show_IV);
		backImageIV = (ImageView) vi
				.findViewById(R.id.back_image_for_largeview_IV);
//		ltIV = (ImageView) vi.findViewById(R.id.lt_IV);
//		gtIV = (ImageView) vi.findViewById(R.id.gt_IV);

		final ViewAnimator viewAnimator = (ViewAnimator) vi
				.findViewById(R.id.viewflipper_for_largeview_VF);

		categoryNameTV.setText(categories[position]);

		gv.setAdapter(img);
		gv.setNumColumns(2);

		final GridView gridViewFinal = gv;
		final ImageView showIVFinal = showIV;
		final TextView categoryNameTVFinal = categoryNameTV;

		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Log.d(TAG, "gv setonitemclicklistener - position: " + position);
				Log.d(TAG, "category name: " + categoryNameTVFinal.getText().toString());
				pos = position;
			}
		});

		gv.setOnTouchListener(new OnTouchListener() {
			@SuppressWarnings("deprecation")
			final GestureDetector gestureDetector = new GestureDetector(
					new SimpleOnGestureListener() {
						@Override
						public boolean onSingleTapConfirmed(MotionEvent e) {
							// TODO Auto-generated method stub
							Log.d(TAG, "gv onSingleTapConfirmed");
							if (!gridViewFinal.isSelected()) {
								gridViewFinal
										.setBackgroundResource(android.R.color.holo_green_light);
								gridViewFinal.setSelected(true);
							} else {
								gridViewFinal
										.setBackgroundResource(android.R.color.background_light);
								gridViewFinal.setSelected(false);
							}
							return super.onSingleTapConfirmed(e);
						}

						public boolean onDoubleTap(MotionEvent e) {
							// TODO Auto-generated method stub
							Log.d(TAG, "gv onDoubleTap");
							//Log.d(TAG, "position: " + pos);
							//showIVFinal
							//		.setImageResource(ImageAdapter.mThumbIds[pos]);
							viewAnimator.setVisibility(View.VISIBLE);
							gridViewFinal.setVisibility(View.GONE);
							return super.onDoubleTap(e);
						}
					});

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				Log.d(TAG, "gv onTouch: ");
				return gestureDetector.onTouchEvent(event);
			}
		});

		backImageIV.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});

		showIV.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});

		viewAnimator.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// This is all you need to do to 3D flip
			}

		});

		backImageIV.setOnTouchListener(new OnTouchListener() {
			@SuppressWarnings("deprecation")
			final GestureDetector gestureDetector = new GestureDetector(
					new SimpleOnGestureListener() {
						@Override
						public boolean onSingleTapConfirmed(MotionEvent e) {
							// TODO Auto-generated method stub
							Log.d(TAG, "backImageIV onSingleTapConfirmed");
							AnimationFactory.flipTransition(viewAnimator,
									FlipDirection.LEFT_RIGHT);
							return super.onSingleTapConfirmed(e);
						}

						public boolean onDoubleTap(MotionEvent e) {
							Log.d(TAG, "backImageIV onDoubleTap");
							viewAnimator.setVisibility(View.GONE);
							gridViewFinal.setVisibility(View.VISIBLE);
							return super.onDoubleTap(e);
						}
					});

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		});

		showIV.setOnTouchListener(new OnTouchListener() {
			@SuppressWarnings("deprecation")
			final GestureDetector gestureDetector = new GestureDetector(
					new SimpleOnGestureListener() {
						@Override
						public boolean onSingleTapConfirmed(MotionEvent e) {
							// TODO Auto-generated method stub
							Log.d(TAG, "showIV onSingleTapConfirmed");
							AnimationFactory.flipTransition(viewAnimator,
									FlipDirection.LEFT_RIGHT);
							return super.onSingleTapConfirmed(e);
						}

						public boolean onDoubleTap(MotionEvent e) {
							Log.d(TAG, "showIV onDoubleTap");
							viewAnimator.setVisibility(View.GONE);
							gridViewFinal.setVisibility(View.VISIBLE);
							return super.onDoubleTap(e);
						}
					});

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		});

//		ltIV.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(v.getContext(), "less than", Toast.LENGTH_SHORT)
//						.show();
//			}
//		});
//
//		gtIV.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(v.getContext(), "greater than",
//						Toast.LENGTH_SHORT).show();
//			}
//		});

//		if (categoryIdentifier == 4)
//			categoryIdentifier = 0;

		return vi;
	}
}
