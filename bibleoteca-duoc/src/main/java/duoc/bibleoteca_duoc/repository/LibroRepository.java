package duoc.bibleoteca_duoc.repository;


import duoc.bibleoteca_duoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class LibroRepository {

    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public ArrayList<Libro> obtenerLibros() {


        return listaLibros;

    }



    public Optional<Libro> buscarPorId(int id) {

        for (Libro libro : listaLibros) {

            if (libro.getId() == id) {


                return Optional.of(libro);

            }


        }

        return Optional.empty();

    }



    public Optional<Libro> buscarPorIsbn (String isbn) {

        for (Libro libro : listaLibros) {

            if (libro.getIsbn().equals(isbn)) {

                return Optional.of(libro);

            }


        }

        return Optional.empty();

    }


    public Libro guardar(Libro lib) {

        listaLibros.add(lib);

        return lib;


    }


    public Libro actualizar(Libro lib) {

        int id = 0;

        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {

            if (listaLibros.get(i).getId() == lib.getId()) {

                id = lib.getId();

                idPosicion = 1;



            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(Lib.getFechaPublicacion());
        libro1.setEditorial(Lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);

        return libro1;

    }

}
