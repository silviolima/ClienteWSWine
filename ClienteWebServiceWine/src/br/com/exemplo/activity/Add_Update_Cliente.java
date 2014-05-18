package br.com.exemplo.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import br.com.exemplo.R;

public class Add_Update_Cliente extends Activity {
   /* EditText nome_ed, cpf_ed, endereco_ed;
    Button add_salvar_bt, add_listar_bt, update_salvar_bt, update_listar_bt;
    LinearLayout add_view, update_view;
    String valid_cpf = null, valid_endereco = null, valid_nome = null,
	    Toast_msg = null, valid_user_id = "";
    int USER_ID;
    
    ArrayList<Cliente> lista = new ArrayList<Cliente>();
    Cliente cli = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.add_update_item);

	// set screen
	Set_Add_Update_Screen();

	// set visibility of view as per calling activity
	String called_from = getIntent().getStringExtra("called"); // add-> inserir ou update - atualizar

	if (called_from.equalsIgnoreCase("add")) {
	   add_view.setVisibility(View.VISIBLE);
	    update_view.setVisibility(View.GONE);
	} 
	else {
		
	    update_view.setVisibility(View.VISIBLE);
	    add_view.setVisibility(View.GONE);
	    USER_ID = Integer.parseInt(getIntent().getStringExtra("USERID"));
	    
	    lista = (ArrayList<Cliente>) getIntent().getExtras().getSerializable("lista");

	    for(Object o: lista ){
	    	cli = (Cliente)o;
	    	nome_ed.setText(cli.getNome());
	    	cpf_ed.setText(cli.getCpf());
	    	endereco_ed.setText(cli.getEndereco());
	    }
	} */
	//}
/*	add_mobile.addTextChangedListener(new TextWatcher() {

	    @Override
	    public void onTextChanged(CharSequence s, int start, int before,
		    int count) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void beforeTextChanged(CharSequence s, int start, int count,
		    int after) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		// min lenth 10 and max lenth 12 (2 extra for - as per phone
		// matcher format)
		Is_Valid_Sign_Number_Validation(12, 12, add_mobile);
	    }
	});
	add_mobile
		.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

	add_email.addTextChangedListener(new TextWatcher() {

	    @Override
	    public void onTextChanged(CharSequence s, int start, int before,
		    int count) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void beforeTextChanged(CharSequence s, int start, int count,
		    int after) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Is_Valid_Email(add_email);
	    }
	});

	add_name.addTextChangedListener(new TextWatcher() {

	    @Override
	    public void onTextChanged(CharSequence s, int start, int before,
		    int count) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void beforeTextChanged(CharSequence s, int start, int count,
		    int after) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Is_Valid_Person_Name(add_name);
	    }
	});
	
	*/

	/*add_salvar_bt.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		// check the value state is null or not
	    	
	    	valid_nome = nome_ed.getText().toString();
			valid_cpf = cpf_ed.getText().toString();
			valid_endereco = endereco_ed.getText().toString();
	    	
		if (valid_nome != null && valid_cpf != null
			&& valid_endereco != null && valid_nome.length() != 0
			&& valid_cpf.length() != 0
			&& valid_endereco.length() != 0) {
			
			Cliente cli = new Cliente();

			cli.setNome(valid_nome);
			cli.setCpf(valid_cpf);
			cli.setEndereco(valid_endereco);
			//cli.setId("clientes_id_pk_seq");
			
			WineREST cliREST = new WineREST();
			try {
				String resposta = cliREST.inserirCliente(cli);
				Toast_msg = resposta;
			    Show_Toast(Toast_msg);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		    Toast_msg = "Verifique a operação.";
		    Show_Toast(Toast_msg);
		}

		    
		    
	    }
	}
	);*/
	

/*	update_salvar_bt.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub

		valid_nome = nome_ed.getText().toString();
		valid_cpf = cpf_ed.getText().toString();
		valid_endereco = endereco_ed.getText().toString();
		
		

		// check the value state is null or not
		if (valid_nome != null && valid_cpf != null
			&& valid_endereco != null && valid_nome.length() != 0
			&& valid_cpf.length() != 0
			&& valid_endereco.length() != 0) {
			Cliente cli = new Cliente();
			
			
			cli.setNome(valid_nome);
			cli.setCpf(valid_cpf);
			cli.setEndereco(valid_endereco);
			cli.setId(USER_ID);
			
			WineREST cliREST = new WineREST();
			try {
				String resposta = cliREST.atualizarCliente(cli);
				Toast_msg = resposta;
			    Show_Toast(Toast_msg);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		    Toast_msg = "Verifique a operação.";
		    Show_Toast(Toast_msg);
		}*/

/*	    }
	});
}
	*//*
	update_view_all.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent view_user = new Intent(Add_Update_Cliente.this,
			Main_Screen.class);
		view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
			| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(view_user);
		finish();
	    }
	});

	add_view_all.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent view_user = new Intent(Add_Update_Cliente.this,
			Main_Screen.class);
		view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
			| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(view_user);
		finish();
	    }
	});

    }
*/
 /*   public void Set_Add_Update_Screen() {

	nome_ed = (EditText) findViewById(R.id.ClienteNome);
	cpf_ed = (EditText) findViewById(R.id.ClienteCpf);
	endereco_ed = (EditText) findViewById(R.id.ClienteEndereco);

	add_salvar_bt = (Button) findViewById(R.id.add_salvar_bt);
	update_salvar_bt = (Button) findViewById(R.id.update_salvar_bt);
	add_listar_bt = (Button) findViewById(R.id.add_listar_bt);
	update_listar_bt = (Button) findViewById(R.id.update_listar_bt);

	add_view = (LinearLayout) findViewById(R.id.add_view);
	update_view = (LinearLayout) findViewById(R.id.update_view);

	add_view.setVisibility(View.GONE);
	update_view.setVisibility(View.GONE);

    }*/

/*    public void Is_Valid_Sign_Number_Validation(int MinLen, int MaxLen,
	    EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("Number Only");
	    valid_nome = null;
	} else if (edt.getText().toString().length() < MinLen) {
	    edt.setError("Minimum length " + MinLen);
	    valid_nome = null;

	} else if (edt.getText().toString().length() > MaxLen) {
	    edt.setError("Maximum length " + MaxLen);
	    valid_nome = null;

	} else {
	    valid_nome = edt.getText().toString();

	}

    } // END OF Edittext validation

/*    public void Is_Valid_Email(EditText edt) {
	if (edt.getText().toString() == null) {
	    edt.setError("Invalid Email Address");
	    valid_email = null;
	} else if (isEmailValid(edt.getText().toString()) == false) {
	    edt.setError("Invalid Email Address");
	    valid_email = null;
	} else {
	    valid_email = edt.getText().toString();
	}
    }
*/
 /*   boolean isEmailValid(CharSequence email) {
	return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    } // end of email matcher

    public void Is_Valid_Person_Name(EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("Accept Alphabets Only.");
	    valid_name = null;
	} else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
	    edt.setError("Accept Alphabets Only.");
	    valid_name = null;
	} else {
	    valid_name = edt.getText().toString();
	}*/

  //  }

    public void Show_Toast(String msg) {
	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    /*private void gerarToast(CharSequence message) {
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast
				.makeText(getApplicationContext(), message, duration);
		toast.show();
	}*/
    
    
/*    public void Reset_Text() {

	add_name.getText().clear();
	add_mobile.getText().clear();
	add_email.getText().clear();
 */ }


