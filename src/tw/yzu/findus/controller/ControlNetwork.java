package tw.yzu.findus.controller;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;



public class ControlNetwork {
	
	public String FacebookAccessToken = null;
	private MainService mService;
	private boolean UserLogin = false;
	private HandlerThread mNetworkThread;
	private Handler mNetworkHandler;
	
	  public ControlNetwork(MainService service) {
		// TODO Auto-generated constructor stub
		  mService = service;
		  mNetworkThread = new HandlerThread( "Network" );
		  mNetworkThread.start();
		  mNetworkHandler = new Handler( mNetworkThread.getLooper() );
	}

	public boolean IsLogin() {
		    return UserLogin;
		  }

	public void LoginWithFB(String accessToken) {
		// TODO Auto-generated method stub
		if (accessToken == null)
		      return;
		    FacebookAccessToken = accessToken;
//		    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//		    builder.addTextBody( "type", "facebook" );
//		    builder.addTextBody( "accessToken", accessToken );
//		    mNetworkHandler.post( new NodeUrl( UrlUserLogin, builder.build(), generalCallback ) );
//		    mNetworkHandler.post( new Runnable() {
//		      @Override
//		      public void run() {
//		        if (IsLogin()) {
//		          mService.mActivity.ShowMain();
//		        }
//		      }
//		    } );
		    Log.i("login","login");
		    mService.mActivity.ShowMain();
		
	}

}
