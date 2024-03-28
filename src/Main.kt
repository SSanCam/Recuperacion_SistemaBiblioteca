import java.util.*

// Función principal (main)
fun main() {

    // Crear instancia del GestorBiblioteca
    val gestor = GestorBiblioteca()

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
    val (librosDisponibles, librosPrestados, todosLibros) = gestor.retornarLibros(gestor.catalogoLibros)
    println("Libros disponibles: $librosDisponibles")
    println("Libros prestados: $librosPrestados")
    println("Todos los libros: $todosLibros")

    /**
     * Mostrar menú
     * @return Devuleve el número correspondiente a la operación elegida por el usuario.
     */
    fun mostrarMenu(): Int {
        println(
            "Bienvenido al gestor de la biblioteca.\nIndica que operación quieres realizar según su número:\n" +
                    "1.- Agregar un libro.\n" +
                    "2.- Eliminar un libro.\n" +
                    "3.- Realizar un préstamo.\n" +
                    "4.- Devolver un libro.\n" +
                    "5.- Consultar el estado de los libros.\n" +
                    "6.- Salir del gestor de biblioteca."
        )
        val opcion = readln().toInt()
        return opcion
    }

    // Menú de usuario:
    var opcion : Int
    var seguir = true
    while (seguir) {
        opcion = mostrarMenu()
        when (opcion) {
            // Agregar Libro
            1 -> // TODO agregar un libro manualmente

            2 -> // TODO eliminar un libro, por autor o titulo



            3 -> // TODO registrar prestamo por titulo del libro


            4  -> // TODO Resgistrar devolución por título del libro


            5 -> // TODO mostrar los libros según su estado
                // Salir del programa
            6 -> "Saliendo del programa"
            else -> "Opción inválida. Por favor elija un número disponible en el menu de gestión."
        }
    }
}
