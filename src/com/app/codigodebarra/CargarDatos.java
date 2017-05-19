package com.app.codigodebarra;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class CargarDatos extends Activity implements OnClickListener{
	private TabHost tabs;
	private Button btnNuevaAnomalia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cargar_datos);
		tabs=(TabHost)findViewById(android.R.id.tabhost);
		btnNuevaAnomalia=(Button)findViewById(R.id.btnNuevaAnomalia);
		btnNuevaAnomalia.setOnClickListener(this);
		tabs.setup();
		iniciarTabs();
		init();
		init2();
		Bundle bolsa=getIntent().getExtras();
		String contenido =bolsa.getString("contenido");
		String formato =bolsa.getString("formato");
		Toast t=Toast.makeText(this, contenido+" - "+formato, Toast.LENGTH_LONG);
		t.show();
		
		tabs.setOnTabChangedListener(new OnTabChangeListener() {
		    @Override
		    public void onTabChanged(String tabId) {
		    	switch (Integer.valueOf(tabId)){
		    	case 1:
		    		
		    		break;
		    	case 2:
		    		break;
		    	case 3:
		    		break;
		    	case 4:
		    		break;
		    	}
		    }
		});
	}
	
	public void iniciarTabs(){
		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		if(height<width){
			width=height;
		}
		String[] pestana=new String[4];
		if (width<400){
			pestana[0]="Datos\nBásicos";
			pestana[1]="Otros\nDatos";
			pestana[2]="Características";
			pestana[3]="Anomalías";
		}else{
			pestana[0]="Datos\nBásicos";
			pestana[1]="Otros\nDatos";
			pestana[2]="Características";
			pestana[3]="Anomalías";
		}
		TabHost.TabSpec spec=tabs.newTabSpec("1");
		spec.setContent(R.id.tab1);
		spec.setIndicator(pestana[0],null);
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("2");
		spec.setContent(R.id.tab2);
		spec.setIndicator(pestana[1],null);
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("3");
		spec.setContent(R.id.tab3);
		spec.setIndicator(pestana[2],null);
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("4");
		spec.setContent(R.id.tab4);
		spec.setIndicator(pestana[3],null);
		tabs.addTab(spec);
		 
		tabs.setCurrentTab(0);
	}
	
	public void init2() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main2);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" TIPO ");
       
        tv0.setTextColor(Color.WHITE);
        tv0.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" DESCRIPCION ");
        tv1.setTextColor(Color.WHITE);
        tv1.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" VALORACIÓN ");
        tv2.setTextColor(Color.WHITE);
        tv2.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv2);
        stk.addView(tbrow0);
        for (int i = 1; i < 11; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText("Tipo " + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            t1v.setPadding(4, 4, 4, 4);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText("Descripcion " + i);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            t2v.setPadding(4, 4, 4, 4);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText("Valoracion " + i);
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            t3v.setPadding(4, 4, 4, 4);
            tbrow.addView(t3v);
            stk.addView(tbrow);
        }

    }
	
	public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" CARACTERISTICA ");
        tv0.setTextColor(Color.WHITE);
        tv0.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" DESCRIPCION ");
        tv1.setTextColor(Color.WHITE);
        tv1.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv1);
        stk.addView(tbrow0);
        for (int i = 1; i < 11; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText("Equipo " + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            t1v.setPadding(4, 4, 4, 4);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText("Descripcion " + i);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            t2v.setPadding(4, 4, 4, 4);
            tbrow.addView(t2v);
            stk.addView(tbrow);
        }

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
