import java.time.Year
/**
 * Clase que representa un libro en la biblioteca.
 * @property id El ID único del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property publicacion El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado actual del libro.
 * @throws IllegalArgumentException Si el autor o el título están vacíos.
 * @throws IllegalArgumentException Si el año de publicación es superior al año actual.
 */
class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val publicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
) {

    init {
        require(autor.isNotBlank()) { "Éste campo no puede estar vacío." }
        require(titulo.isNotBlank()) { "Éste campo no puede estar vacío." }
        require(publicacion <= Year.now().value) { "El año de publicación, de un libro ya en el mercado, no puede ser superior al actual." }
    }

}