interface GestorPrestamos {
    fun registrarPrestamo(libro: Libro, usuario: Usuario)
    fun devolverLibro(libro: Libro)
    fun consultarHistorial(usuario: Usuario): List<Prestamo>
}