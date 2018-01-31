package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import hometutorial.nit.com.restaurentapp.R;

public class Choice extends Activity implements OnClickListener {
	
	RadioGroup rg;
	RadioButton veg,nonveg,desert;
	Boolean checked;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        rg=(RadioGroup)findViewById(R.id.rg1);
        rg.clearCheck();
        veg=(RadioButton)findViewById(R.id.rb1);
        nonveg=(RadioButton)findViewById(R.id.rb2);
        desert=(RadioButton)findViewById(R.id.rb3);
        
        veg.setOnClickListener(this);
        nonveg.setOnClickListener(this);
        desert.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		checked=((RadioButton)v).isEnabled();
		switch(v.getId()){
		case R.id.rb1:
			if(checked){
				
			Intent i=new Intent(Choice.this,Menu1.class);
			startActivity(i);
		}
			break;
		case R.id.rb2:
			if(checked){
		        
			Intent i1=new Intent(Choice.this,Menu2.class);
			startActivity(i1);
		}
			break;
			
		case R.id.rb3:
			if(checked){
				
			Intent i2=new Intent(Choice.this,Menu3.class);
			startActivity(i2);
		}
			break;	
			
		}
		
	}
}
