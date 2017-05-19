package com.app.codigodebarra;

import com.app.integracion.IntentIntegrator;
import com.app.integracion.IntentResult;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Button scanBtn;
	private TextView formatTxt, contentTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		scanBtn = (Button)findViewById(R.id.scan_button);
		formatTxt = (TextView)findViewById(R.id.scan_format);
		contentTxt = (TextView)findViewById(R.id.scan_content);
		scanBtn.setOnClickListener(this);
		ActionBar actionBar= getActionBar();
		actionBar.hide();
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.scan_button){
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
//			startActivity(new Intent(this, tabs.class));
//			Intent intent = new Intent("com.app.codigodebarra.tabs");
//			startActivityForResult(intent, 0);
		}
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		String contenido=intent.getStringExtra("contenido");
		String formato=intent.getStringExtra("formato");
		if (contenido != null) {
			Intent inten =new Intent("com.app.codigodebarra.tabs");
			inten.putExtra("contenido", contenido);
			inten.putExtra("formato", formato);
			setResult(RESULT_OK,inten);
			startActivityForResult(inten, 0);
			Toast toast = Toast.makeText(getApplicationContext(), 
		            contenido, Toast.LENGTH_SHORT);
		    toast.show();
		}else{
		    Toast toast = Toast.makeText(getApplicationContext(), 
		            "No scan data received!", Toast.LENGTH_SHORT);
		    toast.show();
		}
//		if (requestCode == 0) {
//	        if (resultCode == RESULT_OK) {
//	            String contenido = intent.getStringExtra("SCAN_RESULT");
//	            String formato = intent.getStringExtra("SCAN_RESULT_FORMAT");
//	            formatTxt.setText("FORMATO: " + formato);
//				contentTxt.setText("CONTENIDO: " + contenido);
//	            // Hacer algo con los datos obtenidos.
//	        }
//	        else if (resultCode == RESULT_CANCELED) {
//	            // Si se cancelo la captura.
//	        }
//	    }
	}
}
