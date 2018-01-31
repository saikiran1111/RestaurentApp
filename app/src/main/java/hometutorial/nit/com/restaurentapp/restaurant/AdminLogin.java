package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hometutorial.nit.com.restaurentapp.R;

public class AdminLogin extends Activity {

	EditText username, passs;
	Button signIn;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_layout);
		username = (EditText) findViewById(R.id.editTextUserNameToLogin);
		passs = (EditText) findViewById(R.id.editTextPasswordToLogin);
		signIn = (Button) findViewById(R.id.buttonSignIn);
	
		signIn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String user = username.getText().toString();
				String pass = passs.getText().toString();
				if (user.equals("admin") && pass.equals("admin")) {
					Intent adminIntent = new Intent(getApplicationContext(), Admin_Main.class);
					startActivity(adminIntent);

				} else {
					Toast.makeText(getApplicationContext(), "Enter valid username pass", Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

}
