package br.com.exemplo.activity;


import java.util.ArrayList;

import android.app.ListActivity;
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

public class SingleWine extends ListActivity {

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		ArrayList<Wine> listaDetails = new ArrayList<Wine>();

		if (getIntent().hasExtra("lista_details")) {

			listaDetails = (ArrayList<Wine>) getIntent().getExtras()
					.getSerializable("lista_details");
		}

		setListAdapter(new ArrayAdapter<Wine>(this, R.layout.list_single,listaDetails));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		/*lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});*/

	}
}