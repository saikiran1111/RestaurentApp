package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Activity;
import android.content.Intent;

public class MenuUtility {
	public static void logout(Activity activity)
	{
		Intent intent = new Intent(activity,LoginReg.class);
		activity.startActivity(intent);
	}
}
