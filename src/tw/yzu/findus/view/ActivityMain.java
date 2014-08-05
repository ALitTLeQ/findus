package tw.yzu.findus.view;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;



import tw.yzu.findus.R;
import tw.yzu.findus.controller.ControlNetwork;
import tw.yzu.findus.controller.MainService;
import tw.yzu.findus.model.ModelActivity;

@SuppressLint({ "ValidFragment", "NewApi" })
public class ActivityMain extends ModelActivity{
	
	private DetailFragment mOpenFragment;
	private ImageButton mBMap;
	  private ImageButton mBSetting;
	  private ImageButton mBTeam;
	  private FragmentMap mMap;
	  
	  protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate( savedInstanceState );
		    requestWindowFeature( Window.FEATURE_NO_TITLE );
		    setContentView( R.layout.main );
		    mBMap = (ImageButton) findViewById( R.id.Main_BMap );
		    mBMap.setOnClickListener( new OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        ChangeFragment( mMap );
		      }
		    });
		    
		    mBTeam = (ImageButton) findViewById( R.id.Main_BTeam );
		    mBTeam.setOnClickListener( new OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        ChangeFragment( mMap );
		      }
		    });
		    
		    mBSetting = (ImageButton) findViewById( R.id.Main_BSetting );
		    mBSetting.setOnClickListener( new OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        ChangeFragment( mMap );
		      }
		    });

	  }

	@Override
	protected void onServiceConnected() {
		// TODO Auto-generated method stub
		if (mMap == null)
		      mMap = new FragmentMap( this );
		    ChangeFragment( mMap );
		
	}

	@Override
	protected void onServiceDisconnected() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void ChangeFragment(DetailFragment f) {
		if (mOpenFragment != null && f.getClass() == mOpenFragment.getClass())
		      return;
		 FragmentTransaction ft = getFragmentManager().beginTransaction();
		    ft.replace( R.id.Main_Frame, f );
		    ft.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_OPEN );
		    ft.addToBackStack( null );
		    ft.commit();
		    mOpenFragment = f;
		
	}
	
	
	@SuppressLint("NewApi")
	public static class DetailFragment extends Fragment {
		    protected ActivityMain mActivity;
		    protected MainService mService;
		    protected ControlNetwork mNetwork;
		   

		    @SuppressLint({ "ValidFragment", "NewApi" })
		    DetailFragment() {
		      super();
		    }

		    DetailFragment(ActivityMain activity) {
		      mActivity = activity;
		      mService = mActivity.mService;
		      mNetwork = mService.mNetwork;
		      

		    }

		    public void Refresh() {
		    }

		  }

}
