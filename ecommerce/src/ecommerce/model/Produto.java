package ecommerce.model;

public abstract class Produto {

	private int numero;
	private String nome;
	private int tipo;
	private float preco;
	private String data;

	
	public Produto(int numero, String nome, int tipo, float preco, String data) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.data = data;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void visual() {

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Jogo";
		case 2 -> tipo = "Console";
		}
		System.out.println("\n\no------------------------------------o");
		System.out.println("|           Dados da Produto         |");
		System.out.println("o------------------------------------o");
		System.out.println("Id do Produto: " + this.numero);
		System.out.println("Nome do Produto: " + this.nome);
		System.out.println("Ano de lançamento: " + this.data);
		System.out.println("Preço: " + this.preco);
		System.out.println("Tipo: " + tipo);

	}

}
