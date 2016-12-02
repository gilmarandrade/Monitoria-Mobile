package br.ufrn.imd.monitoria_mobile.dominio;
import java.util.List;


public class Pessoa {

	private int id;

	private String nome;

	private String sexo;

	private String cpf;

	private String email;
	
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNomeAP(){
		String[] arrayNome = nome.split(" "); 
		if(arrayNome.length > 2){
			return arrayNome[0]+" "+arrayNome[1];
		}else{
			return nome;
		}
	}
	
	
	
}
