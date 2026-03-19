package com.sistema.aplicacion.Controller;import com.sistema.aplicacion.Model.TablaResponsable;
import com.sistema.aplicacion.Repository.RepositoryResponasble; // Respetando tu nombre con error de dedo
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/responsables")
public class ResponsableController {

    RepositoryResponasble repo = new RepositoryResponasble();

    @GetMapping
    public List<TablaResponsable> listar() {
        return repo.mostrarResponsables();
    }

    @PostMapping
    public String insertar(@RequestBody TablaResponsable responsable) {
        return repo.insertarResponsable(responsable);
    }

    @PutMapping
    public String modificar(@RequestBody TablaResponsable responsable) {
        return repo.modificarResponsable(responsable);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return repo.eliminarResponsable(id);
    }
}