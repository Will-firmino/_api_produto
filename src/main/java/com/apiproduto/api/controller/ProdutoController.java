package com.apiproduto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiproduto.api.model.Produto;
import com.apiproduto.api.model.ProdutoRepository;

@Controller // @RestController -> Somente é utilizado para RESTAPI.
public class ProdutoController {

    @Autowired // Injeção de dependência -> Quase tudo pronto para salvar, excluir, alterar,
               // ler no BD.
    private ProdutoRepository repository;

    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("todosOsProdutos", repository.findAll());
        return "listar";
    }

    @GetMapping("/cadastro") // Apresenta o formulário.
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    @PostMapping("/cadastro") // Ocorre quando o usuário clicar no botão enviar.
    public String cadastrarProdutos(Produto produto) {
        repository.save(produto);
        return "redirect:/";
    }

}
