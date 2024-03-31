open class GestorElementos<T : ElementoBiblioteca> {
    private fun printText(text: Any) {
        val imprimir = println(text)
        return imprimir
    }

    private val elementos: MutableList<T> = mutableListOf()
    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    fun eliminarElemento(id: String) {
        val elemento = elementos.findLast { it.id == id }
        elemento?.let {
            elementos.remove(it)
        }
    }

    fun obtenerElementos() {
        return printText(elementos)
    }

    fun filtrarCriterio(criterio: (elemento: T) -> Boolean): List<T> {
        return (elementos.filter(criterio))
    }
}