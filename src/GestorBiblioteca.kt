class GestorBiblioteca() {

    val catalogoLibros: MutableList<Libro> = mutableListOf()
    val registroPrestamos: MutableList<Libro> = mutableListOf()
    /**
     * Agregar libro:
     * @param libro Libro Es es libro que va a agregarse al catálogo.
     */
    fun agregarLibro(libro: Libro) {
        catalogoLibros.add(libro)
    }

    /**
     * Eliminar libro:
     * Método que elimina un libro determinado del catálogo
     * @param libro Libro Libro a eliminar del catálogo.
     */
    fun eliminarLibro(libro: Libro) {
        catalogoLibros.remove(libro)
    }

    /**
     * Registar préstamo:
     * Cambia el estado del libro a prestado si está disponible.
     */
    fun resgistrarPrestamo(libro: Libro) {
        if (libro.estado == EstadoLibro.DISPONIBLE){
            libro.estado = EstadoLibro.PERSTADO
            registroPrestamos.add(libro)
        }else{
            "El libro ${libro.titulo} no está disponible para préstamo."
        }
    }

    /**
     * Devolver libro:
     * Cambia el estado del libro a DISPONIBLE y lo elimina del registro de préstamos.
     */

    fun devolverLibro(libro: Libro) {
        libro.estado = EstadoLibro.DISPONIBLE
        registroPrestamos.remove(libro)
    }

    /**
     * Consultar disponibilidad
     * @param libro Libro Indica si el libro en cuestión está, o no, disponible para préstamo.
     */
    fun consultarDisponibilidad(libro: Libro): EstadoLibro {
        return libro.estado
    }
}