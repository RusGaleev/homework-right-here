fun main() {
    var time: Int = 12 * 60 * 60 // in sec
    print("был(а) ${doPluralFormOfTime(agoToText(time), time)}")
}

fun agoToText(time: Int): String {
    if (time < 0) {
        return ""
    }
    return when (time) {
        in 0..60 -> "sec"
        in 61..60 * 60 -> "min"
        in (60 * 60 + 1)..(24 * 60 * 60) -> "hour"
        in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> "today"
        in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> "yesterday"
        else -> "long"
    }
}

fun doPluralFormOfTime(str: String, time: Int): String {
    return when (str) {
        "sec" -> {
            "только что"
        }
        "min" -> {
            when (time / 60 % 10) {
                0, 5, 6, 7, 8, 9 -> "${time / 60} минут назад"
                1 -> "${time / 60} минуту назад"
                2, 3, 4 -> "${time / 60} минуты назад"
                else -> ""
            }
        }
        "hour" -> {
            when (time / 60 / 60 % 100) {
                11, 12, 13, 14 -> "${time / 60 / 60} часов назад"
                else -> when (time / 60 / 60 % 10) {
                    0, 5, 6, 7, 8, 9 -> "${time / 60 / 60} часов назад"
                    1 -> "${time / 60 / 60} час назад"
                    2, 3, 4 -> "${time / 60 / 60} часа назад"
                    else -> ""
                }
            }
        }
        "today" -> "сегодня"
        "yesterday" -> "вчера"
        else -> "давно"
    }
}