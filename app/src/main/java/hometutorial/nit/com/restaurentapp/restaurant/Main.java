package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import hometutorial.nit.com.restaurentapp.R;

public class Main extends Activity {
	
	Button btn1;
	static String mobileno="abc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Bundle extras = getIntent().getExtras();
        if (extras == null) 
        { 
            return; 
        }
        String rname = extras.getString("name");
        int res = extras.getInt("restimage");
        
        TextView text = (TextView) findViewById(R.id.textView1);
        ImageView view = (ImageView) findViewById(R.id.imageview1);
        
        text.setText(rname);
        view.setImageResource(res);
        
        btn1=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new OnClickListener()
        		{
        	public void onClick(View V)
        	{
        		Intent i=new Intent(Main.this,Choice.class);
        		startActivity(i);
        	}
        	
        		});
    }
    }
