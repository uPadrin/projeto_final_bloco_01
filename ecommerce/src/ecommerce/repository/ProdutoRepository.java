package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
}
