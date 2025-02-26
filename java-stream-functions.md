# Guía Completa de Java Stream API

Java Stream API, introducida en Java 8, permite el procesamiento de colecciones de datos de manera declarativa. A continuación, se presentan las funciones más comunes y útiles de esta API, organizadas por categoría.

## Índice
1. [Creación de Streams](#creación-de-streams)
2. [Operaciones Intermedias](#operaciones-intermedias)
3. [Operaciones Terminales](#operaciones-terminales)
4. [Operaciones de Recolección (Collectors)](#operaciones-de-recolección-collectors)
5. [Streams Primitivos](#streams-primitivos)
6. [Ejemplos Prácticos](#ejemplos-prácticos)

## Creación de Streams

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `Collection.stream()` | Crea un stream a partir de una colección | `List<String> list = Arrays.asList("a", "b"); Stream<String> stream = list.stream();` |
| `Stream.of()` | Crea un stream con los elementos especificados | `Stream<Integer> stream = Stream.of(1, 2, 3);` |
| `Arrays.stream()` | Crea un stream a partir de un array | `int[] array = {1, 2, 3}; IntStream stream = Arrays.stream(array);` |
| `Stream.iterate()` | Crea un stream infinito mediante iteración | `Stream<Integer> stream = Stream.iterate(0, n -> n + 1);` |
| `Stream.generate()` | Crea un stream infinito mediante un proveedor | `Stream<Double> stream = Stream.generate(Math::random);` |
| `Files.lines()` | Crea un stream de las líneas de un archivo | `Stream<String> stream = Files.lines(Paths.get("file.txt"));` |

## Operaciones Intermedias

Las operaciones intermedias transforman un stream en otro stream. Son perezosas (lazy), es decir, no se ejecutan hasta que se invoca una operación terminal.

### Filtrado

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `filter()` | Filtra elementos según un predicado | `stream.filter(s -> s.length() > 2)` |
| `distinct()` | Elimina elementos duplicados | `stream.distinct()` |
| `limit()` | Limita el tamaño del stream | `stream.limit(10)` |
| `skip()` | Salta los primeros n elementos | `stream.skip(5)` |

### Transformación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `map()` | Transforma cada elemento | `stream.map(String::toUpperCase)` |
| `flatMap()` | Aplana streams anidados en uno solo | `stream.flatMap(s -> Arrays.stream(s.split("")))` |
| `mapToInt()` | Convierte a IntStream | `stream.mapToInt(String::length)` |
| `mapToLong()` | Convierte a LongStream | `stream.mapToLong(User::getId)` |
| `mapToDouble()` | Convierte a DoubleStream | `stream.mapToDouble(Product::getPrice)` |

### Ordenación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `sorted()` | Ordena elementos | `stream.sorted()` |
| `sorted(Comparator)` | Ordena con un comparador | `stream.sorted(Comparator.comparing(String::length))` |

### Inspección

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `peek()` | Ejecuta una acción en cada elemento sin modificar el stream | `stream.peek(System.out::println)` |

## Operaciones Terminales

Las operaciones terminales producen un resultado o un efecto secundario. Después de ejecutar una operación terminal, el stream se considera consumido.

### Búsqueda y Coincidencia

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `findFirst()` | Devuelve el primer elemento | `Optional<String> first = stream.findFirst();` |
| `findAny()` | Devuelve cualquier elemento | `Optional<String> any = stream.findAny();` |
| `anyMatch()` | Verifica si algún elemento cumple un predicado | `boolean match = stream.anyMatch(s -> s.contains("a"));` |
| `allMatch()` | Verifica si todos los elementos cumplen un predicado | `boolean match = stream.allMatch(s -> s.length() > 0);` |
| `noneMatch()` | Verifica si ningún elemento cumple un predicado | `boolean match = stream.noneMatch(s -> s.isEmpty());` |

### Reducción

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `count()` | Cuenta los elementos | `long count = stream.count();` |
| `max()` | Encuentra el máximo según un comparador | `Optional<String> max = stream.max(Comparator.naturalOrder());` |
| `min()` | Encuentra el mínimo según un comparador | `Optional<String> min = stream.min(Comparator.naturalOrder());` |
| `reduce()` | Reduce a un solo valor combinando elementos | `Optional<Integer> sum = stream.reduce((a, b) -> a + b);` |
| `reduce(identity, accumulator)` | Reduce con valor inicial | `int sum = stream.reduce(0, (a, b) -> a + b);` |
| `reduce(identity, accumulator, combiner)` | Reduce paralelo | `int sum = stream.reduce(0, Integer::sum, Integer::sum);` |

### Iteración

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `forEach()` | Realiza una acción para cada elemento | `stream.forEach(System.out::println);` |
| `forEachOrdered()` | Como forEach pero respeta el orden | `stream.forEachOrdered(System.out::println);` |

### Conversión

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `toArray()` | Convierte a array | `Object[] array = stream.toArray();` |
| `toArray(IntFunction)` | Convierte a array del tipo especificado | `String[] array = stream.toArray(String[]::new);` |
| `collect()` | Acumula elementos en una colección u otro resultado | `List<String> list = stream.collect(Collectors.toList());` |

## Operaciones de Recolección (Collectors)

La clase `Collectors` proporciona métodos de fábrica para operaciones de recolección comunes.

### Convertir a Colecciones

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `toList()` | Recolecta elementos en una Lista | `List<String> list = stream.collect(Collectors.toList());` |
| `toSet()` | Recolecta elementos en un Conjunto | `Set<String> set = stream.collect(Collectors.toSet());` |
| `toCollection()` | Recolecta en una colección específica | `LinkedList<String> list = stream.collect(Collectors.toCollection(LinkedList::new));` |
| `toMap()` | Recolecta en un Mapa | `Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));` |

### Agrupación y Partición

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `groupingBy()` | Agrupa por una función de clasificación | `Map<Character, List<String>> map = stream.collect(Collectors.groupingBy(s -> s.charAt(0)));` |
| `groupingBy()` con downstream | Agrupa con un collector secundario | `Map<Character, Long> map = stream.collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));` |
| `partitioningBy()` | Particiona según un predicado | `Map<Boolean, List<String>> map = stream.collect(Collectors.partitioningBy(s -> s.length() > 2));` |

### Agregación

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `counting()` | Cuenta elementos | `Long count = stream.collect(Collectors.counting());` |
| `summingInt()` | Suma valores int | `Integer sum = stream.collect(Collectors.summingInt(String::length));` |
| `averagingInt()` | Calcula promedio de valores int | `Double avg = stream.collect(Collectors.averagingInt(String::length));` |
| `joining()` | Concatena strings | `String joined = stream.collect(Collectors.joining(", "));` |
| `maxBy()` | Encuentra el máximo según un comparador | `Optional<String> max = stream.collect(Collectors.maxBy(Comparator.naturalOrder()));` |
| `minBy()` | Encuentra el mínimo según un comparador | `Optional<String> min = stream.collect(Collectors.minBy(Comparator.naturalOrder()));` |

### Estadísticas

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `summarizingInt()` | Estadísticas de valores int | `IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(String::length));` |
| `summarizingLong()` | Estadísticas de valores long | `LongSummaryStatistics stats = stream.collect(Collectors.summarizingLong(User::getId));` |
| `summarizingDouble()` | Estadísticas de valores double | `DoubleSummaryStatistics stats = stream.collect(Collectors.summarizingDouble(Product::getPrice));` |

### Collectors Personalizados

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `reducing()` | Reducción generalizada | `Optional<String> longest = stream.collect(Collectors.reducing((s1, s2) -> s1.length() > s2.length() ? s1 : s2));` |
| `mapping()` | Aplica una función antes de recolectar | `List<Integer> lengths = stream.collect(Collectors.mapping(String::length, Collectors.toList()));` |
| `collectingAndThen()` | Aplica una función después de recolectar | `List<String> unmodifiableList = stream.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));` |

## Streams Primitivos

Java proporciona streams especializados para tipos primitivos para evitar el autoboxing/unboxing.

### IntStream

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `IntStream.range()` | Crea un stream de ints en un rango (exclusivo) | `IntStream stream = IntStream.range(1, 5); // 1, 2, 3, 4` |
| `IntStream.rangeClosed()` | Crea un stream de ints en un rango (inclusivo) | `IntStream stream = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5` |
| `average()` | Calcula el promedio | `OptionalDouble avg = intStream.average();` |
| `sum()` | Calcula la suma | `int sum = intStream.sum();` |
| `max()` | Encuentra el máximo | `OptionalInt max = intStream.max();` |
| `min()` | Encuentra el mínimo | `OptionalInt min = intStream.min();` |
| `summaryStatistics()` | Obtiene estadísticas | `IntSummaryStatistics stats = intStream.summaryStatistics();` |

### LongStream y DoubleStream

Proporcionan funcionalidades similares a IntStream pero para tipos `long` y `double`.

## Ejemplos Prácticos

### Ejemplo 1: Procesamiento de una lista de personas

```java
List<Person> persons = getPersons();

// Encontrar la edad promedio de personas mayores de 18 años
double averageAge = persons.stream()
    .filter(p -> p.getAge() > 18)
    .mapToInt(Person::getAge)
    .average()
    .orElse(0);

// Agrupar personas por ciudad
Map<String, List<Person>> personsByCity = persons.stream()
    .collect(Collectors.groupingBy(Person::getCity));

// Encontrar la persona más joven y la más vieja
Optional<Person> youngest = persons.stream()
    .min(Comparator.comparing(Person::getAge));
    
Optional<Person> oldest = persons.stream()
    .max(Comparator.comparing(Person::getAge));

// Contar personas por grupo de edad
Map<String, Long> countByAgeGroup = persons.stream()
    .collect(Collectors.groupingBy(
        p -> {
            if (p.getAge() < 18) return "Menor";
            else if (p.getAge() < 60) return "Adulto";
            else return "Senior";
        },
        Collectors.counting()
    ));
```

### Ejemplo 2: Procesamiento de archivos

```java
// Contar líneas en un archivo
long lineCount;
try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
    lineCount = lines.count();
}

// Contar palabras únicas en un archivo
long uniqueWords;
try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
    uniqueWords = lines
        .flatMap(line -> Arrays.stream(line.split("\\s+")))
        .filter(word -> !word.isEmpty())
        .map(String::toLowerCase)
        .distinct()
        .count();
}
```

### Ejemplo 3: Combinación de operaciones

```java
// Obtener los 3 productos más caros de cada categoría
Map<String, List<Product>> top3ProductsByCategory = products.stream()
    .collect(Collectors.groupingBy(
        Product::getCategory,
        Collectors.collectingAndThen(
            Collectors.toList(),
            productList -> productList.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList())
        )
    ));
```

### Ejemplo 4: Operaciones con Optional

```java
// Operaciones con Optional (relacionado con streams)
Optional<String> optionalValue = Optional.of("value");

// map
String upperCaseValue = optionalValue.map(String::toUpperCase).orElse("");

// filter
Optional<String> filteredValue = optionalValue.filter(s -> s.length() > 3);

// flatMap
Optional<Integer> length = optionalValue.flatMap(s -> Optional.of(s.length()));

// orElse vs orElseGet
String value1 = optionalValue.orElse(getDefaultValue()); // getDefaultValue() siempre se ejecuta
String value2 = optionalValue.orElseGet(() -> getDefaultValue()); // getDefaultValue() se ejecuta solo si es necesario
```

## Características Avanzadas

### Streams Paralelos

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `parallel()` | Convierte un stream secuencial en paralelo | `stream.parallel().forEach(System.out::println);` |
| `parallelStream()` | Crea un stream paralelo desde una colección | `List<String> list = Arrays.asList("a", "b"); Stream<String> stream = list.parallelStream();` |
| `sequential()` | Convierte un stream paralelo en secuencial | `stream.parallel().filter(x -> x > 10).sequential().forEach(System.out::println);` |

### Método orElse en Optional

Los métodos que devuelven `Optional` (como `findFirst()`, `findAny()`, `min()`, `max()`, `reduce()`, etc.) ofrecen varias formas de manejar el caso cuando no hay valor:

| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `orElse()` | Devuelve el valor o un valor predeterminado | `String value = optional.orElse("default");` |
| `orElseGet()` | Devuelve el valor o calcula un valor predeterminado | `String value = optional.orElseGet(() -> computeDefault());` |
| `orElseThrow()` | Devuelve el valor o lanza una excepción | `String value = optional.orElseThrow(NoSuchElementException::new);` |
| `ifPresent()` | Ejecuta una acción si hay un valor | `optional.ifPresent(System.out::println);` |
| `ifPresentOrElse()` | Ejecuta una acción si hay un valor, otra si no | `optional.ifPresentOrElse(System.out::println, () -> System.out.println("No value"));` |

## Mejores Prácticas

1. **Usar operaciones intermedias para filtrar temprano**: Filtrar primero reduce el número de elementos a procesar.
2. **Evitar operaciones sin estado cuando sea posible**: Operaciones como `sorted()` requieren procesar todos los elementos.
3. **Considerar streams paralelos para grandes conjuntos de datos**: Pueden mejorar el rendimiento con colecciones grandes.
4. **Evitar efectos secundarios en operaciones de stream**: Las funciones deben ser puras para evitar comportamientos inesperados.
5. **No modificar la fuente durante el procesamiento del stream**: Puede llevar a `ConcurrentModificationException`.
6. **Cerrar streams conectados a recursos externos**: Usar try-with-resources para streams de archivos, etc.
7. **Usar métodos de referencia cuando sea posible**: `Person::getName` en lugar de `person -> person.getName()`.

## Conclusión

La API Stream de Java ofrece un paradigma de programación funcional poderoso para procesar colecciones de manera eficiente y expresiva. Mediante el uso adecuado de operaciones intermedias y terminales, se pueden realizar transformaciones complejas de datos con menos código y mayor legibilidad.
