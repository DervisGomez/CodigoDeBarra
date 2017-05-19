package com.app.codigodebarra;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.os.Bundle;
import android.app.Fragment;
import android.graphics.Color;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Fragment_III extends Fragment {
	
	View rootView;
	boolean cargar=true;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.fm_iii, container, false);
				
			String dato = getArguments().getString("caract");
			init(dato);
				
		return rootView;
	}
	
	public void init(String datos) {
		int width = rootView.getWidth();
		int desc=(int)((width-24)*(60/100));
		int cara=(int)((width-24)*(40/100));
        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_main);
        
        TableRow tbrow01 = new TableRow(rootView.getContext());
        
        TextView tv005 = new TextView(rootView.getContext());
        tv005.setHeight(4);
        tbrow01.addView(tv005);
        stk.addView(tbrow01);
        
        TableRow tbrow0 = new TableRow(rootView.getContext());
        
        TextView tv00 = new TextView(rootView.getContext());
        tv00.setWidth(4);
        tbrow0.addView(tv00);
        
        TextView tv0 = new TextView(rootView.getContext());
        tv0.setText("CARACTERISTICA ");
        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackgroundResource(R.color.azul_3);
        tv0.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv0);
        
        TextView tv01 = new TextView(rootView.getContext());
        tv01.setWidth(4);
        tbrow0.addView(tv01);
        
        TextView tv1 = new TextView(rootView.getContext());
        tv1.setText("DESCRIPCION");
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.color.azul_3);
        tv1.setPadding(8, 8, 8, 8);
        tbrow0.addView(tv1);
        stk.addView(tbrow0);
        
        TextView tv11 = new TextView(rootView.getContext());
        tv11.setWidth(4);
        tbrow0.addView(tv11);
        
        TableRow tbrow02 = new TableRow(rootView.getContext());
        
        TextView tv011 = new TextView(rootView.getContext());
        tv011.setHeight(4);
        tbrow02.addView(tv011);
        stk.addView(tbrow02);
        
        JsonParser parser = new JsonParser();
 		Object obje = parser.parse(datos);
 		JsonArray array=(JsonArray)obje;
 		if(!array.isJsonNull()){
 			for (int x=0;x<array.size();x++){
 				JsonObject objO=array.get(x).getAsJsonObject();
 				TableRow tbrow=new TableRow(rootView.getContext());
 				TextView t01v = new TextView(rootView.getContext());
 		        tbrow.addView(t01v);
 				if (!(objO.get("CARANOMBRE").isJsonNull())) {
 					TextView t1v = new TextView(rootView.getContext());
 		            t1v.setText(objO.get("CARANOMBRE").getAsString());
 		            t1v.setTextColor(Color.WHITE);
 		            t1v.setGravity(Gravity.CENTER);
 		            t1v.setBackgroundResource(R.color.verde_2);
 		            t1v.setPadding(4, 4, 4, 4);
 		            t1v.setWidth(cara);
 		            tbrow.addView(t1v);
 				}
 				TextView t11v = new TextView(rootView.getContext());
 		        tbrow.addView(t11v);
 				if (!(objO.get("CARADESC").isJsonNull())) {
 					TextView t2v = new TextView(rootView.getContext());
 		            t2v.setText(objO.get("CARADESC").getAsString());
 		            t2v.setTextColor(Color.WHITE);
 		            t2v.setGravity(Gravity.CENTER);
 		            t2v.setBackgroundResource(R.color.verde_2);
 		            t2v.setPadding(4, 4, 4, 4);
 		            t2v.setWidth(cara);
 		            tbrow.addView(t2v); 
 				}
 				TextView t21v = new TextView(rootView.getContext());
 		        tbrow.addView(t21v);
 		       stk.addView(tbrow);
 		       TableRow tbrow021 = new TableRow(rootView.getContext());
 		        
 		        TextView tv0111 = new TextView(rootView.getContext());
 		        tv0111.setHeight(4);
 		        tbrow021.addView(tv0111);
 				stk.addView(tbrow021);
 			}
 		}

    }
	
	
}