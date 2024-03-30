/**
 * Clase enumerada que muestra los dos posibles estados en los que se encuentran los libros: **PRESTADO** o **DISPONIBLE**
 */
enum class EstadoLibro {
    DISPONIBLE, PRESTADO;

    override fun toString(): String {
        return when (this) {
            DISPONIBLE -> "Disponible"
            PRESTADO -> "Prestado"
        }
    }
}