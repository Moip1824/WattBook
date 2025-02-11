package com.example.wattbook.Controller;

import com.example.wattbook.Dto.LibroCreacionDTO;
import com.example.wattbook.Dto.LibroDTO;
import com.example.wattbook.Dto.LibroLeerDto;
import com.example.wattbook.Dto.UsuarioDTO;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Entity.Votos;
import com.example.wattbook.Enums.Genero;
import com.example.wattbook.Repository.UsuarioRepository;
import com.example.wattbook.Service.LibrosService;
import com.example.wattbook.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibrosService libroService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public ResponseEntity<List<LibroDTO>> obtenerLibros() {
        return ResponseEntity.ok(libroService.obtenerLibrosConVotos());
    }


    @PostMapping("/crear")
    public ResponseEntity<Libros> publicarLibro(@RequestBody LibroCreacionDTO libroDTO) {
        Usuario autor = usuarioRepository.findById(libroDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        // Crear el libro con los datos del DTO
        Libros libro = new Libros();
        libro.setNombre(libroDTO.getNombre());
        libro.setDescripcion(libroDTO.getDescripcion());
        libro.setImagen(libroDTO.getImagen());
        libro.setGeneros(Genero.valueOf(libroDTO.getGeneros()));
        libro.setFechaPublicacion(libroDTO.getFechaPublicacion());
        libro.setAutorId(autor);

        return ResponseEntity.ok(libroService.publicarLibro(libro));
    }


    @PostMapping("/votar/{libroId}")
    public ResponseEntity<Votos> votarLibro(@PathVariable Long libroId,
                                            @RequestParam Long usuarioId,
                                            @RequestParam boolean esLike) {
        return ResponseEntity.ok(libroService.votarLibro(libroId, usuarioId, esLike));
    }
    @GetMapping("/MostrarLibros")
    public ResponseEntity<List<LibroLeerDto>> getAllLibros() {
        return ResponseEntity.ok(libroService.getAllLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroLeerDto> getLibro(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.getLibro(id));
    }


    @GetMapping("/perfil/publicaciones/{id}")
    public List<LibroDTO> obtenerLibrosPefil(@PathVariable Long id){
       return libroService.obetenerLibrosPerfil(id);
    }
}
