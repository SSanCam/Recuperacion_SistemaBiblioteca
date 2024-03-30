import java.util.*

/**
 * Programa principal
 */
fun main() {

    // Crear instancia del GestorBiblioteca
    val gestor = GestorBiblioteca()
    val consola = GestionConsola()
    // Crear algunos libros y los agregamos al catálogo:
    val libro1 = Libro(UUID.randomUUID(), "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula")
    val libro2 = Libro(UUID.randomUUID(), "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    val libro3 = Libro(UUID.randomUUID(), "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela")
    val libro4 = Libro(UUID.randomUUID(), "El Aleph", "Jorge Luis Borges", 1949, "Cuentos")
    val libro5 = Libro(UUID.randomUUID(), "1984", "George Orwell", 1949, "Ciencia ficción")

    // Agregar libros al catálogo
    gestor.agregarLibro(libro1)
    gestor.agregarLibro(libro2)
    gestor.agregarLibro(libro3)
    gestor.agregarLibro(libro4)
    gestor.agregarLibro(libro5)

    // Registramos préstamos
    gestor.resgistrarPrestamo(libro1)
    gestor.resgistrarPrestamo(libro3)
    gestor.resgistrarPrestamo(libro5)

    // Devolver un libro
    gestor.devolverLibro(libro1)

    // Préstamo erróneo
    gestor.resgistrarPrestamo(libro3)
    // Devolución errónea
    gestor.devolverLibro(libro4)

    // Retornar libros por estado
    /*
    val (librosDisponibles, librosPrestados, todosLibros) = gestor.retornarLibros(gestor.catalogoLibros)
    println("Libros disponibles: $librosDisponibles")
    println("Libros prestados: $librosPrestados")
    println("Todos los libros: $todosLibros")
    */

}
