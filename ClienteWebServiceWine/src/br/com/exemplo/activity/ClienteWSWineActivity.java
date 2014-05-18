package br.com.exemplo.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import br.com.exemplo.R;
import br.com.exemplo.model.Wine;
import br.com.exemplo.webservice.WineREST;

public class ClienteWSWineActivity extends Activity {

	private String id;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button buscarTodosBt = (Button) findViewById(R.id.btBuscarTodos);

		

		buscarTodosBt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				WineREST wineREST = new WineREST();
				try {
					ArrayList<Wine> listaWines = (ArrayList<Wine>) wineREST
							.getListaWine();
					Intent i = new Intent(getApplicationContext(),
							ListaWines.class);
					i.putExtra("lista", listaWines); // Lista Completa com detalhes
					i.putExtra("listaLabel",gerarListaLabel(listaWines));
					startActivity(i);
				} catch (Exception e) {
					e.printStackTrace();
					gerarToast(e.getMessage());
				}

			}
		});


	}
	
	private ArrayList<String> gerarListaLabel(ArrayList<Wine> lista){
		ArrayList<String> listaLabels = new ArrayList<String>();
		for(int j = 0; j < lista.size() ; j++)
        {
            String label = lista.get(j).getBottleLabel();
           	 listaLabels.add(label);
            }
		return listaLabels;
}
	

	private void gerarToast(CharSequence message) {
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast
				.makeText(getApplicationContext(), message, duration);
		toast.show();
	}
}