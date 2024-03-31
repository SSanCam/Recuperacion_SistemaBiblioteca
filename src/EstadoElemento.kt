enum class EstadoElemento {
    DISPONIBLE, PRESTADO;

    override fun toString(): String {
        return when (this) {
            DISPONIBLE -> "Disponible"
            PRESTADO -> "Prestado"
        }
    }
}