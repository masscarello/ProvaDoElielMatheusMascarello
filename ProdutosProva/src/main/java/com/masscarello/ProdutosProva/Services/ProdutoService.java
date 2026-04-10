package com.masscarello.ProdutosProva.Services;

import com.masscarello.ProdutosProva.Models.ProdutoModel;
import com.masscarello.ProdutosProva.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }

    public ProdutoModel buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }
    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }
    public ProdutoModel atualizarProduto(ProdutoModel produtoModel, Long id){
        ProdutoModel novoProduto = produtoRepository.findById(id).get();
        novoProduto.setNome(produtoModel.getNome());
        novoProduto.setDescricao(produtoModel.getDescricao());
        novoProduto.setPreco(produtoModel.getPreco());
        novoProduto.setStatus(produtoModel.getStatus());
        return produtoRepository.save(novoProduto);
    }

}
