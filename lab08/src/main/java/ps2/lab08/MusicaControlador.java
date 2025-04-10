package ps2.lab08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaControlador {

    @Autowired
    private MusicaRepo repo;

    @GetMapping
    public Iterable<Musica> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Musica criar(@RequestBody Musica musica) {
        return repo.save(musica);
    }

    @GetMapping("/{titulo}")
    public Optional<Musica> buscar(@PathVariable String titulo) {
        return repo.findById(titulo);
    }

    @PutMapping("/{titulo}")
    public Musica atualizar(@PathVariable String titulo, @RequestBody Musica novaMusica) {
        novaMusica.setTitulo(titulo);
        return repo.save(novaMusica);
    }

    @DeleteMapping("/{titulo}")
    public void deletar(@PathVariable String titulo) {
        repo.deleteById(titulo);
    }
}
