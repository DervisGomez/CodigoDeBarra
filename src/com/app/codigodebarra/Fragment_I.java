package com.app.codigodebarra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_I extends Fragment {
	
	View rootView;
	boolean cargar=true;
	private EditText etTipoEquipo;
	private EditText etEquipoPadre;
	private EditText etNombreEquipo;
	private EditText etNemonico;
	private EditText etMarca;
	private EditText etModelo;
	private EditText etSerial;
	private EditText etEstado;
	private EditText etPropietario;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.fm_i, container, false);
		
		etTipoEquipo=(EditText)rootView.findViewById(R.id.etTipoEquipo);
		etEquipoPadre=(EditText)rootView.findViewById(R.id.etEquipoPadre);
		etNombreEquipo=(EditText)rootView.findViewById(R.id.etNombreEquipo);
		etNemonico=(EditText)rootView.findViewById(R.id.etNemonico);
		etMarca=(EditText)rootView.findViewById(R.id.etMarca);
		etModelo=(EditText)rootView.findViewById(R.id.etModelo);
		etSerial=(EditText)rootView.findViewById(R.id.etSerial);
		etEstado=(EditText)rootView.findViewById(R.id.etEstado);
		etPropietario=(EditText)rootView.findViewById(R.id.etPropietario);
		
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
 				if (!(objO.get("EQUITIPO").isJsonNull())) {
 					etTipoEquipo.setText(objO.get("EQUITIPO").getAsString());
 				}if (!(objO.get("EQUIPADRE").isJsonNull())) {
 					etEquipoPadre.setText(objO.get("EQUIPADRE").getAsString());
 				}if (!(objO.get("EQUINOMBRE").isJsonNull())) {
 					etNombreEquipo.setText(objO.get("EQUINOMBRE").getAsString());
 				}if (!(objO.get("EQUINEMONICO").isJsonNull())) {
 					etNemonico.setText(objO.get("EQUINEMONICO").getAsString());
 				}if (!(objO.get("EQUIMARCA").isJsonNull())) {
 					etMarca.setText(objO.get("EQUIMARCA").getAsString());
 				}if (!(objO.get("EQUIMODELO").isJsonNull())) {
 					etModelo.setText(objO.get("EQUIMODELO").getAsString());
 				}if (!(objO.get("EQUISERIAL").isJsonNull())) {
 					etSerial.setText(objO.get("EQUISERIAL").getAsString());
 				}if (!(objO.get("EQUIESTADO").isJsonNull())) {
 					etEstado.setText(objO.get("EQUIESTADO").getAsString());
 				}if (!(objO.get("EQUIPROPIETARIO").isJsonNull())) {
 					etPropietario.setText(objO.get("EQUIPROPIETARIO").getAsString());
 				}
 				
 			}
 		}
	}	
}