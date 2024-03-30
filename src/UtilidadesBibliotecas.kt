import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class UtilidadesBiblioteca {

    companion object {
        fun GENERAR_ID_LIBRO(): String {
            return UUID.randomUUID().toString()
        }

        /**
         * Agregar libro
         * @param titulo String Título del libro.
         * @param autor String Nombre del autor del libro.
         * @param publicacion Int Año de publicación del libro.
         * @param tematica String Nombre del género del libro.
         * @param estado EstadoLibro Indica si el libro se encuentre 'PRESTADO' o 'DISPONIBLE' para préstamo.
         */

        fun IMPRIMIR_TEXTO(texto: Any) {
            println(texto)
        }
    }

}