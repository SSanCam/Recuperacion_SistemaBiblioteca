import java.util.*

// Función principal (main)
fun main() {
    // Crear instancia del GestorBiblioteca
    val gestor = GestorBiblioteca()

    // Crear algunos libros
    val libro1 = Libro(UUID.randomUUID(), "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula")
    val libro2 = Libro(UUID.randomUUID(), "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    val libro3 = Libro(UUID.randomUUID(), "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela")
    val libro4 = Libro(UUID.randomUUID(), "El Aleph", "Jorge Luis Borges", 1949, "Cuentos")

    // Agregar libros al catálogo
    gestor.agregarLibro(libro1)
    gestor.agregarLibro(libro2)
    gestor.agregarLibro(libro3)
    gestor.agregarLibro(libro4)

    // Registrar préstamos
    gestor.resgistrarPrestamo(libro1)
    gestor.resgistrarPrestamo(libro3)

    // Devolver un libro
    gestor.devolverLibro(libro1)

    // Consultar disponibilidad de un libro
    val disponibilidadLibro2 = gestor.consultarDisponibilidad(libro2)
    println("Disponibilidad del libro '${libro2.titulo}': $disponibilidadLibro2")

    // Retornar libros por estado
    val (librosDisponibles, librosPrestados, todosLibros) = gestor.retornarLibros(gestor.catalogoLibros)
    println("Libros disponibles: $librosDisponibles")
    println("Libros prestados: $librosPrestados")
    println("Todos los libros: $todosLibros")
}
