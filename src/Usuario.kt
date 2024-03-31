class Usuario(id: Int, nombre: String, librosPrestados: MutableList<Libro>) {

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
    val librosPrestados: MutableList<Libro> = librosPrestados

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun librosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }
}