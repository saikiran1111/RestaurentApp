package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hometutorial.nit.com.restaurentapp.R;

public class LoginReg extends Activity {
	Button btnSignIn, btnSignInUser;
	TextView btnSignUp;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_reg);

		loginDataBaseAdapter = new LoginDataBaseAdapter(this);
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		btnSignIn = (Button) findViewById(R.id.buttonSignIN);
		btnSignInUser = (Button) findViewById(R.id.buttonSignINUser);
		btnSignUp = (TextView) findViewById(R.id.buttonSignUP);

		btnSignUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intentSignUP = new Intent(getApplicationContext(), SignUPActivity.class);
				startActivity(intentSignUP);
			}
		});
		btnSignIn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), AdminLogin.class);
				startActivity(i);

			}
		});
	}

	public void signIn(View V) {
		final Dialog dialog = new Dialog(LoginReg.this);
		dialog.setContentView(R.layout.login);
		dialog.setTitle("Login");
		final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserNameToLogin);
		final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPasswordToLogin);

		Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

		btnSignIn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				String userName = editTextUserName.getText().toString();
				String password = editTextPassword.getText().toString();
				String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);
				if (password.equals(storedPassword)) {
					Toast.makeText(LoginReg.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
					dialog.dismiss();
					Intent main = new Intent(LoginReg.this, RestaurantList.class);
					startActivity(main);
				} else {
					Toast.makeText(LoginReg.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
				}
			}
		});

		dialog.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		loginDataBaseAdapter.close();
	}
	// Exit from the application
	public void exitAppMethod(){

	       Intent intent = new Intent(Intent.ACTION_MAIN);
	       intent.addCategory(Intent.CATEGORY_HOME);
	       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	       startActivity(intent);
	}

	//then you can call this method wherever you want. like

	@Override
	public void onBackPressed() {
	 exitAppMethod();
	}

}