package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hometutorial.nit.com.restaurentapp.R;

public class CustomListViewAdapter extends ArrayAdapter<RowItemRestaurant> {

	Context context;

	public CustomListViewAdapter(Context context, int resourceId, List<RowItemRestaurant> items) {
		super(context, resourceId, items);
		this.context = context;
	}

	/* private view holder class */
	private class ViewHolder {
		ImageView imageView;
		TextView txtTitle;
		TextView txtDesc;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		RowItemRestaurant rowItemRestaurant = getItem(position);

		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.restaurant_list_item, null);
			holder = new ViewHolder();
			holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
			holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
			holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		holder.txtDesc.setText(rowItemRestaurant.getDesc());
		holder.txtTitle.setText(rowItemRestaurant.getTitle());
		holder.imageView.setImageResource(rowItemRestaurant.getImageId());

		return convertView;
	}
}
