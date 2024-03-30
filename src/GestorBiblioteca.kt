class GestorBiblioteca() {
    val catalogoLibros: MutableList<Libro> = mutableListOf()
    val registroPrestamos: MutableList<Libro> = mutableListOf()

    companion object {
        fun IMPRIMIR_TEXTO(texto: Any) {
            val imprimir = println(texto)
            return imprimir
        }
    }

    /**
     * Agregar libro:
     * @param libro Libro Es es libro que va a agregarse al catálogo.
     */
    fun agregarLibro(libro: Libro) {
        catalogoLibros.add(libro)
        println("Libro agregado.")
    }

    /**
     * Eliminar libro:
     * Método que elimina un libro determinado del catálogo
     * @param libro Libro Libro a eliminar del catálogo.
     */
    fun eliminarLibro(libro: Libro) {
        catalogoLibros.remove(libro)
        println("Libro eliminado.")
    }

    /**
     * Registar préstamo:
     * Cambia el estado del libro a prestado, si está disponible y lo agrega al registro de libros prestados.
     */
    fun resgistrarPrestamo(libro: Libro) {
        if (libro.estado == EstadoLibro.DISPONIBLE) {
            libro.estado = EstadoLibro.PRESTADO
            registroPrestamos.add(libro)
        } else {
            val text = ("El libro ${libro.titulo} no está disponible para préstamo.")
            IMPRIMIR_TEXTO(text)
        }
    }

    /**
     * Devolver libro:
     * Cambia el estado del libro a DISPONIBLE y lo elimina del registro de préstamos.
     */

    fun devolverLibro(libro: Libro) {
        if (libro.estado == EstadoLibro.PRESTADO) {
            val text = ("El libro \'${libro.titulo}\'no está prestado. No necesita devolución.")
            IMPRIMIR_TEXTO(text)
        } else {
            libro.estado = EstadoLibro.DISPONIBLE
            registroPrestamos.remove(libro)
        }
    }

    /**
     * Consultar disponibilidad
     * @param libro Libro Indica si el libro en cuestión está, o no, disponible para préstamo.
     */
    fun consultarDisponibilidad(libro: Libro): EstadoLibro {
        return libro.estado
    }

    /**
     * Retornar libros: en función de su estado: disponibles, prestados y todos.
     * @param catalogo List<Libro> Recibe el catalogo de libros
     */
    fun retornarLibros(catalogo: List<Libro>) {
        val librosDisponibles = (catalogo.filter { it.estado == EstadoLibro.DISPONIBLE }).joinToString { "\n" }
        val librosPrestados = catalogo.filter { it.estado == EstadoLibro.PRESTADO }.joinToString { "\n" }
        IMPRIMIR_TEXTO(
            "Nuestro catalogo completo:\n" +
                    "${catalogo.joinToString { "\n" }}\n" +
                    "Libros disponibles:\n" +
                    "$librosDisponibles\n" +
                    "Libros prestados:\n" +
                    librosPrestados
        )
    }
}