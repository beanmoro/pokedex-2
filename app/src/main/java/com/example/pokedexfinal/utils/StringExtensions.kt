package cl.jumpitt.negociofacil.utils

import android.util.Patterns
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.clean(): String {
    return replace(".", "").replace("-", "")
}

//Date format from yyyy-MM-dd hh:mm:ss to regex input
fun String.dateFormat(regex: String): String {
    val formatter = SimpleDateFormat(regex, Locale.getDefault())
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return try {
        val date = inputFormatter.parse(this)
        return date?.let { formatter.format(date) } ?: ""
    } catch (e: java.lang.Exception) {
        "--"
    }
}

fun String.dateFormat(fromRegex: String, toRegex: String): String {
    val formatter = SimpleDateFormat(toRegex, Locale.getDefault())
    val inputFormatter = SimpleDateFormat(fromRegex, Locale.getDefault())
    return try {
        val date = inputFormatter.parse(this)
        date?.let { formatter.format(date) } ?: ""
    } catch (e: java.lang.Exception) {
        "--"
    }
}

fun String.toMillis(regex: String): Long {
    val inputFormatter = SimpleDateFormat(regex, Locale.getDefault())
    val date = inputFormatter.parse(this)
    return date?.time ?: 0
}

fun String.dateFormatPro(fromRegex: String): String {
    val currentMillis = System.currentTimeMillis()
    val dateMillis = this.toMillis(fromRegex)
    val differenceMillis = currentMillis - dateMillis
    val diffHours = differenceMillis / 1000 / 60 / 60

    return when {
        diffHours < 24 * 4 -> {
            val days: Int = (diffHours / 24).toInt()
            when (days) {
                1 -> {
                    "ayer"
                }
                0 -> {
                    "hoy"
                }
                else -> {
                    "hace ${diffHours / 24} días"
                }
            }
        }
        else -> this.dateFormat(fromRegex, "'el dd 'de' MMMM, yyyy")
    }
}

fun String.isChileanDNI(): Boolean {
    try {
        val rut = this.toUpperCase(Locale.getDefault())
            .replace(".", "")
            .replace("-", "")

        var rutAux = Integer.parseInt(rut.substring(0, rut.lastIndex))

        val dv = rut[rut.lastIndex]

        var m = 0
        var s = 1
        while (rutAux != 0) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11
            rutAux /= 10
        }
        if (dv == (if (s != 0) s + 47 else 75).toChar()) {
            return true
        }

    } catch (ignored: Exception) {
    }

    return false
}

fun Date.toRegex(regex: String): String {
    val formatter = SimpleDateFormat(regex, Locale.getDefault())
    return formatter.format(this)
}

fun String.isValidDNI(chilean: Boolean): Boolean {
    return if (chilean) {
        validateRut()
    } else {
        isNotEmpty()
    }
}

fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.formatDNI(chilean: Boolean): String {
    return if (chilean) formatChileanDNI()
    else this
}

private fun String.formatChileanDNI(): String {
    val clean = replace(".", "").replace("-", "")
    return if (clean.length > 1) {
        "${clean.substring(0, clean.lastIndex).numberFormatted()}-${clean.last()}"
    } else {
        clean
    }
}

fun String.numberFormatted(): String {
    return NumberFormat.getNumberInstance().format(this.toInt()).replace(",", ".")
}

fun Int.numberFormatted(): String {
    return NumberFormat.getNumberInstance().format(this).replace(",", ".")
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }

private fun String.validateRut(): Boolean {
    var rutLocal = this
    var validacion = false
    try {
        rutLocal = rutLocal.toUpperCase(Locale.getDefault())
        rutLocal = rutLocal.replace(".", "")
        rutLocal = rutLocal.replace("-", "")
        var rutAux = Integer.parseInt(rutLocal.substring(0, rutLocal.length - 1))

        val dv = rutLocal[rutLocal.length - 1]

        var m = 0
        var s = 1
        while (rutAux != 0) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11
            rutAux /= 10
        }
        if (dv == (if (s != 0) s + 47 else 75).toChar()) {
            validacion = true
        }

    } catch (e: java.lang.NumberFormatException) {
    } catch (e: Exception) {
    }

    return validacion
}

fun String.initials(): String {
    val split = split(" ")
    val splitSize = split.size
    return when {
        splitSize >= 3 -> "${split[2][0]}${split[0][0]}"
        splitSize == 2 -> "${split[1][0]}${split[0][0]}"
        splitSize == 1 -> if (split[0].isEmpty()) "--" else "${split[0][0]}"
        else -> "--"
    }
}


//ORDENAME THINGS
fun String.toState(): String {
    return when (this) {
        "delivered" -> "Pedido entregado"
        "preparation", "in_preparation" -> "Pedido en preparación"
        "ready_for_delivery", "ready" -> "Pedido está listo"
        "canceled" -> "Pedido cancelado"
        "rejected" -> "Pedido cancelado por almacén"
        else -> "Pendiente de confirmación"
    }
}

fun String.toStateMinify(): String {
    return when (this) {
        "delivered" -> "Entregado"
        "preparation", "in_preparation" -> "En preparación"
        "ready_for_delivery", "ready" -> "Listo"
        "canceled" -> "Cancelado"
        "rejected" -> "Rechazado"
        else -> "Pendiente"
    }
}
