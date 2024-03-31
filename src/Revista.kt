class Revista(editorial: String, id: String, titulo: String, estado: EstadoElemento) :
    ElementoBiblioteca(id, titulo, estado), Prestable {
    companion object {
        fun printText(text: Any) {
            val imprimir = println(text)
            return imprimir
        }
    }

    var editorial: String = editorial
        set(value) {
            require(editorial.isNotBlank()) { "La editorial necesita nombrarse." }
            field = value
        }
    override var id: String = id
        set(value) {
            require(id.isNotEmpty()) { "El número identificativo de la revista debe quedar reflejado." }
            field = value
        }
    override var titulo: String = titulo
        set(value) {
            require(titulo.isNotBlank()) { "La revista debe contener un título." }
            field = value
        }

    override var estado: EstadoElemento = estado
        set(value) {
            require(estado in EstadoElemento.values()) { "Los estados disponibles sólo pueden ser *DISPONIBLE* o *PRESTADO*" }
            field = value
        }

    fun obtenerEstado(revista: Revista): EstadoElemento {
        return estado
    }

    override fun prestar() {
        estado = EstadoElemento.PRESTADO
        printText("La revista \'$titulo\' ha sido prestada correctamente.")
    }

    override fun devolver() {
        estado = EstadoElemento.DISPONIBLE
        printText("La revista \'$titulo\' ha sido devuelta correctamente.")
    }

}