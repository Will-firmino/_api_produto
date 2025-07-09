package com.apiproduto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiproduto.api.model.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/listagem")
    public String listarProdutos() {
        return "listar";
    }

    @GetMapping("/cadastro")
    public String cadastrarProdutos() {
        return "cadastrar";
    }

}
