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
        fun AGREGAR_LIBRO(titulo: String, autor: String, publicacion: Int, tematica: String, estado: EstadoLibro) {
            val gestor = GestorBiblioteca()
            val catalogo = gestor.catalogoLibros
            val id = UtilidadesBiblioteca.GENERAR_ID_LIBRO()
            val nuevoLibro = Libro(UUID.fromString(id),titulo,autor,publicacion,tematica,estado)
            catalogo.add(nuevoLibro)
            val fechaRegistro = LocalDateTime.now()
            return IMPRIMIR_TEXTO(
                "El libro con ID \'$id\', se ha agregado con exito en: $fechaRegistro."
            )
        }

        fun IMPRIMIR_TEXTO(texto: Any) {
            println(texto)
        }
    }

}