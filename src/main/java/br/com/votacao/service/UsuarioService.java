package br.com.votacao.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.domain.Usuario;
import br.com.votacao.repository.UsuarioRepository;
import br.com.votacao.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
    	log.info("Novo usuário " + Usuario.class.toString());
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario buscarUsuario(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> {
        	log.error("Objeto não encontrado " + Usuario.class.toString());
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                    + ", Tipo: " + Usuario.class.getName());
        });
    }


}
