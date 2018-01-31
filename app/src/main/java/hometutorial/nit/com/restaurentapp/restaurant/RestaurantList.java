package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hometutorial.nit.com.restaurentapp.R;

public class RestaurantList extends Activity implements OnItemClickListener {

	public static final String[] titles = new String[] { "Bayleaf restaurant", "Paradise Birmingham", "Restaurant menu on top", "Silver-coin-indian-grill", "The Spicy Venue" };

	public static final String[] descriptions = new String[] { "We are world famous for our hyderabadi biryani",
			"This stylish restaurant serves dishes from across uk and the world",
			"Plain and simple cafe offering basic Hyderabad food with South Indian and Chinese options",
			"Most delicious  with quality and quintity",
			"Brick-walled restaurant with large windows and a menu of dishes from across India" };

	public static final Integer[] images = { R.drawable.bayleaf, R.drawable.paradiseb, R.drawable.restaurantme,
			R.drawable.silvercoin, R.drawable.tajindia };

	ListView listView;
	List<RowItemRestaurant> rowItemRestaurants;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_list);

		rowItemRestaurants = new ArrayList<RowItemRestaurant>();
		for (int i = 0; i < titles.length; i++) {
			RowItemRestaurant item = new RowItemRestaurant(images[i], titles[i], descriptions[i]);
			rowItemRestaurants.add(item);
		}

		listView = (ListView) findViewById(R.id.list);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.restaurant_list_item, rowItemRestaurants);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 0:
			String name = "Welcome To The Bayleaf restaurant ";
			Intent i = new Intent(getApplicationContext(), Main.class);
			i.putExtra("name", name);
			i.putExtra("restimage", R.drawable.bayleaf);
			startActivity(i);
			break;
		case 1:
			String angeethi = "Welcome To The Paradise Birmingham";
			Intent ang = new Intent(getApplicationContext(), Main.class);
			ang.putExtra("name", angeethi);
			ang.putExtra("restimage", R.drawable.paradiseb);
			startActivity(ang);
			break;
		case 2:
			String chefs = "Welcome To The Restaurant menu on top";
			Intent che = new Intent(getApplicationContext(), Main.class);
			che.putExtra("name", chefs);
			che.putExtra("restimage", R.drawable.restaurantme);
			startActivity(che);
			break;
		case 3:
			String wing = "Welcome To The Silver-coin-indian-grill";
			Intent w = new Intent(getApplicationContext(), Main.class);
			w.putExtra("name", wing);
			w.putExtra("restimage", R.drawable.silvercoin);
			startActivity(w);
			break;
		case 4:
			String spice = "Welcome To The Spicy Venue";
			Intent s = new Intent(getApplicationContext(), Main.class);
			s.putExtra("name", spice);
			s.putExtra("restimage", R.drawable.spicevnnu);
			startActivity(s);
			break;
		default:
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.logout, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.logout) {
			MenuUtility.logout(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
	}

}