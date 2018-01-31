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

public class Menu3  extends Main{
	
	CheckBox kheer,kulfi,sherbet,blacktea,gulabjamun;
	EditText ep,eb,ev,em,evb;
	Button proceed;
	String kheer1,kulfi1,sherbet1,blacktea1,gulabjamun1;
	
	int kheer2=0,kulfi2=0,sherbet2=0,blacktea2=0,gulabjamun2=0;
	 static double totalamount=0;
	static Map<String,String> ht=new HashMap<String, String>();
	
		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu3);
	        
	        
	        kheer=(CheckBox)findViewById(R.id.CheckBox3);
	        kulfi=(CheckBox)findViewById(R.id.CheckBox1);
	        sherbet=(CheckBox)findViewById(R.id.CheckBox2);
	        blacktea=(CheckBox)findViewById(R.id.CheckBox5);
	        gulabjamun=(CheckBox)findViewById(R.id.CheckBox4);
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
					
					kheer1=ep.getText().toString();
					kulfi1=eb.getText().toString();
					sherbet1=ev.getText().toString();
					blacktea1=em.getText().toString();
					gulabjamun1=evb.getText().toString();
					
			if(!(kheer1.equals("")))
				kheer2= Integer.parseInt(kheer1);
			if(!(kulfi1.equals("")))
				kulfi2= Integer.parseInt(kulfi1);
			if(!(sherbet1.equals("")))
				sherbet2= Integer.parseInt(sherbet1);
			if(!(blacktea1.equals("")))
				blacktea2= Integer.parseInt(blacktea1);
			if(!(gulabjamun1.equals("")))
				gulabjamun2= Integer.parseInt(gulabjamun1);
			
			
			StringBuilder res=new StringBuilder();
			res.append("selected items : \n");
			
			if(kheer.isChecked())
			{
				double total=2.95*kheer2;
				totalamount+=total;
				res.append("kheer $2.95 * "+kheer2+"="+total+"\n");
				ht.put("Kheer",""+total+","+kheer2);
			}
			if(kulfi.isChecked())
			{
				double total=3.50*kulfi2;
				totalamount+=total;
				res.append("kulfi $3.50 * "+kulfi2+"="+total+"\n");
				ht.put("Kulfi",""+total+","+kulfi2);
			}
			if(sherbet.isChecked())
			{
				
				double total=3.50*sherbet2;
				totalamount+=total;
				res.append("sherbet $3.50 * "+sherbet2+"="+total+"\n");
				ht.put("sherbet",""+total+","+sherbet2);
			}
			if(blacktea.isChecked())
			{
				//res.append("Manchuria Rs.90->QTY:"+blacktea1+"\n");
				double total=1.50*blacktea2;
				totalamount+=total;
				ht.put("blacktea",""+total+","+blacktea2);
				res.append("blacktea $1.50 * "+blacktea2+"="+total+"\n");
			}
			if(gulabjamun.isChecked())
			{
				//res.append("VegBiryani Rs.150->QTY:"+gulabjamun+"\n");
				double total=3.25*gulabjamun2;
				totalamount+=total;
				ht.put("gulabjamun",""+total+","+gulabjamun2);
				res.append("Gulabjamun $3.25 * "+gulabjamun2+"="+total+"\n");
			}
			res.append("VAT:---->1.95");

			res.append("\n totalamount is :$"+(totalamount+1.95));
			
		
			
			String result=res.toString();
			Intent i=new Intent(Menu3.this,Verify.class);
			i.putExtra("desert",result);
			startActivity(i);
			}
					
				
			});
	        

	    	

	}
	}
