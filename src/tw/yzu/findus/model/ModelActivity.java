package tw.yzu.findus.model;



import tw.yzu.findus.controller.ControlNetwork;
import tw.yzu.findus.controller.MainService;
import tw.yzu.findus.controller.MainService.ServiceBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public abstract class ModelActivity extends Activity{
	public MainService mService;
	protected ControlNetwork mNetwork;
	
	protected abstract void onServiceConnected();

	protected abstract void onServiceDisconnected();
	
	
	@Override
	  protected void onStart() {
	    super.onStart();
	    MainService.Bind( this, conn );
	  }

	  @Override
	  protected void onStop() {
	    super.onStop();
	    MainService.UnBind( this, conn );
	  }
	  private ServiceConnection conn = new ServiceConnection() {

		    @Override
		    public void onServiceDisconnected(ComponentName name) {
		      mService = null;
		      mNetwork = null;
		      ModelActivity.this.onServiceDisconnected();
		    }

		    @Override
		    public void onServiceConnected(ComponentName name, IBinder service) {
		      ServiceBinder binder = (ServiceBinder) service;
		      binder.ChangeActivity( ModelActivity.this );
		      mService = binder.GetService();
		      mNetwork = mService.mNetwork;
		      Log.i("connect","conn");
		      ModelActivity.this.onServiceConnected();
		    }
		  };

}
