package br.com.votacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.votacao.domain.Usuario;
import br.com.votacao.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Usuario mostrarUsuario(@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }
}
