class Catalogo<T : ElementoBiblioteca> : GestorElementos<T>() {
    fun buscarPorTitulo(titulo: String): List<T> {
        return filtrarCriterio { it.titulo == titulo }
    }

    fun buscarPorEstado(estadoElemento: EstadoElemento): List<T> {
        return filtrarCriterio { it.estado == estadoElemento }
    }

    fun buscarPorId(id: String): List<T> {
        return filtrarCriterio { it.id == id }
    }
}