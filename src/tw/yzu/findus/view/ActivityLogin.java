package tw.yzu.findus.view;

import java.util.Arrays;

import com.facebook.Session;
import com.facebook.SessionState;



import tw.yzu.findus.R;
import tw.yzu.findus.model.ModelActivity;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ActivityLogin extends ModelActivity {
	
	private Session.OpenRequest mFBRequest;
	private Session mFBSession;
	Handler handler = new Handler();
	private LoginMode mLoginMode;

	private enum LoginMode {
	  FACEBOOK, PERSONAL
	};
	
	private void RequestFB() {
	    mFBSession = Session.getActiveSession();
	    if (mFBSession == null || mFBSession.isClosed()) {
	      mFBSession = new Session( ActivityLogin.this );
	    }
	    mFBRequest = new Session.OpenRequest( ActivityLogin.this );
	    mFBRequest.setPermissions( Arrays.asList( "public_profile", "user_friends", "email", "user_likes", "friends_birthday",
	        "friends_about_me" ) );
	    Log.i("aa","aa");
	    mFBRequest.setCallback( new FacebookCallback() );
	    mFBSession.openForRead( mFBRequest );
	  }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		ImageButton mFBButton = (ImageButton) findViewById( R.id.Login_Fb );
	    mFBButton.setOnClickListener( new OnClickListener() {
	      @Override
	      public void onClick(View v) {
	        // FB登入
	        mLoginMode = LoginMode.FACEBOOK;
	        RequestFB();
	      }
	    } );
	}
	
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged( newConfig );
	  }
	
	@Override
	  protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState( outState );
	    Session session = Session.getActiveSession();
	    Session.saveSession( session, outState );
	  }
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult( requestCode, resultCode, data );
	    if (mLoginMode == LoginMode.FACEBOOK)
	      mFBSession.onActivityResult( this, requestCode, resultCode, data );
	}

	private class FacebookCallback implements Session.StatusCallback {

		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			// TODO Auto-generated method stub
			Log.i("aenter",""+session.isOpened());
			if (session.isOpened()) {
				Log.i("enter",session.getAccessToken());
		        if (mLoginMode == LoginMode.FACEBOOK);
		          mNetwork.LoginWithFB( session.getAccessToken() );

		      }
			
		}
	  }
	

	@Override
	protected void onServiceConnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onServiceDisconnected() {
		// TODO Auto-generated method stub
		
	}

}
