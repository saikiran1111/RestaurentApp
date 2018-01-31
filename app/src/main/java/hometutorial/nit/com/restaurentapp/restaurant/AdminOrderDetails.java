package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import hometutorial.nit.com.restaurentapp.R;

public class AdminOrderDetails extends Activity {
	
	WebView webView;
	int totalAmount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_order_details);
		
		webView = (WebView) findViewById(R.id.adminwebView);
		
		Bundle bundle=getIntent().getExtras();
		String order=bundle.getString("order");
		
		//Create a table 
		StringBuilder htmldoc=new StringBuilder();
		htmldoc.append("<html><center>");
		htmldoc.append("<table border=2>");
		htmldoc.append("<th>S.No</th><th>Item</th><th>QTY</th><th>Total</th>");
		
		Map<String,String> orderMap = Admin_Main.ordersMap.get(order);
		
		Set<String> keys=orderMap.keySet();
		Iterator<String> keysIterator = keys.iterator();
		int count=1;
		
		 double totalAmount = 0;
		while(keysIterator.hasNext())
		{
			String itemname=keysIterator.next();
			
			String itemValue=orderMap.get(itemname);
			StringTokenizer st=new StringTokenizer(itemValue,",");
			String total=st.nextToken();
			totalAmount = totalAmount + Double.parseDouble(total);
			//change by r
			String qty=st.nextToken();
			
			htmldoc.append("<tr><td>"+count+"</td><td>"+itemname+"</td><td>"+qty+"</td><td>"+total+"</td></tr>");
			++count;
		}
		
		htmldoc.append("</table>TotalAmount:"+totalAmount+"<br/>VAT+SERVICETAX:1.95<br/>NetAmount:"+(totalAmount+1.95)+"</center></html>");
		webView.loadDataWithBaseURL(null,htmldoc.toString(),"text/html","UTF-8",null);
        
	}

}
