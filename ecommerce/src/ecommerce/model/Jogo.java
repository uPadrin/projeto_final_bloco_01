package ecommerce.model;

public class Jogo extends Produto {
	private String genero;


	public Jogo(int numero, String nome, int tipo, float preco, int data, String genero) {
		super(numero, nome, tipo, preco, data);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void visual() {
		super.visual();
		System.out.println("Gênero: " + this.genero);
	}
}