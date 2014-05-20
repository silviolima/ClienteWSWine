package br.com.exemplo.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import br.com.exemplo.R;
import br.com.exemplo.model.Wine;
import br.com.exemplo.webservice.WineREST;

public class ClienteWSWineActivity extends Activity {

	Button buscarTodosBt;
	ProgressBar progressBar;
	TextView txt_percentage;
	ArrayList<Wine> listaWines = new ArrayList<Wine>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buscarTodosBt = (Button) findViewById(R.id.btBuscarTodos);
		progressBar =  (ProgressBar) findViewById(R.id.progress);
        txt_percentage= (TextView) findViewById(R.id.txt_percentage);

		buscarTodosBt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buscarTodosBt.setEnabled(false);
				ShowDialogAsyncTask asyncTask = new ShowDialogAsyncTask();
				asyncTask.execute();
			}
		});
	}	
	
	private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void>{
		 
	     int progress_status;
	      
	     @Override
	  protected void onPreExecute() {
	   // update the UI immediately after the task is executed
	   super.onPreExecute();
	    WineREST wineREST = new WineREST();
		try {
			listaWines = (ArrayList<Wine>) wineREST
					.getListaWine();
			
		} catch (Exception e) {
			e.printStackTrace();
			gerarToast(e.getMessage());
		} 
	 
	   progress_status = 0;
	   txt_percentage.setText("carregando 0%");	    
	  }
	      
	  @Override
	  protected Void doInBackground(Void... params) {
	 		  
	   while(progress_status<100){
	     
	    progress_status += 2;
	     
	    publishProgress(progress_status);
	    SystemClock.sleep(320);
	     
	   } 
	   return null;
	  }
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	    
	   progressBar.setProgress(values[0]);
	   txt_percentage.setText("carregando " +values[0]+"%");
	    
	  }
	   
	  @Override
	  protected void onPostExecute(Void result) {
	   super.onPostExecute(result);
	   
	   Intent i = new Intent(getApplicationContext(),
				ListaWines.class);
		i.putExtra("lista", listaWines); // Lista Completa com detalhes
		i.putExtra("listaLabel",gerarListaLabel(listaWines)); // lista com labels apenas
		startActivity(i);
	    	     
	    txt_percentage.setText("Carga completada");
	    buscarTodosBt.setEnabled(true);
	    }
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