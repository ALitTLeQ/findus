package tw.yzu.findus.view;



import tw.yzu.findus.R;
import tw.yzu.findus.controller.MainService;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;

public class ActivityLoading extends Activity{
	Handler mHandler;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate( savedInstanceState );
	    requestWindowFeature( Window.FEATURE_NO_TITLE );
	    setContentView( R.layout.loading );
	    mHandler = new Handler( this.getMainLooper() );
	  }
	  
	  @Override
	  protected void onResume() {
	    super.onResume();
	    mHandler.postDelayed( StartService, 1000 );
	  }
	  
	  Runnable StartService = new Runnable() {
		    @Override
		    public void run() {
		      Intent i = new Intent( ActivityLoading.this, MainService.class );
		      startService( i );
//		      SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences( ActivityLoading.this );
//		      if (mPrefs.getBoolean( "firstrun", true )) {
//		        SharedPreferences.Editor editor = mPrefs.edit();
//		        editor.putBoolean( "firstrun", false );
//		        editor.commit();
//		        i = new Intent( ActivityLoading.this, ActivityMain.class );// app介紹
//		      } else {
//		        i = new Intent( ActivityLoading.this, ActivityMain.class );// 正式
//		      }
		      i = new Intent( ActivityLoading.this, ActivityLogin.class );
		      i.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
		      startActivity( i );
		      finish();
		    }

		  };

}
