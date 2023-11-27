package ecommerce.model;

public class Console extends Produto {

	private String marca;

	public Console(int numero, String nome, int tipo, float preco, int data, String marca) {
		super(numero, nome, tipo, preco, data);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public void visual() {
		super.visual();
		System.out.println("Marca: " + this.marca);
	}
}
