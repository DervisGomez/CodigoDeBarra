package com.app.codigodebarra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tabs extends Activity implements ActionBar.TabListener,OnClickListener {
	private EditText etTipoEquipo; 
	private static String datos;
	private static String caract;
	private static String familia;
	private static String anomalia;
	private static int control;
	private Button btnNuevaAnomalia;
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);
//		btnNuevaAnomalia=(Button)findViewById(R.id.btnNuevaAnomalia);
//		btnNuevaAnomalia.setOnClickListener(this);
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowCustomEnabled(false);
		control=0;
		new MiTarea("http://pruebas.akc.co:8089/api/servlet/datamap/APP_INV_DATOSBASICOS/null","1").execute();
		
		
	}
	public void iniciar(String dato){
		this.anomalia=dato;
		// Set up the action bar.
				final ActionBar actionBar = getActionBar();
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				actionBar.setDisplayShowTitleEnabled(false);
				actionBar.setDisplayShowHomeEnabled(false);
				actionBar.setDisplayShowCustomEnabled(false);
				// Create the adapter that will return a fragment for each of the three
				// primary sections of the activity.
				mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
				
				// Set up the ViewPager with the sections adapter.
				mViewPager = (ViewPager) findViewById(R.id.pager);
				
				mViewPager.setAdapter(mSectionsPagerAdapter);

				// When swiping between different sections, select the corresponding
				// tab. We can also use ActionBar.Tab#select() to do this if we have
				// a reference to the Tab.
				mViewPager
						.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
							@Override
							public void onPageSelected(int position) {
								actionBar.setSelectedNavigationItem(position);
							}
						});

				// For each of the sections in the app, add a tab to the action bar.
				for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
					// Create a tab with text corresponding to the page title defined by
					// the adapter. Also specify this Activity object, which implements
					// the TabListener interface, as the callback (listener) for when
					// this tab is selected.
					actionBar.addTab(actionBar.newTab()
							.setText(mSectionsPagerAdapter.getPageTitle(i))
							.setTabListener(this));
				}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 5;
		}

		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);
			}
			
			return null;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static Fragment newInstance(int sectionNumber) {
			
			Fragment fra=null;
			switch (sectionNumber) {
            case 1:
                fra= new Fragment_I();
                break;
            case 2:
                fra= new Fragment_II();
                break;
            case 3:
                fra= new Fragment_III();
                break;
            case 4:
                fra= new Fragment_IV();
                break;
            case 5:
                fra= new Fragment_V();
                break;
		}
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			args.putString("datos", datos);
			args.putString("caract", caract);
			args.putString("familia", familia);
			args.putString("anomalia", anomalia);
			fra.setArguments(args);
			return fra;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	private class MiTarea extends AsyncTask<String, Float, String>{
		 private String ur;
		 
		 public MiTarea(String url,String x){
			 this.ur=url;
			 
		 }
	  protected void onPreExecute() {

	   }

	   protected String doInBackground(String... urls) {
	  	 String responce = "";
	       BufferedReader rd = null;
	       try {
	           URL url = new URL(ur);
	           rd = new BufferedReader(new InputStreamReader(url.openStream()));
	           String line;
	           while ((line = rd.readLine()) != null) {
	               responce += line;
	           }

	       } catch (Exception e) {
	       } finally {
	           if (rd != null) {
	               try {
	                   rd.close();
	               } catch (IOException ex) {
	               }
	           }
	       }
	       return responce;
	   }

	   protected void onProgressUpdate (Float... valores) {

	   }

	   protected void onPostExecute(String tiraJson) {
		   switch (control){
		   case 0:
			   control++;
			   cargarDatos(tiraJson);
			   break;
		   case 1:
			   control++;
			   cargarCaracteristicas(tiraJson);
			   break;
		   case 2:
			   control++;
			   cargarFamilia(tiraJson);
			   break;
		   case 3:
			   control++;
			   iniciar(tiraJson);
			   break;
		   }
	   	
	   }
	}
	public void cargarDatos(String datos){
		this.datos=datos;
		new MiTarea("http://pruebas.akc.co:8089/api/servlet/datamap/APP_INV_CARACTERISTICAS/null","1").execute();
	}
	public void cargarCaracteristicas(String caract){
		this.caract=caract;
		new MiTarea("http://pruebas.akc.co:8089/api/servlet/datamap/APP_INV_FAMILIA/null","1").execute();
	}
	public void cargarFamilia(String familia){
		this.familia=familia;
		new MiTarea("http://pruebas.akc.co:8089/api/servlet/datamap/APP_INV_ANOMALIAS/null","1").execute();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btnNuevaAnomalia:
			Intent intent = new Intent("com.app.codigodebarra.NuevaAnomalia");
			startActivityForResult(intent, 0);
			break;
		}
	}
	

}

