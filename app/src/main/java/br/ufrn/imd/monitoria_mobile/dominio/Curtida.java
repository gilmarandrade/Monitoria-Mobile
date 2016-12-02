package br.ufrn.imd.monitoria_mobile.dominio;
import java.util.Date;



public class Curtida {

	private int id;


	private Duvida duvida;

	private Resposta resposta;

	private Pessoa pessoa;

	private Date data;
	
	/**
	 * Construtor padr�o da classe
	 */
	public Curtida(){
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the duvida
	 */
	public Duvida getDuvida() {
		return duvida;
	}

	/**
	 * @param duvida the duvida to set
	 */
	public void setDuvida(Duvida duvida) {
		this.duvida = duvida;
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	
	
	
}
