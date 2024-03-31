import java.time.LocalDateTime

class RegistroPrestamos(
    var prestamosActuales: MutableMap<Libro, Usuario> = mutableMapOf(),
    val historialPrestamos: MutableList<Prestamo> = mutableListOf()
) {

    fun registrarPrestamo(libro: Libro, usuario: Usuario) {
        prestamosActuales[libro] = usuario
        historialPrestamos.add(Prestamo(libro, usuario, LocalDateTime.now(), null))
    }

    fun devolverLibro(libro: Libro) {
        val prestamo = historialPrestamos.findLast { it.libro == libro && it.fechaDevolucion == null }
        if (prestamo != null) {
            prestamo.fechaDevolucion = LocalDateTime.now()
        }
        prestamosActuales.remove(libro)
    }

    fun consultarHistorialLibro(libro: Libro): List<Prestamo> {
        return historialPrestamos.filter { it.libro == libro }
    }

    fun consultarHistorialUsuario(usuario: Usuario): List<Prestamo> {
        val listaLibros = (historialPrestamos.filter { it.usuario == usuario }).toList()
        return listaLibros
    }


}

