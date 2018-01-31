package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import hometutorial.nit.com.restaurentapp.R;
import hometutorial.nit.com.restaurentapp.table.TableActivity;


public class SelectPreference extends Activity implements OnClickListener {
	ImageView orderfood, bookTable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_peferance);
		
		orderfood = (ImageView) findViewById(R.id.img_foodOrder);
		bookTable = (ImageView) findViewById(R.id.img_tableBook);
		
		orderfood.setOnClickListener(this);
		bookTable.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_foodOrder:
			Intent foodordr = new Intent(getApplicationContext(), Choice.class);
			startActivity(foodordr);
			break;
		case R.id.img_tableBook:
			Intent tablebook = new Intent(getApplicationContext(), TableActivity.class);
			startActivity(tablebook);
			break;
			
		default:
			break;
		}
	}
}
// choice