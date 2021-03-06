Необходимо написать приложение и тесты к нему согласно требованиям, приведенным ниже. В приложении должна быть реализована функциональность, определенная индивидуальным заданием. 
Требования
Пусть задание сформулировано следующим образом: «Круг. Разработать классы Точка и Круг. Создать методы и тесты: вычисления площади и периметра круга; является ли фигура кругом(радиус не может быть <=0); пересекает ли фигура только одну из осей координат на заданное расстояние.»

	Разработать entity-классы, например: «Разработать классы Точка (ВНУТРЕННИЙ КЛАСС) и Круг»
	Entity-классы не следует наполнять методами, выполняющими функциональные действия (методами бизнес-логики, такими как вычисление, поиск и т.д.).
	Разработать action-классы реализующие заданные функциональности, например: «Реализовать методы вычисления площади и периметра круга»
	Параметры, необходимые для создания объектов, организовать как чтение информации из файла (.txt). Часть данных должны некорректной. Если встретилась некорректная строка, приложение должно переходить к следующей строке. Все файлы должны находиться в отдельном каталоге.
	Для чтения из файла использовать только методы, появившиеся в Java8.
	Разработать validation-классы для проверки результатов вычислений параметров фигур, а также для валидации исходных данных для создания объектов entity-классов.
Например: корректная строка в файле для создания объекта Круг: «1.0 2.0 3.0», где первое число задает радиус круга, второе и третье – координаты центра;
некорректная строка в файле для создания объекта Круг: «1.z0 2.0 3.0» - недопустимый символ «z», всю строку следует считать некорректной здесь и в случаях приведенных ниже;
некорректная строка в файле для создания объекта Круг: «1.0 2.0» - недостаточно информации для создания объекта;
некорректная строка в файле для создания объекта Круг: «-1.0 2.0 3.0» - невозможно создать Круг с отрицательным радиусом.
	Для классов-сущностей следует переопределять методы класса Object: toString(), equals(), hashCode(). Методы класса Objects не использовать.
	При решении задачи для создания entity-классов можно использовать паттерн Factory Method.
	Все классы приложения должны быть структурированы по пакетам.
	Использовать собственные классы исключительных ситуаций.
	Оформление кода должно соответствовать Java Code Convention.
	Для записи логов использовать Log4J2.
	Код должен быть покрыт Unit-тестами. Использовать TestNG. При написании тестов запрещено: создавать неаннотированные методы, писать логи и использовать операторы ветвления: if, for, while, do\while, switch; использовать в тест-методе более одного Assert-метода.
	`Класс с методом main в задании должен отсутствовать. Запуск только тестами.
	Обратить внимание на примечания 1 и 2.



	
	Шар. Разработать классы Точка и Шар. Создать методы и тесты: вычисления площади поверхности шара, объема шара, соотношения объемов получаемых в результате рассечения шара координатной плоскостью; является ли объект шаром; касается ли шар любой из координатных плоскостей.

First Task KickStart Chapter B
Необходимо написать приложение и тесты к нему согласно требованиям, приведенным ниже. В приложении должна быть реализована функциональность, определенная индивидуальным заданием. 
Требования
	Все созданные объекты геометрических фигур сохранить в объекте-репозитории.
	Используя шаблон  Repository, разработать спецификации по добавлению, удалению и изменению объектов репозитория.
	Разработать спецификации по поиску объектов и групп объектов в репозитории. По ID, по имени, по координатам (например: найти все объекты точки которых находятся в первом квадранте, найти все объекты площади поверхности (объемы, периметры) которых заключены в заданный диапазон, найти объекты находящиеся на расстоянии в заданном диапазоне от начала координат)
	Разработать методы сортировки наборов объектов по ID, по имени, по координатам Х первой точки, по координатам Y первой точки и т д. Использовать интерфейс Comparator.
	
	Площади, Объемы, Периметры фигур должны храниться в объекте класса-регистратора. 
	Любое изменение параметра фигуры должно вызывать пересчет соответствующих значений в классе-регистраторе. 
Для решения данной задачи использовать паттерны Observer (можно использовать Flow API)  и Singleton (потокобезопасные варианты использовать запрещено).














Примечание 1: 
Для задач 4-8. Cекущие плоскости, фигуры и основания следует ориентировать в пространстве параллельно осям и плоскостям координат, чтобы формулы вычисления сечений и параметров фигур не были слишком сложными.
Примечание 2:
	После if всегда следует положительный сценарий, после else - отрицательный 
	Если только if, то возможен и отрицательный сценарий 
	В if, for, while обязательно использовать { }
	Если генерируется exception, не ловить его сразу же 
	В finally не генерировать исключения и не использовать return 
	Не генерировавать стандартные исключения. Разрешено только в методах private
	fileWriter.close(); - в блок finally
	Регулярные выражения в константы
	В именах пакетов не использовать большие буквы
	Не класть сторонние файлы в папки рядом или вместе с классами
	Размещать файлы только в папках в корне проекта
	Использовать для файлов только относительные пути. Папка src не должна присутствовать в пути к файлу
	Если константа неизменяемая, то имя должно быть в верхнем регистре, если изменяемая, то как правило именуется как обычное поле класса
	Элементы перечисления именуются как неизменяемые константы
	Не увлекаться статическими методами
	Не объявлять get-теры и set-теры абстрактными
	Не давать классам имена, совпадающие с именами стандартных классов и интерфейсов Java !
	
