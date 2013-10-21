package com.example.biddingapptest;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class BiddingAppMainActivity extends Activity {

	private GridView biddingGV;
	private GridView biddingFirstGV;
	private GridView biddingSecondGV;
	private GridView biddingThirdGV;
	private GridView biddingFourthGV;
	private Button startBtn;
	private TextView timeTV;
	int counter;
	CountDownTimer cdt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bidding_app_main);

		startBtn = (Button) findViewById(R.id.start_BTN);
		biddingGV = (GridView) findViewById(R.id.bid_GV);
		final GridViewAdapter gva = new GridViewAdapter(this);
		biddingGV.setAdapter(gva);

//		biddingGV.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View v,
//					int position, long id) {
//				Toast.makeText(getApplicationContext(), "" + position,
//						Toast.LENGTH_SHORT).show();
//			}
//		});

		/*
		cdt = new CountDownTimer(countDownStartTime, 1000) {

			public void onTick(long millisUntilFinished) {
				counter = (int) (millisUntilFinished / 1000);
				img.time = counter;
				img.notifyDataSetChanged();
				biddingGV.invalidateViews();
			}

			public void onFinish() {
				img.time = 0;
				img.notifyDataSetChanged();
				biddingGV.invalidateViews();
				Toast.makeText(getApplicationContext(), "Done",
						Toast.LENGTH_SHORT).show();
				startBtn.setEnabled(true);
			}
		};
		*/
	}
}
