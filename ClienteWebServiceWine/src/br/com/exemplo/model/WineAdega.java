package br.com.exemplo.model;

public class WineAdega {

    // private variables
    public int id;
    public String label;
    public String quantidade;
    public String comentario;

    public WineAdega() {
    }

    // constructor
    public WineAdega(int id, String label, String quantidade, String comentario) {
	this.id = id;
	this.label = label;
	this.quantidade = quantidade;
	this.comentario = comentario;

    }

    // constructor
    public WineAdega(String label, String quantidade, String comentario) {
	this.label = label;
	this.quantidade = quantidade;
	this.comentario = comentario;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}