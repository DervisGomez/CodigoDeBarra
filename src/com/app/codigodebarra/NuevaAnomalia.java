package com.app.codigodebarra;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class NuevaAnomalia extends Activity implements OnClickListener{
	private Button btnRegresar;
	private Button btnGuardar;
	private Spinner spPrioridad;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nueva_anomalia);
		btnRegresar=(Button)findViewById(R.id.btnRegresar);
		btnGuardar=(Button)findViewById(R.id.btnGuardar);
		btnRegresar.setOnClickListener(this);
		btnGuardar.setOnClickListener(this);
		spPrioridad=(Spinner)findViewById(R.id.spPrioridad);
		String[] stringCN={"ALTA","MEDIA","BAJA"};
		ActionBar actionBar= getActionBar();
		actionBar.hide();
		ArrayAdapter<String> spFormatoAdaptener=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,stringCN);
		spPrioridad.setAdapter(spFormatoAdaptener);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnRegresar:
			finish();
			break;
		case R.id.btnGuardar:
			finish();
			break;		
		}
		
	}

}