package hometutorial.nit.com.restaurentapp.restaurant;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;

import hometutorial.nit.com.restaurentapp.R;

public class AcknowledgeService extends Service {

	public AcknowledgeService()
	{
		System.out.println("Acknowledgeservice object is created");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("in onstartCommand");
		SmsManager sm=SmsManager.getDefault();


		NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notify=new Notification(R.drawable.ic_launcher,"Order Recieved Successfully:",System.currentTimeMillis());
		PendingIntent pending= PendingIntent.getActivity(getApplicationContext(), 0, new Intent(), 0);

	//	notify.setLatestEventInfo(getApplicationContext(),"OnlineRestaurantSystem","OrderRecieved From:"+Main.mobileno,pending); //cannot resolve 'setLatestEventInfo' method
		notif.notify(0, notify);

		sm.sendTextMessage(Main.mobileno,null,"OrderRecieved",null,null);
		return super.onStartCommand(intent, flags, startId);
	}

	/*//=====================

	System.out.println("In service...."+Main.mobileno);
		Notification n1=new Notification(R.drawable.ic_launcher,"Order Recieved Successfully:", System.currentTimeMillis());
		n1.setLatestEventInfo(getApplicationContext(),"OnlineRestaurantSystem","OrderRecieved From:"+Main.mobileno,null);
		NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		nm.notify(1,n1);
		//sm.sendTextMessage(Main.mobileno,null,"OrderRecieved",null,null);
		return super.onStartCommand(intent, flags, startId);
	}*/

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}

