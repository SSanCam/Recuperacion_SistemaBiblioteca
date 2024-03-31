import java.time.LocalDateTime

data class Prestamo(
    val libro: Libro,
    val usuario: Usuario,
    val fechaPrestamo: LocalDateTime,
    var fechaDevolucion: LocalDateTime?
) {
}