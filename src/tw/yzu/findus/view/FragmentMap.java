package tw.yzu.findus.view;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.yzu.findus.R;
import tw.yzu.findus.view.ActivityMain.DetailFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

@SuppressLint("ValidFragment")
public class FragmentMap extends DetailFragment{
	
	private View mView;
	private GoogleMap mMap;
	
	@SuppressLint("ValidFragment")
	public FragmentMap(ActivityMain activity) {
		super( activity );
		// TODO Auto-generated constructor stub
	}
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    if (mView != null) {
	      ViewGroup parent = (ViewGroup) mView.getParent();
	      if (parent != null)
	        parent.removeView( mView );
	    }
	    try {
	      mView = inflater.inflate( R.layout.map, container, false );
	    } catch (InflateException e) {
	      /* map is already there, just return view as it is */
	    }
	    return mView;
	  }
	public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated( savedInstanceState );
	    LayoutInflater.from( mActivity );
	    
	    mMap = ( (MapFragment) getFragmentManager().findFragmentById( R.id.Map_Map ) ).getMap();
	    mMap.setMyLocationEnabled( true );
	}

}
