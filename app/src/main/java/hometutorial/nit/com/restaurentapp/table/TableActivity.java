package hometutorial.nit.com.restaurentapp.table;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import hometutorial.nit.com.restaurentapp.R;


public class TableActivity extends Activity implements OnClickListener, OnItemClickListener {
	

	ListView listview;
	
	/** The button add. */
	ImageButton buttonAdd;
	
	/** The button finalize. */
	ImageButton buttonFinalize;
	
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState the saved instance state
     */
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_table);
	
	    //Get the table
	    Bundle b = getIntent().getExtras();
	    
	    

	    listview = (ListView) findViewById(R.id.tableListView);
	    listview.setOnItemClickListener(this);
	    
	    buttonAdd =(ImageButton) findViewById(R.id.orderAddButton);
	    buttonAdd.setOnClickListener(this);
	    
	    buttonFinalize =(ImageButton) findViewById(R.id.tableOrderFinalizaButton);
	    buttonFinalize.setOnClickListener(this);

	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	protected void onStart()
	{
		super.onStart();
		
	    TextView text= (TextView) findViewById(R.id.tableTitle);
	   
	    
	    text= (TextView) findViewById(R.id.tableCustomers);
	    
	    
	    listview.invalidateViews();
	}

	/* Event triggered at click on "New Order button"
	 * 
	 * (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View button) {
		if(button==buttonAdd)
		{
			
			this.listview.invalidateViews();
			Toast.makeText(this, "Created a new order for this table", Toast.LENGTH_SHORT).show();
		}
		else
		{
			listview.setOnItemClickListener(null);
			buttonAdd.setOnClickListener(null);
			
			Toast.makeText(this, "Finalized the order!", Toast.LENGTH_SHORT).show();
		}
	}

	/* Event triggered on click on one of the orders
	 * 
	 * (non-Javadoc)
	 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		/*Intent myIntent = new Intent(this, OrderActivity.class);
		myIntent.putExtra("tableID", table.id);
		myIntent.putExtra("orderID", table.tableOrder.orders.get(position).id);
		this.startActivity(myIntent);*/
	}

}