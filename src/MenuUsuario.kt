import java.util.*

/**
 * Menu Usuario
 * Con esta clase el usuario podrá menejar la gestión de la biblioteca de forma sencilla.
 */
class MenuUsuario(private val gestor: GestorBiblioteca) {
    companion object {
        fun IMPRIMIR_TEXTO(texto: Any) {
            val imprimir = println(texto)
            return imprimir
        }
    }

    open fun mostrarMenu() {
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
        var seguir = true

        while (seguir) {
            mostrarMenu()
            when (opcion) {
                // Agregar Libro al catálogo
                1 -> agregarLibro()
                // Elimina un libro del catálogo
                2 -> eliminarLibro()
                // Registrar prestamo por titulo del libro
                3 -> registrarPrestamo()
                // Resgistrar devolución por título del libro
                4 -> registrarDevolucion()
                // Mostrar los libros según su estado
                5 -> mostrarLibros()
                // Salir del programa
                6 -> {
                    println("Saliendo del programa")
                    seguir = false
                }

                else -> "Opción inválida. Por favor elija un número disponible en el menu de gestión."
            }
        }

    }

    /**
     * Agregar libro
     * Agregamos de forma manual un libro a nuestro catálogo de libros.
     */
    open fun agregarLibro() {
        println("Ingresa el título del libro: ")
        var titulo = readln().toString()
        println("Ingresa el nombre del autor: ")
        var autor = readln().toString()
        println("Ingresa el año de publicación.")
        var publicacion = readln().toInt()
        println("Indica la temática del libro: ")
        var tematica = readln().toString()
        val libroNuevo =
            Libro(UUID.randomUUID(), titulo, autor, publicacion, tematica, EstadoLibro.DISPONIBLE)
        gestor.agregarLibro(libroNuevo)
        println("Libro agregado correctamente.")
    }

    /**
     * Eliminar libro
     * Eliminaremos un libro del catálogo por su título.
     */
    open fun eliminarLibro() {
        val titulos = gestor.catalogoLibros.map { it.titulo }
        println("Introduce el título del libro que quieres eliminar: ")
        var libroAEliminar = readln()
        while (libroAEliminar !in titulos) {
            println("No se encuentra ningún libro con el título \'$libroAEliminar\'")
            println("Inténtalo de nuevo: ")
            libroAEliminar = readln()
        }
        if (libroAEliminar in titulos) {
            val libro = gestor.catalogoLibros.find { it.titulo == libroAEliminar }
            if (libro != null) {
                gestor.eliminarLibro(libro)
                println("El libro ha sido eliminado correctamente.")
            }
        }
    }

    /**
     * Registrar préstamo
     * Se cambiará el éstado del libro de 'DISPONIBLE'a 'PRESTADO'.
     */
    open fun registrarPrestamo() {
        println("Introduce el título del libro que quieres tomar prestado: ")
        var titulo = readln()
        val libros = gestor.catalogoLibros.map { it.titulo }
        while (titulo !in libros) {
            println("Lo sentimos, no encontramos el libro de titulo\'$titulo\'")
            println("Inténtalo de nuevo >")
            titulo = readln()
        }
        if (titulo in libros) {
            val tituloPrestado = gestor.catalogoLibros.find { it.titulo == titulo }
            tituloPrestado?.estado = EstadoLibro.PRESTADO
            val aviso = ("El préstamo se ha realizado correctamente.")
            IMPRIMIR_TEXTO(aviso)
        }
    }

    /**
     * Registrar devolución
     * Se cambiará el estado del libro de 'PRESTADO' a 'DISPONIBLE' para poderse volver a prestar.
     */
    open fun registrarDevolucion() {

    }

    /**
     * Mostrar libros
     * Mostrará los libros según su estado: todos, PRESTADO o DISPONIBLE
     */
    open fun mostrarLibros() {
        val catalogo = gestor.catalogoLibros
        val librosDisponibles = (catalogo.filter { it.estado == EstadoLibro.DISPONIBLE }).joinToString { "\n" }
        val librosPrestados = (catalogo.filter { it.estado == EstadoLibro.PRESTADO }).joinToString { "\n" }
        val catalogoCompleto = catalogo.joinToString { "\n" }
        val texto = ("Los títulos de libros disponibles son: $librosDisponibles\n" +
                "Los títulos de libros prestados son: $librosPrestados\n" +
                "Los títulos de libros prestados son: $librosPrestados\n" +
                "Los libros del catálogo actual son: $catalogoCompleto")
        IMPRIMIR_TEXTO(texto)
    }

}

