package br.com.exemplo.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.exemplo.R;
import br.com.exemplo.model.Wine;
import br.com.exemplo.webservice.WineREST;

public class ListaWines extends ListActivity {
	
	ArrayList<Wine> listaWines = new ArrayList<Wine>();
	ArrayList<Wine> wineDetails = new ArrayList<Wine>();
	ArrayList<String> listaLabels = new ArrayList<String>();
	protected CharSequence line_clicked;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		

		if (getIntent().hasExtra("lista")) {

			listaWines = (ArrayList<Wine>) getIntent().getExtras()
					.getSerializable("lista");
		}
		
		if (getIntent().hasExtra("listaLabel")) {

			listaLabels = (ArrayList<String>) getIntent().getExtras()
					.getSerializable("listaLabel");
		}
        // Carrega adapter com lista de labels dos vinhos  
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,listaLabels));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			   
				line_clicked = ((TextView) view).getText(); // Item selecionado na view
							
	             for(int j = 0; j < listaWines.size() ; j++)
	             {
	                 String label = listaWines.get(j).getBottleLabel();
	                 if ((label).equalsIgnoreCase(line_clicked.toString())){
	                	 wineDetails.add(listaWines.get(j));
	                	 break;
	                 }
	             }
				try {
					Intent i = new Intent(getApplicationContext(),
							SingleWine.class);
					i.putExtra("lista_details", wineDetails);
					startActivity(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
				wineDetails.clear();
			
			}
		});

	}
}
