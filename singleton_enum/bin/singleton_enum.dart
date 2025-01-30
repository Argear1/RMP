// Задача 1: Класс базы данных (Singleton)
class DatabaseConnection {
  static final DatabaseConnection _instance = DatabaseConnection._internal();

  factory DatabaseConnection() {
    return _instance;
  }

  DatabaseConnection._internal() {
    _connect();
  }

  void _connect() {
    print("Соединение с базой данных создано.");
  }
}

// Задача 2: Логирование в системе (Singleton)
class Logger {
  static final Logger _instance = Logger._internal();
  final List<String> _logs = [];

  factory Logger() {
    return _instance;
  }

  Logger._internal();

  void log(String message) {
    _logs.add(message);
    print("Лог: $message");
  }

  void showLogs() {
    print("Все логи:");
    for (var log in _logs) {
      print(log);
    }
  }
}

// Задача 3: Реализация статусов заказа
enum OrderStatus { NEW, IN_PROGRESS, DELIVERED, CANCELLED }

class Order {
  String orderId;
  OrderStatus status;

  Order(this.orderId) : status = OrderStatus.NEW;

  void changeStatus(OrderStatus newStatus) {
    if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
      print("Нельзя отменить доставленный заказ.");
      return;
    }

    status = newStatus;
    print("Статус заказа $orderId изменён на $status.");
  }

  void displayStatus() {
    print("Статус заказа $orderId: $status.");
  }
}

// Задача 4: Сезоны года
enum Season { WINTER, SPRING, SUMMER, AUTUMN }

String getSeasonName(Season season) {
  switch (season) {
    case Season.WINTER:
      return "Зима";
    case Season.SPRING:
      return "Весна";
    case Season.SUMMER:
      return "Лето";
    case Season.AUTUMN:
      return "Осень";
    default:
      return "Неизвестный сезон года";
  }
}


void main() {
  print("Задача 1: Подключение к базе данных");
  var db1 = DatabaseConnection();
  var db2 = DatabaseConnection();

  print(identical(db1, db2)); // true, оба ссылаются на один и тот же объект

  print("Задача 2: Логирование");
  var logger = Logger();

  logger.log("Первое сообщение");
  logger.log("Второе сообщение");

  logger.showLogs();

  print("Задача 3: Заказ");
  var order = Order("12345");

  order.displayStatus();
  order.changeStatus(OrderStatus.IN_PROGRESS);

  order.changeStatus(OrderStatus.DELIVERED);

  order.changeStatus(OrderStatus.CANCELLED);

  print("Задача 4: Сезоны года");
  var currentSeason = Season.AUTUMN;

  print("Текущий сезон: ${getSeasonName(currentSeason)}");
}
