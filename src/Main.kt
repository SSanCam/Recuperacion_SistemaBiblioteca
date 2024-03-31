import java.util.*

/**
 * Programa principal
 */
fun main() {

    fun printText(texto: Any): String{
        val imprimir = println(texto)
        return imprimir.toString()
    }
    // Crear instancia del GestorBiblioteca
    val gestor = GestorBiblioteca()
    val prestamo = RegistroPrestamos()
    // Crear algunos libros y los agregamos al catálogo:
    val libro1 = Libro(UUID.randomUUID().toString(), "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula")
    val libro2 = Libro(UUID.randomUUID().toString(), "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    val libro3 = Libro(UUID.randomUUID().toString(), "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela")
    val libro4 = Libro(UUID.randomUUID().toString(), "El Aleph", "Jorge Luis Borges", 1949, "Cuentos")
    val libro5 = Libro(UUID.randomUUID().toString(), "1984", "George Orwell", 1949, "Ciencia ficción")

    // Agregar libros al catálogo
    gestor.agregarLibro(libro1)
    gestor.agregarLibro(libro2)
    gestor.agregarLibro(libro3)
    gestor.agregarLibro(libro4)
    gestor.agregarLibro(libro5)
    // Creamos varios usuarios
    val usuario1 = Usuario(1, "Hermenegildo")
    val usuario2 = Usuario(2,"Encarnita de Graná")

    // Registramos préstamos
    prestamo.registrarPrestamo(libro1, usuario1)
    prestamo.registrarPrestamo(libro3, usuario1)
    prestamo.registrarPrestamo(libro5, usuario2)
    prestamo.registrarPrestamo(libro4, usuario2)

    // Devolver un libro
    gestor.devolverLibro(libro1)
    prestamo.devolverLibro(libro1)

    // Préstamo erróneo
    gestor.registrarPrestamo(libro3, usuario2)
    prestamo.registrarPrestamo(libro3, usuario2)
    // Devolución errónea
    gestor.devolverLibro(libro4)
    prestamo.devolverLibro(libro4)

    // Retornar libros según estado
    val todosLosLibros = gestor.catalogoLibros
    gestor.retornarLibros(todosLosLibros)

    // Registro de préstamos y devoluciones.
    val registro = RegistroPrestamos()
    val historico = registro.historialPrestamos.toList()
    val prestamosActuales = registro.prestamosActuales.toList()
    printText("Histórico de préstamos:\n")
    printText(historico)
    printText("Histórico de préstamos actuales:\n")
    printText(prestamosActuales)

    // Información de los usuarios
    printText(usuario1)
    printText(usuario2)

    // Histórico préstamos Usuario1
    val prestamos = RegistroPrestamos()
    printText(prestamos.consultarHistorialUsuario(usuario1))

    // Histórico de préstamos
    val historicoPrestamos = registro.historialPrestamos
    printText(historicoPrestamos)
}
