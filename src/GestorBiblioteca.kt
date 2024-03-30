import java.time.LocalDateTime
import java.util.*

class GestorBiblioteca() {
    val catalogoLibros: MutableList<Libro> = mutableListOf()
    val registroPrestamos: MutableList<Libro> = mutableListOf()

    companion object {
        // Función con la que vamos a reemplazar println()
        fun IMPRIMIR_TEXTO(texto: Any) {
            val imprimir = println(texto)
            return imprimir
        }
    }

    /**
     * Agregar libro
     * @param titulo String Título del libro.
     * @param autor String Nombre del autor del libro.
     * @param publicacion Int Año de publicación del libro.
     * @param tematica String Nombre del género del libro.
     * @param estado EstadoLibro Indica si el libro se encuentre 'PRESTADO' o 'DISPONIBLE' para préstamo.
     */
    fun agregarLibro(libro: Libro) {
        val nuevaId = UtilidadesBiblioteca.GENERAR_ID_LIBRO()
        val fechaRegistro = LocalDateTime.now()
        libro.id = nuevaId
        catalogoLibros.add(libro)
        return IMPRIMIR_TEXTO(
            "El libro con ID \'$nuevaId\', se ha agregado con exito en: $fechaRegistro."
        )

    }


    /**
     * Eliminar libro:
     * Método que elimina un libro determinado del catálogo
     * @param libro Libro Libro a eliminar del catálogo.
     */
    fun eliminarLibro(libro: Libro) {
        val gestor = GestorBiblioteca()
        val catalogoLibros = gestor.catalogoLibros
        catalogoLibros.remove(libro)
        IMPRIMIR_TEXTO(
            "El libro ${libro.titulo} ha sido eliminado correctamente."
        )
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
            IMPRIMIR_TEXTO("El libro ${libro.titulo} no está disponible para préstamo.")
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
            IMPRIMIR_TEXTO("El libro con título \'${libro.titulo}\' ha sido devuelto correctamente.")
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

