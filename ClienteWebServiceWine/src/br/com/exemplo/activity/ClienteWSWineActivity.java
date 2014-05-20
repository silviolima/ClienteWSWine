package br.com.exemplo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import br.com.exemplo.R;

public class ClienteWSWineActivity extends Activity {

	Button buscarTodosBt;
	Button minhaAdegaBt;
	Button rankingBt;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buscarTodosBt = (Button) findViewById(R.id.btBuscarTodos);
		minhaAdegaBt =  (Button) findViewById(R.id.btMinhaAdega);
        rankingBt = (Button) findViewById(R.id.btRanking);

		buscarTodosBt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				gerarToast("Listar Vinhos no servidor");
				buscarTodosBt.setEnabled(false);
				minhaAdegaBt.setEnabled(false);
				rankingBt.setEnabled(false);
				Intent i = new Intent(getApplicationContext(),
						BuscarVinhosActivity.class);
				startActivity(i);
				
			}
		});
	}
	
	private void gerarToast(CharSequence message) {
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast
				.makeText(getApplicationContext(), message, duration);
		toast.show();
	}
}