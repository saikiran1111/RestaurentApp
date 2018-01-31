package hometutorial.nit.com.restaurentapp.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import hometutorial.nit.com.restaurentapp.R;

public class Menu1 extends Main{
	
	CheckBox naan,bhajji,pakora,thali,paratha;
	EditText ep,eb,ev,em,evb;
	Button proceed;
	String naan1,bhajji1,pakora1,thali1,paratha1;
	
	int naan2=0,bhajji2=0,pakora2=0,thali2=0,paratha2=0;
	static double totalamount=0;
	static Map<String,String> ht=new HashMap<String, String>();
	
		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu1);
	        
	       naan=(CheckBox)findViewById(R.id.CheckBox3);
	        bhajji=(CheckBox)findViewById(R.id.CheckBox1);
	        pakora=(CheckBox)findViewById(R.id.CheckBox2);
	        thali=(CheckBox)findViewById(R.id.CheckBox5);
	        paratha=(CheckBox)findViewById(R.id.CheckBox4);
	        ep=(EditText)findViewById(R.id.EditText1);
	        eb=(EditText)findViewById(R.id.EditText5);
	        ev=(EditText)findViewById(R.id.EditText4);
	        em=(EditText)findViewById(R.id.EditText3);
	        evb=(EditText)findViewById(R.id.EditText2);
	        
	        proceed=(Button)findViewById(R.id.button1);
	    	
	        proceed.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					ht.clear();
					
					naan1=ep.getText().toString();
					bhajji1=eb.getText().toString();
					pakora1=ev.getText().toString();
					thali1=em.getText().toString();
					paratha1=evb.getText().toString();
					
			if(!(naan1.equals("")))
				naan2= Integer.parseInt(naan1);
			if(!(bhajji1.equals("")))
				bhajji2= Integer.parseInt(bhajji1);
			if(!(pakora1.equals("")))
				pakora2= Integer.parseInt(pakora1);
			if(!(thali1.equals("")))
				thali2= Integer.parseInt(thali1);
			if(!(paratha1.equals("")))
				paratha2= Integer.parseInt(paratha1);
			
			
			StringBuilder res=new StringBuilder();
			res.append("selected items : \n");
			if(naan.isChecked())
			{
				double total=1.95*naan2;
				totalamount+=total;
				res.append("naan $1.95 * "+naan2+"="+total+"\n");
				ht.put("naan",""+total+","+naan2);
				
			}
			if(bhajji.isChecked())
			{
				double total=3.95*bhajji2;
				totalamount+=total;
				res.append("bhajji $3.95 * "+bhajji2+"="+total+"\n");
				ht.put("bhajji",""+total+","+bhajji2);
			}
			if(pakora.isChecked())
			{
				
				double total=4.95*pakora2;
				totalamount+=total;
				res.append("pakora $4.95 * "+pakora2+"="+total+"\n");
				ht.put("pakora",""+total+","+pakora2);
			}
			if(thali.isChecked())
			{
				
				double total=18.95*thali2;
				totalamount+=total;
				ht.put("thali",""+total+","+thali2);
				res.append("thali $8.95 * "+thali2+"="+total+"\n");
			}
			if(paratha.isChecked())
			{
				
				double total=2.50*paratha2;
				totalamount+=total;
				ht.put("paratha",""+total+","+paratha2);
				res.append("paratha $2.50 * "+paratha2+"="+total+"\n");
			}
			res.append("VAT:---->1.95");

			res.append("\n totalamount is : $"+(totalamount+1.95));
			
			
			
			String result=res.toString();
			Intent i=new Intent(Menu1.this,Verify.class);
			i.putExtra("veg",result);
			startActivity(i);
			}
			});
	}
	}
