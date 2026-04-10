package com.masscarello.ProdutosProva.Controllers;

import com.masscarello.ProdutosProva.Models.ProdutoModel;
import com.masscarello.ProdutosProva.Services.ProdutoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoModel)
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){
        List<ProdutoModel> requeste = produtoService.listarProdutos();
        return ResponseEntity.ok().body(requeste);
    }
    @Id
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> buscarProdutoPorId(Long id){
        ProdutoModel requeste = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok().body(requeste);
    }
    @DeleteMapping(path = "/{id}")
    @Id
    public ResponseEntity<?> excluirProduto(Long id){
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<ProdutoModel> atualizarProduto(ProdutoModel produtoModel, Long id){
        ProdutoModel requeste = produtoService.atualizarProduto(produtoModel,id);
        return ResponseEntity.ok().body(requeste);
    }


}
