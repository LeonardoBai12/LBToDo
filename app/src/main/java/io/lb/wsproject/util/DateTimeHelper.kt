package io.lb.wsproject.util

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.runtime.MutableState
import java.text.SimpleDateFormat
import java.util.*

fun timePicker(context: Context, time: MutableState<String>): TimePickerDialog {
    val calendar = Calendar.getInstance()

    return TimePickerDialog(
        context,
        {_, hour, minute ->
            time.value = timeToString(hour, minute)
        },
        calendar.get(Calendar.HOUR),
        calendar.get(Calendar.MINUTE),
        true
    )
}

fun datePicker(context: Context, date: MutableState<String>): DatePickerDialog {
    val calendar = Calendar.getInstance()

    return DatePickerDialog(
        context,
        { _, year, month, day ->
            date.value = dateToString(day, month, year)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
}

fun dateToString(
    day: Int,
    month: Int,
    year: Int,
): String {
    val date = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        .parse("$day-${month + 1}-$year")!!
    return SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(date)
}

fun timeToString(
    hour: Int,
    minute: Int,
): String {
    val date = SimpleDateFormat("HH:mm", Locale.ENGLISH)
        .parse("$hour:$minute")!!
    return SimpleDateFormat("HH:mm", Locale.ENGLISH).format(date)
}