package com.sistema.aplicacion.Controller;import com.sistema.aplicacion.Model.TablaProyectos;
import com.sistema.aplicacion.Repository.RepositoryProyectos;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    RepositoryProyectos repo = new RepositoryProyectos();

    @GetMapping
    public List<TablaProyectos> listar() {
        return repo.mostrarProyectos();
    }

    @PostMapping
    public String insertar(@RequestBody TablaProyectos proyecto) {
        return repo.insertarProyecto(proyecto);
    }

    @PutMapping
    public String modificar(@RequestBody TablaProyectos proyecto) {
        return repo.modificarProyecto(proyecto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return repo.eliminarProyecto(id);
    }
}