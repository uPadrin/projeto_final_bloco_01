package ecommerce.Controller;

import java.util.ArrayList;
import java.util.Optional;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		
		Optional<Produto> produto = buscarColle(numero);

		if (produto.isPresent())
			produto.get().visual();
		else
			System.out.println("O Produto ID " + numero + " não foi encontrada");
	}
		

	@Override
	public void listarTodas() {
		if (listaProduto.isEmpty()) {
			System.out.println("Não existem contas cadastradas.");
		} else
			for (var produto : listaProduto) {
				produto.visual();

			}
		
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProduto.add(produto);
		System.out.println("O Produto ID " + produto.getNumero() + " foi criada com sucesso");
		
	}

	@Override
	public void atualizar(Produto produto) {
		
		Optional<Produto> buscaProduto = buscarColle(produto.getNumero());
		if (buscaProduto.isPresent()) {
			listaProduto.set(listaProduto.indexOf(buscaProduto.get()), produto);
			System.out.println("O Produto ID" + produto.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("O Produto ID" + produto.getNumero() + " não foi encontrada");
		
	}

	@Override
	public void deletar(int numero) {
		
		Optional<Produto> produto = buscarColle(numero);
		if (produto.isPresent()) {
			if (listaProduto.remove(produto.get()) == true)
				System.out.println("A conta numero: " + numero + " foi excluida com sucesso!");
		} else
			System.out.println("O Produto ID " + numero + " não foi encontrada");
		
	}
	// Métodos aux
	public int gerarNum() {
		return ++numero;
	}
	public Optional<Produto> buscarColle(int numero) {

		for (var produto : listaProduto) {
			if (produto.getNumero() == numero)
				return Optional.of(produto);
		}

		return Optional.empty();
	}
}
