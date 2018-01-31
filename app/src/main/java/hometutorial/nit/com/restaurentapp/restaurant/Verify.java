package hometutorial.nit.com.restaurentapp.restaurant;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import hometutorial.nit.com.restaurentapp.R;

public class Verify extends Activity {
	
	EditText address,mobile;
	Button order;
	StringBuilder orderId;
	Map<String,String> ht;
	TextView menu;
	String phno="7207295797";
	static String givenmobileno;
	static Verify ob;
	//static StringBuilder htmldoc=new StringBuilder();
	WebView wv;
	StringBuilder smsdata=new StringBuilder();
	 double totalAmount;
	public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
	{
		setContentView(R.layout.verify);
		ob=this;
		address=(EditText)findViewById(R.id.V1);
		mobile=(EditText)findViewById(R.id.V2);
		order=(Button)findViewById(R.id.button1);
		menu=(TextView)findViewById(R.id.vtextView1);
		EditText et=(EditText)findViewById(R.id.V2);
		wv=(WebView)findViewById(R.id.webView1);
		wv.setWebChromeClient(new WebChromeClient());
		givenmobileno=et.getText().toString();
		
		Bundle bundle=getIntent().getExtras();
		String message=bundle.getString("veg");
		
		Bundle bundle1=getIntent().getExtras();
		String message1=bundle1.getString("nonveg");
		
		Bundle bundle2=getIntent().getExtras();
		String message2=bundle2.getString("desert");
		
		orderId=new StringBuilder();
		StringBuilder htmldoc=new StringBuilder();
		
		htmldoc.append("<html><center>");
		htmldoc.append("<table border=2>");
		htmldoc.append("<th>S.No</th><th>Item</th><th>QTY</th><th>Total</th>");
		
		if(message!=null)
		{
			ht=Menu1.ht;
			Set<String> keys=ht.keySet();
			Iterator<String> keysIterator = keys.iterator();
			int count=1;
			
			//TODO
			while(keysIterator.hasNext())
			{
				String itemname=keysIterator.next();
				
				String itemValue=ht.get(itemname);
				StringTokenizer st=new StringTokenizer(itemValue,",");
				String total=st.nextToken();
				//double totalAmount = 0;
				totalAmount = totalAmount +   Double.parseDouble(total);
				 //Integer.parseInt(total);
				String qty=st.nextToken();
				
				htmldoc.append("<tr><td>"+count+"</td><td>"+itemname+"</td><td>"+qty+"</td><td>"+total+"</td></tr>");
				smsdata.append("Item:"+itemname+"&Qty"+qty+"\n");
				++count;
			}//while
			htmldoc.append("</table>TotalAmount:"+totalAmount+"<br/>VAT+SERVICETAX:1.95<br/>NetAmount:"+(totalAmount+1.95)+"</center></html>");
	        System.out.println(htmldoc.toString());
	        wv.loadDataWithBaseURL(null,htmldoc.toString(),"text/html","UTF-8",null);
	        
		}
		else if(message1 != null){

			ht=Menu2.ht;
			
			Set<String> keys=ht.keySet();
			Iterator<String> keysIterator = keys.iterator();
			int count=1;
			
			//TODO
			while(keysIterator.hasNext())
			{
				String itemname=keysIterator.next();
				
				String itemValue=ht.get(itemname);
				StringTokenizer st=new StringTokenizer(itemValue,",");
				String total=st.nextToken();
				//double totalAmount = 0;
				  totalAmount = totalAmount + Double.parseDouble(total);
				String qty=st.nextToken();
				
				htmldoc.append("<tr><td>"+count+"</td><td>"+itemname+"</td><td>"+qty+"</td><td>"+total+"</td></tr>");
				smsdata.append("Item:"+itemname+"&Qty"+qty+"\n");
				++count;
				
			}//while
			htmldoc.append("</table>TotalAmount:"+totalAmount+"<br/>VAT+SERVICETAX:1.95<br/>NetAmount:"+(totalAmount+1.95)+"</center></html>");
	        System.out.println(htmldoc.toString());
	        wv.loadDataWithBaseURL(null,htmldoc.toString(),"text/html","UTF-8",null);
		}
		if(message2!=null)
		{
			ht=Menu3.ht;
			Set<String> keys=ht.keySet();
			Iterator<String> keysIterator = keys.iterator();
			int count=1;
			
			//TODO
			while(keysIterator.hasNext())
			{
				String itemname=keysIterator.next();
				
				String itemValue=ht.get(itemname);
				StringTokenizer st=new StringTokenizer(itemValue,",");
				String total=st.nextToken();
				//double totalAmount = 0;
				totalAmount = totalAmount + Double.parseDouble(total);
				String qty=st.nextToken();
				
				htmldoc.append("<tr><td>"+count+"</td><td>"+itemname+"</td><td>"+qty+"</td><td>"+total+"</td></tr>");
				smsdata.append("Item:"+itemname+"&Qty"+qty+"\n");
				++count;
			}//while
			htmldoc.append("</table>TotalAmount:"+totalAmount+"<br/>VAT+SERVICETAX:1.95<br/>NetAmount:"+(totalAmount+1.95)+"</center></html>");
	        System.out.println(htmldoc.toString());
	        wv.loadDataWithBaseURL(null,htmldoc.toString(),"text/html","UTF-8",null);
	        
		}
		//order1.append(message1);
		
		//menu.setText(order1);
		
		//wv.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl)
		order.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String adrs=address.getText().toString();
				String mob=mobile.getText().toString();
		        		
				if(!(adrs.equals("")))
				{
					orderId.append(adrs);
					orderId.append(mob);
					String orderIdStr=orderId.toString();
					Toast.makeText(getApplicationContext(), ""+orderIdStr, 1000).show();
					Admin_Main.ordersMap.put(orderIdStr, new HashMap<String, String>(ht));
				   int length=orderId.length();
				   orderId.delete(0, length);
				   
					try
					{
						SmsManager sms= SmsManager.getDefault();
						Intent i1=new Intent(getApplicationContext(),AcknowledgeService.class);
					   System.out.println("Mobileno recieved:"+mob);
						Main.mobileno=mob;
						smsdata.append("CustomerNo:"+Main.mobileno+"\n");
						PendingIntent pi= PendingIntent.getService(getApplicationContext(),0,i1,0);
						sms.sendTextMessage(phno, null,smsdata.toString(), pi,pi);
						
						Toast.makeText(getApplicationContext(), "ORDER Sent!", Toast.LENGTH_LONG).show();
					}
					catch (Exception e)
					{
						Toast.makeText(getApplicationContext(), "ORDER failed,please try again!", Toast.LENGTH_LONG).show();
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Enter Address Field", 1000).show();
							
				}
				finish();
			}
		});
		
		
		
        
	}
	}
}
