class GestorBiblioteca() {

    val catalogoLibros: MutableList<Libro> = mutableListOf()
    val registroPrestamos: MutableList<Libro> = mutableListOf()

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
            println("El libro ${libro.titulo} no está disponible para préstamo.")
        }
    }

    /**
     * Devolver libro:
     * Cambia el estado del libro a DISPONIBLE y lo elimina del registro de préstamos.
     */

    fun devolverLibro(libro: Libro) {
        if (libro.estado == EstadoLibro.PRESTADO) {
            println("El libro \'${libro.titulo}\'no está prestado. No necesita devolución.")
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
    fun retornarLibros(catalogo: List<Libro>): Triple<List<Libro>, List<Libro>, List<Libro>> {
        val librosDisponibles = catalogo.filter { it.estado == EstadoLibro.DISPONIBLE }
        val librosPrestados = catalogo.filter { it.estado == EstadoLibro.PRESTADO }
        return Triple(librosDisponibles, librosPrestados, catalogo)
    }

}