import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class UtilidadesBiblioteca {

    companion object {
        fun GENERAR_ID_LIBRO(): String {
            return UUID.randomUUID().toString()
        }
    }
}