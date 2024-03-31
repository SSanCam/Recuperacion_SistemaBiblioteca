import java.time.LocalDateTime

class GestorBiblioteca(private val gestorPrestamos: GestorPrestamos) {
    val catalogoLibros: MutableList<Libro> = mutableListOf()
    private val registroPrestamos: MutableList<Prestamo> = mutableListOf()

    companion object {
        // Función con la que vamos a reemplazar println()
        fun printText(texto: Any) {
            val imprimir = println(texto)
            return imprimir
        }
    }

    /**
     * Agregar libro
     * Agrega un libro al catálogo actual.
     * @param libro Libro Recibe un objeto Libro al que se le agregara el ID
     */
    fun agregarLibro(libro: Libro) {
        val nuevaId = UtilidadesBiblioteca.GENERAR_ID_LIBRO()
        val fechaRegistro = LocalDateTime.now()
        libro.id = nuevaId
        catalogoLibros.add(libro)
        return printText(
            "El libro con ID \'$nuevaId\', se ha agregado con exito en: $fechaRegistro."
        )

    }
    /**
     * Eliminar libro:
     * Método que elimina un libro determinado del catálogo
     * @param libro Libro Libro a eliminar del catálogo.
     */
    fun eliminarLibro(libro: Libro) {
        val gestor = GestorBiblioteca(gestorPrestamos)
        val catalogoLibros = gestor.catalogoLibros
        catalogoLibros.remove(libro)
        printText(
            "El libro ${libro.titulo} ha sido eliminado correctamente."
        )
    }



    /**
     * Registar préstamo:
     * Cambia el estado del libro a prestado, si está disponible y lo agrega al registro de libros prestados.
     */
    fun registrarPrestamo(libro: Libro, usuario: Usuario) {
        if (libro.estado == EstadoElemento.DISPONIBLE) {
            libro.estado = EstadoElemento.PRESTADO
            registroPrestamos.add(Prestamo(libro,usuario, LocalDateTime.now(), null))
        } else {
            printText("El libro ${libro.titulo} no está disponible para préstamo.")
        }
    }

    /**
     * Devolver libro:
     * Cambia el estado del libro a DISPONIBLE y lo elimina del registro de préstamos.
     */

    fun devolverLibro(libro: Libro) {
        if (libro.estado == EstadoElemento.PRESTADO) {
            printText("El libro \'${libro.titulo}\'no está prestado. No necesita devolución.")
        } else {
            libro.estado = EstadoElemento.DISPONIBLE
            registroPrestamos.removeAll { it.libro == libro }
            printText("El libro con título \'${libro.titulo}\' ha sido devuelto correctamente.")
        }
    }

    /**
     * Consultar disponibilidad
     * @param libro Libro Indica si el libro en cuestión está, o no, disponible para préstamo.
     */
    fun consultarDisponibilidad(libro: Libro): EstadoElemento {
        return libro.estado
    }

    /**
     * Retornar libros: en función de su estado: disponibles, prestados y todos.
     * @param catalogo List<Libro> Recibe el catalogo de libros
     */
    fun retornarLibros(catalogo: List<Libro>) {
        val librosDisponibles = (catalogo.filter { it.estado == EstadoElemento.DISPONIBLE }).joinToString { "\n" }
        val librosPrestados = catalogo.filter { it.estado == EstadoElemento.PRESTADO }.joinToString { "\n" }
        printText(
            "Nuestro catalogo completo:\n" +
                    "${catalogo.joinToString { "\n" }}\n" +
                    "Libros disponibles:\n" +
                    "$librosDisponibles\n" +
                    "Libros prestados:\n" +
                    librosPrestados
        )
    }
}

