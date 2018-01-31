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

public class Menu2 extends Main{
	CheckBox chicken,soup,fish,korma,pakora;
	EditText ep,et,eb,ed,es;
	Button pr;
	String chicken1,soup1,fish1,korma1,pakora1;
	int chicken2=0,soup2=0,fish2=0,korma2=0,pakora2=0;
	static double totalamount=0;
	static Map<String,String> ht=new HashMap<String, String>();
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);
        
        chicken=(CheckBox)findViewById(R.id.CB3);
        soup=(CheckBox)findViewById(R.id.CB1);
        fish=(CheckBox)findViewById(R.id.CB2);
        korma=(CheckBox)findViewById(R.id.CB5);
        pakora=(CheckBox)findViewById(R.id.CB4);
        
        ep=(EditText)findViewById(R.id.ET1);
        et=(EditText)findViewById(R.id.ET5);
        eb=(EditText)findViewById(R.id.ET2);
        ed=(EditText)findViewById(R.id.ET);
        es=(EditText)findViewById(R.id.ET3);
        
        pr=(Button)findViewById(R.id.button1);
        pr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ht.clear();
				totalamount =0;
				chicken1=ep.getText().toString();
				soup1=et.getText().toString();
				fish1=eb.getText().toString();
				korma1=ed.getText().toString();
				pakora1=es.getText().toString();
				if(!(chicken1.equals("")))
					chicken2= Integer.parseInt(chicken1);
				if(!(soup1.equals("")))
					soup2= Integer.parseInt(soup1);
				if(!(fish1.equals("")))
					fish2= Integer.parseInt(fish1);
				if(!(korma1.equals("")))
					korma2= Integer.parseInt(korma1);
				if(!(pakora1.equals("")))
					pakora2= Integer.parseInt(pakora1);
				
				StringBuilder res=new StringBuilder();
				res.append("selected items :\n");
				if(chicken.isChecked())
				{
					double total=(5.95*chicken2);
					totalamount+=5.95*chicken2;
					res.append("chicken $5.95 * "+chicken2+"="+total+"\n");
					ht.put("chicken",""+total+","+chicken2);
				}
				if(soup.isChecked())
				{
					double total=3.5*soup2;
					totalamount+=3.95*soup2;
					res.append("soup $3.5 * "+soup2+"="+total+"\n");
				    ht.put("Soup",""+total+","+soup2);	
				}
				if(fish.isChecked())
				{
					double total=14.95*fish2;
					totalamount+=14.95*fish2;
					res.append("fish $4.95 * "+fish2+"="+total+"\n");
					ht.put("Burger",""+total+","+fish2);
				}
				if(korma.isChecked())
				{
					double total=14.95*korma2;
					totalamount+=14.95*korma2;
					res.append("korma $2.95 * "+korma2+"="+total+"\n");
					ht.put("korma",""+total+","+korma2);
				}
				if(pakora.isChecked())
				{
					double total=6.95*pakora2;
					totalamount+=6.95*pakora2;
					res.append("pakora $6.95 * "+pakora2+"="+total+"\n");
					ht.put("pakora",""+total+","+pakora2);
				}
				res.append("VAT:---->1.95");

				res.append("\n totalamount is : $."+(totalamount+1.95));
				String result=res.toString();
				Intent i=new Intent(Menu2.this,Verify.class);
				i.putExtra("nonveg", result);
				startActivity(i);
				
			}
		});
    	
}
}
