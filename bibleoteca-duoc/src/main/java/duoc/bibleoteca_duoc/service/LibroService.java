package duoc.bibleoteca_duoc.service;


import duoc.bibleoteca_duoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired

    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) {
        // OJO: Si en tu Repository buscarPorId devuelve un Optional,
        // aquí deberías manejarlo (ej: .orElse(null)) o cambiar el tipo de retorno a Optional<Libro>
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.actualizar(libro);
    }


    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "producto eliminado";
    }


}
