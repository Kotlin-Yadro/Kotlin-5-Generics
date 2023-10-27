# Kotlin-7 - Generics
Код к занятию Kotlin-7 - Generics

## Домашнее задание
В папке [network](src/main/kotlin/ru/kotlin/homework/network) находится прототип класса
результата работы сетевого сервиса `NetworkResponse`, который может быть:

- `Success` - для удачного результата
- `Failure` - для ошибки

### Задание 1.
Исправьте определение классов так, чтобы все присваивания под определениями компилировались
без ошибок. Подсказки:

- Используйте declaration type variance
- Мы только ВОЗВРАЩАЕМ результат или ошибку (ковариантность по обоим параметрам)
- Вспоминаем, что тип Nothing - это подтип любого другого типа

### Задание 2.
Почините (правильно расставьте variance параметров) класс [NetworkLogger](src/main/kotlin/ru/kotlin/homework/network/NetworkLogger.kt)
таким образом, чтобы **один** универсальный экземпляр логгера можно было использовать для логирования любых ошибок:

- `processThrowables` принимает `ErrorLogger<Throwable>`
- `processApiErrors` принимает `ErrorLogger<ApiException>`

Приступайте ко второму заданию только после окончания работы над первым!

### Задание 3 (со звездочкой)
Сделайте так, чтобы [NetworkLogger](src/main/kotlin/ru/kotlin/homework/network/NetworkLogger.kt) имел возможность выдать список
накопленных ошибок. Настройте типы таким образом, чтобы при сохранении условий заданий 1 и 2, в классе появилась функция:
```kotlin
fun dump(): List<Pair<LocalDateTime, E>>
```