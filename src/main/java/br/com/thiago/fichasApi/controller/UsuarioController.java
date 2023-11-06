package br.com.thiago.fichasApi.controller;

import br.com.thiago.fichasApi.domain.usuario.AtualizarUsuarioDTO;
import br.com.thiago.fichasApi.domain.usuario.CadastrarUsuarioDTO;
import br.com.thiago.fichasApi.domain.usuario.Usuario;
import br.com.thiago.fichasApi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @CrossOrigin(origins="*")
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid CadastrarUsuarioDTO data, UriComponentsBuilder uriBuilder){
        var newUsuario = new Usuario(data);
        Usuario savedUsuario = usuarioService.save(newUsuario);
        var uri = uriBuilder.path("/player/{id}").buildAndExpand(savedUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(savedUsuario);
    }


}
