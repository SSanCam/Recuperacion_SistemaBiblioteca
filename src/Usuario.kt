class Usuario(id: Int, nombre: String, val librosPrestados: MutableList<Libro> = mutableListOf()) {

    var id: Int = id
        set(value) {
            require(id.toString().isNotBlank()) { "Éste campo no puede quedar vacío." }
            field = value
        }
    var nombre: String = nombre
        set(value) {
            require(nombre.isNotBlank()) { "Éste campo no puede quedar vacío." }
            field = value
        }

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun librosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }

    override fun toString(): String {
        return "Usuario ID: $id - Nombre: $nombre - Libros Prestados: $librosPrestados"
    }
}