package tw.yzu.findus.controller;



import tw.yzu.findus.view.ActivityLogin;
import tw.yzu.findus.view.ActivityMain;
import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;

public class ControlActivity {
	
	private MainService mService;
	private Activity mFGActivity;
	
	public ControlActivity(MainService service) {
	    mService = service;
	}

	public void ChangeActivity(Activity activity) {
	    mFGActivity = activity;
	}

	public void CleanActivity() {
	  if (mFGActivity != null) {
	    mFGActivity.finish();
	    mFGActivity = null;
	  }

	}
	
	public void ShowMain() {
	    CleanActivity();
	    Intent i = new Intent();
	    i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
	    i.setClass( mService, ActivityMain.class );
	    mService.startActivity( i );
	  }

	  public void ShowLogin() {
	    CleanActivity();
	    Intent i = new Intent();
	    i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
	    i.setClass( mService, ActivityLogin.class );
	    mService.startActivity( i );
	  }

	  public void ShowSystemConfigGPS() {
	    Intent i = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS );
	    i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
	    mService.startActivity( i );
	  }

}
