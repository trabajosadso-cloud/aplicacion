package com.sistema.aplicacion.Controller;import com.sistema.aplicacion.Model.TablaTareas;
import com.sistema.aplicacion.Repository.RepositoryTareas;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    RepositoryTareas repo = new RepositoryTareas();

    @GetMapping
    public List<TablaTareas> listar() {
        return repo.mostrarTareas();
    }

    @PostMapping
    public String insertar(@RequestBody TablaTareas tarea) {
        return repo.insertarTarea(tarea);
    }

    @PutMapping
    public String modificar(@RequestBody TablaTareas tarea) {
        return repo.modificarTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return repo.eliminarTarea(id);
    }
}