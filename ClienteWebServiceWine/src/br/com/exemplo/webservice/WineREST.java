package br.com.exemplo.webservice;

import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Wine;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class WineREST {

	private static final String URL_WS = "http://192.168.0.100:8080/Restful/wine/";
	
	/*public List<Cliente> getCliente(int id) throws Exception {

		String[] resposta = new WebServiceCliente().get(URL_WS + id);
		
		if (resposta[0].equals("200") && !resposta[1].equals("{}")) {
			Gson gson = new Gson();
			ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
			JsonParser parser = new JsonParser();
			String pre ="["; String pos = "]"; 
		    JsonArray array = (JsonArray) parser.parse(pre+resposta[1]+pos);
		    listaCliente.add(gson.fromJson(array.get(0), Cliente.class));
			return listaCliente;
		} else {
			throw new Exception(resposta[1]);
			
		}*/
		
/*	public List<Cliente> getCliente(int id) throws Exception {
		
        String[] resposta = new WebServiceCliente().get(URL_WS + id);
		
		if (resposta[0].equals("200") && !resposta[1].equals("{}")) {
			Gson gson = new Gson();
			ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
			JsonParser parser = new JsonParser();
			String pre ="["; String pos = "]"; 
		    JsonArray array = (JsonArray) parser.parse(pre+resposta[1]+pos);
		    listaCliente.add(gson.fromJson(array.get(0), Cliente.class));
			return listaCliente;
		} else {
			throw new Exception(resposta[1]);
			
		}
	}*/
	
	public List<Wine> getListaWine() throws Exception {

		String[] resposta = new WebServiceCliente().get(URL_WS + "listarTodos");
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			ArrayList<Wine> listaCliente = new ArrayList<Wine>();
			JsonParser parser = new JsonParser();
		    JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
		    
		    for (int i = 0; i < array.size(); i++) {
		    	listaCliente.add(gson.fromJson(array.get(i), Wine.class));
			}
			return listaCliente;
		} else {
			throw new Exception(resposta[1]);
			
		}
	}
	
/*	public String inserirCliente(Cliente cliente) throws Exception {
		
		Gson gson = new Gson();
		String clienteJSON = gson.toJson(cliente);
		
		String[] resposta = new WebServiceCliente().post(URL_WS + "inserir", clienteJSON);
		
		if (resposta[0].equals("200")) {
			return resposta[1];
		} else {
			throw new Exception(resposta[1]);
		}
	}*/
	
/*public String atualizarCliente(Cliente cliente) throws Exception {
		
		Gson gson = new Gson();
		String clienteJSON = gson.toJson(cliente);
		
		String[] resposta = new WebServiceCliente().post(URL_WS + "atualizar", clienteJSON);
		
		if (resposta[0].equals("200")) {
			return resposta[1];
		} else {
			throw new Exception(resposta[1]);
		}
	}
	
	public String deletarCliente(int id) {
		
		String[] resposta = new WebServiceCliente().get(URL_WS + "delete/" + id);
		return resposta[1];
	}*/
}
