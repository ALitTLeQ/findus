package tw.yzu.findus.controller;






import tw.yzu.findus.model.ModelActivity;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;

public class MainService extends Service{
	private static ServiceBinder mBinder = new ServiceBinder();
	public ControlActivity mActivity;
	public ControlNetwork mNetwork;
	
	 @Override
	  public void onCreate() {
	    super.onCreate();
	    new Handler( this.getMainLooper() );
	    mNetwork = new ControlNetwork( this );
	    mActivity = new ControlActivity( this );
	 }

	@Override
	public IBinder onBind(Intent intent) {
		mBinder.mService = this;
	    return mBinder;
	}
	
	public static void Bind(Activity activity, ServiceConnection conn) {
	    Intent i = new Intent( activity, MainService.class );
	    activity.bindService( i, conn, 0 );
	  }

	  public static void UnBind(Activity activity, ServiceConnection conn) {
	    activity.unbindService( conn );
	  }
	
	public static class ServiceBinder extends Binder {
	    public MainService mService;

	    public void ChangeActivity(ModelActivity activity) {
	      mService.mActivity.ChangeActivity( activity );
	    }

	    public MainService GetService() {
	      return mService;
	    }
	}
	
	
}
