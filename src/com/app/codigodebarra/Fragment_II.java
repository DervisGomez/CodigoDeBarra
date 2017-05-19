package com.app.codigodebarra;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment_II extends Fragment {
	
	View rootView;
	boolean cargar=true;
	private EditText etFactura;
	private EditText etUso;
	private EditText etCondicionEntrada;
	private EditText etVidaUtil;
	private EditText etCodificacion;
	private EditText etCriticidad;
	private EditText etUbicacion;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.fm_ii, container, false);
		
		etFactura=(EditText)rootView.findViewById(R.id.etFactura);
		etUso=(EditText)rootView.findViewById(R.id.etUso);
		etCondicionEntrada=(EditText)rootView.findViewById(R.id.etCondicionEntrada);
		etVidaUtil=(EditText)rootView.findViewById(R.id.etVidaUtil);
		etCodificacion=(EditText)rootView.findViewById(R.id.etCodificacion);
		etCriticidad=(EditText)rootView.findViewById(R.id.etCriticidad);
		etUbicacion=(EditText)rootView.findViewById(R.id.etUbicacion);
		
		if(cargar){
			cargar=false;
			String dato = getArguments().getString("datos");
			iniciar(dato);
		}
		
		return rootView;
	}
	
	public void iniciar(String datos){
		JsonParser parser = new JsonParser();
 		Object obje = parser.parse(datos);
 		JsonArray array=(JsonArray)obje;
 		if(!array.isJsonNull()){
 			for (int x=0;x<array.size();x++){
 				JsonObject objO=array.get(x).getAsJsonObject();
 				if (!(objO.get("FACTURA").isJsonNull())) {
 					etFactura.setText(objO.get("FACTURA").getAsString());
 				}if (!(objO.get("EQUIUSO").isJsonNull())) {
 					etUso.setText(objO.get("EQUIUSO").getAsString());
 				}if (!(objO.get("EQUIENTRADA").isJsonNull())) {
 					etCondicionEntrada.setText(objO.get("EQUIENTRADA").getAsString());
 				}if (!(objO.get("EQUIANOSVIDAUTIL").isJsonNull())) {
 					etVidaUtil.setText(objO.get("EQUIANOSVIDAUTIL").getAsString());
 				}if (!(objO.get("EQUICODIFICACION").isJsonNull())) {
 					etCodificacion.setText(objO.get("EQUICODIFICACION").getAsString());
 				}if (!(objO.get("EQUICRITICIDAD").isJsonNull())) {
 					etCriticidad.setText(objO.get("EQUICRITICIDAD").getAsString());
 				}if (!(objO.get("EQUIUBICACION").isJsonNull())) {
 					etUbicacion.setText(objO.get("EQUIUBICACION").getAsString());
 				}
 				
 			}
 		}
	}
}