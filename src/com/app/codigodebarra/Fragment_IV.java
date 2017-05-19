package com.app.codigodebarra;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.os.Bundle;
import android.app.Fragment;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Fragment_IV extends Fragment {
	
	View rootView;
	int uno = 0;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.fm_iv, container, false);
		String dato = getArguments().getString("familia");
		init(dato);
		return rootView;
	}
	
	public void init(String datos) {
		int width = rootView.getWidth();
		int desc=(int)((width-40)*(25/100));
		TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_main2);
		
		TableRow tbrow01 = new TableRow(rootView.getContext());
		TextView tv001 = new TextView(rootView.getContext());
        tv001.setHeight(4);
        tbrow01.addView(tv001);
        stk.addView(tbrow01);		
		
		TableRow tbrow0 = new TableRow(rootView.getContext());
        TextView tv00 = new TextView(rootView.getContext());
        tv00.setWidth(4);
        tbrow0.addView(tv00);
        
        TextView tv0 = new TextView(rootView.getContext());
        tv0.setText("EQUIPO");
        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackgroundResource(R.color.azul_3);
        tv0.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv0);
        
        TextView tv01 = new TextView(rootView.getContext());
        tv01.setWidth(4);
        tbrow0.addView(tv01);
        
        TextView tv1 = new TextView(rootView.getContext());
        tv1.setText("TIPO");
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.color.azul_3);
        tv1.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv1);
        
        TextView tv02 = new TextView(rootView.getContext());
        tv02.setWidth(4);
        tbrow0.addView(tv02);
        
        TextView tv2 = new TextView(rootView.getContext());
        tv2.setText("MARCA");
        tv2.setTextColor(Color.BLACK);
        tv2.setGravity(Gravity.CENTER);
        tv2.setBackgroundResource(R.color.azul_3);
        tv2.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv2);
        
        TextView tv03 = new TextView(rootView.getContext());
        tv03.setWidth(4);
        tbrow0.addView(tv03);
        
        TextView tv3 = new TextView(rootView.getContext());
        tv3.setText("MODELO");
        tv3.setTextColor(Color.BLACK);
        tv3.setGravity(Gravity.CENTER);
        tv3.setBackgroundResource(R.color.azul_3);
        tv3.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv3);
        
        TextView tv04 = new TextView(rootView.getContext());
        tv04.setWidth(4);
        tbrow0.addView(tv04);
        
        stk.addView(tbrow0);
        
        TableRow tbrow011 = new TableRow(rootView.getContext());
		TextView tv0011 = new TextView(rootView.getContext());
        tv0011.setHeight(4);
        tbrow011.addView(tv0011);
        stk.addView(tbrow011);
        
        JsonParser parser = new JsonParser();
 		Object obje = parser.parse(datos);
 		JsonArray array=(JsonArray)obje;
 		if(!array.isJsonNull()){
 			for (int x=0;x<array.size();x++){
 				JsonObject objO=array.get(x).getAsJsonObject();
 				
 				TableRow tbrow=new TableRow(rootView.getContext());
 		        TextView tv000 = new TextView(rootView.getContext());
 		        tv000.setWidth(4);
 		        tbrow.addView(tv000);
 		        
 				if (!(objO.get("FAMINOMBRE").isJsonNull())) {
 					TextView t1v = new TextView(rootView.getContext());
 		            t1v.setText(objO.get("FAMINOMBRE").getAsString());
 		            t1v.setTextColor(Color.WHITE);
 		            t1v.setGravity(Gravity.CENTER);
 		            t1v.setBackgroundResource(R.color.verde_2);
 		            t1v.setPadding(8, 4, 4, 4);
 		            t1v.setWidth(desc);
 		            tbrow.addView(t1v);
 				}
 				
 				TextView tv011 = new TextView(rootView.getContext());
 		        tv011.setWidth(4);
 		        tbrow.addView(tv011);
 		        
 				if (!(objO.get("FAMITIPO").isJsonNull())) {
 					TextView t2v = new TextView(rootView.getContext());
 		            t2v.setText(objO.get("FAMITIPO").getAsString());
 		            t2v.setTextColor(Color.WHITE);
 		            t2v.setGravity(Gravity.CENTER);
 		            t2v.setBackgroundResource(R.color.verde_2);
 		            t2v.setPadding(4, 4, 4, 4);
 		            t2v.setWidth(desc);
 		            tbrow.addView(t2v); 
 				}
 				
 				TextView tv021 = new TextView(rootView.getContext());
 		        tv021.setWidth(4);
 		        tbrow.addView(tv021);
 		        
 				if (!(objO.get("FAMIMARC").isJsonNull())) {
 					TextView t2v = new TextView(rootView.getContext());
 		            t2v.setText(objO.get("FAMIMARC").getAsString());
 		            t2v.setTextColor(Color.WHITE);
 		            t2v.setGravity(Gravity.CENTER);
 		            t2v.setBackgroundResource(R.color.verde_2);
 		            t2v.setPadding(4, 4, 4, 4);
 		            t2v.setWidth(desc);
 		            tbrow.addView(t2v); 
 				}
 				
 				TextView tv031 = new TextView(rootView.getContext());
 		        tv031.setWidth(4);
 		        tbrow.addView(tv031);
 		        
 				if (!(objO.get("FAMIMODELO").isJsonNull())) {
 					TextView t2v = new TextView(rootView.getContext());
 		            t2v.setText(objO.get("FAMIMODELO").getAsString());
 		            t2v.setTextColor(Color.WHITE);
 		            t2v.setGravity(Gravity.CENTER);
 		            t2v.setBackgroundResource(R.color.verde_2);
 		            t2v.setPadding(4, 4, 4, 8);
 		            t2v.setWidth(desc);
 		            tbrow.addView(t2v); 
 				}
 				TextView tv041 = new TextView(rootView.getContext());
 		        tv041.setWidth(4);
 		        tbrow.addView(tv041);
 				stk.addView(tbrow);
 				
 				TableRow tbrow012 = new TableRow(rootView.getContext());
 				TextView tv0012 = new TextView(rootView.getContext());
 		        tv0012.setHeight(4);
 		        tbrow012.addView(tv0012);
 		        stk.addView(tbrow012);
 			}
 		}

    }	
	
}
