# Ejercicio: Pokedex Innovadora

## Descripción General

Desarrolla una aplicación web en Java utilizando Spring Boot, Spring Data JPA y MySQL para gestionar una pokedex de Pokémon con funcionalidades innovadoras. La aplicación deberá exponer 5 endpoints REST específicos (2 GET, 1 POST, 1 PUT, 1 DELETE) que permitan realizar operaciones utilizando la misma estructura de base de datos que la Pokedex Extendida.

## Estructura de la Base de Datos

### Entidad Pokémon
La entidad Pokémon incluirá los siguientes campos:
- `id` (Long, autogenerado) - Identificador único del Pokémon
- `name` (String, no nulo) - Nombre del Pokémon
- `type` (String, no nulo) - Tipo principal del Pokémon
- `hitPoints` (Long, no nulo) - Puntos de vida del Pokémon
- `level` (Integer, no nulo) - Nivel actual del Pokémon

## Requisitos Funcionales

### 1. Listar Pokémon por Nivel Mínimo
**Endpoint:** GET `/api/pokemons/level/{minLevel}`
- Devuelve la lista de todos los Pokémon cuyo nivel sea igual o superior al especificado.
- Parámetro de ruta: `minLevel` (Integer)
- Debe devolver un código 404 si no se encuentra ningún Pokémon con nivel igual o superior al especificado.
- Ejemplo de uso: `GET /api/pokemons/level/25`

### 2. Buscar Pokémon por Nombre (Optional)
**Endpoint:** GET `/api/pokemons/search`
- Devuelve un Pokémon específico buscado por su nombre exacto.
- Parámetro de consulta: `name` (String)
- Debe devolver un `Optional<Pokemon>` y manejar correctamente el caso de que no exista.
- Ejemplo de uso: `GET /api/pokemons/search?name=Pikachu`

### 3. Registrar Evolución de Pokémon
**Endpoint:** POST `/api/pokemons/evolve`
- Registra la evolución de un Pokémon, aumentando su nivel y hitPoints.
- Espera un objeto JSON con:
  - `id` (Long): ID del Pokémon a evolucionar
  - `levelIncrement` (Integer): Incremento de nivel
  - `hitPointsIncrement` (Long): Incremento de puntos de vida
- Debe verificar que el Pokémon existe antes de procesarlo.
- Devuelve el Pokémon actualizado.
- Ejemplo de uso:
  ```json
  POST /api/pokemons/evolve
  Content-Type: application/json
  
  {
    "id": 1,
    "levelIncrement": 5,
    "hitPointsIncrement": 10
  }
  ```

### 4. Actualizar Tipo de Pokémon
**Endpoint:** PUT `/api/pokemons/{id}/type`
- Actualiza el tipo de un Pokémon existente.
- Parámetro de ruta: `id` (Long)
- Espera un objeto JSON con el campo `newType` (String).
- Devuelve el Pokémon con el tipo actualizado.
- Ejemplo de uso:
  ```json
  PUT /api/pokemons/7/type
  Content-Type: application/json
  
  {
    "newType": "Agua/Hielo"
  }
  ```

### 5. Eliminar Pokémon por Rango de Nivel
**Endpoint:** DELETE `/api/pokemons/range`
- Elimina todos los Pokémon cuyo nivel se encuentre dentro del rango especificado.
- Parámetros de consulta: 
  - `minLevel` (Integer)
  - `maxLevel` (Integer)
- Devuelve el número de Pokémon eliminados.
- Ejemplo de uso: `DELETE /api/pokemons/range?minLevel=10&maxLevel=20`

## Requisitos Técnicos

### Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── pokedex/
│   │           ├── controllers/
│   │           │   └── PokemonInnovationController.java
│   │           ├── models/
│   │           │   └── Pokemon.java
|   |           |   └── PokemonEvolutionRequest
│   │           ├── repositories/
│   │           │   └── PokemonRepository.java
│   │           ├── services/
│   │           │   ├── PokemonService.java
│   │           │   └── PokemonServiceImpl.java
│   │           └── PokedexInnovationApplication.java
│   └── resources/
│       ├── application.properties
│       └── import.sql
```

### Repositorio:
Implementa una interfaz `PokemonRepository` que extienda de `JpaRepository` y añade los métodos personalizados necesarios:
```java
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByLevelGreaterThanEqual(Integer minLevel);
    Optional<Pokemon> findByName(String name);
    int deleteByLevelBetween(Integer minLevel, Integer maxLevel);
}
```

### Servicio:
Implementa un servicio `PokemonInnovationService` que gestione todas las operaciones requeridas:
- Listar Pokémon por nivel mínimo
- Buscar Pokémon por nombre utilizando Optional
- Registrar evolución de Pokémon
- Actualizar tipo de Pokémon
- Eliminar Pokémon por rango de nivel

### Controlador:
Implementa un controlador `PokemonInnovationController` que exponga los 5 endpoints requeridos y maneje adecuadamente las respuestas HTTP.

## Configuración de la Base de Datos

En el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pokedex_innovadora
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

## Población de Datos

El archivo `import.sql` incluye datos de ejemplo para poblar la base de datos con una variedad de Pokémon, incluyendo diferentes tipos y niveles para probar todas las funcionalidades.

## Ejemplo de uso de Optional en el Servicio y Controlador

### Servicio:
```java
public Optional<Pokemon> findPokemonByName(String name) {
    return pokemonRepository.findByName(name);
}
```

### Controlador:
```java
@GetMapping("/search")
public ResponseEntity<?> getPokemonByName(@RequestParam String name) {
    Optional<Pokemon> pokemonOpt = pokemonService.findPokemonByName(name);
    
    return pokemonOpt.map(pokemon -> ResponseEntity.ok(pokemon))
            .orElse(ResponseEntity.notFound().build());
}
```

## Criterios de Evaluación

1. Implementación correcta de los 5 endpoints requeridos
2. Uso adecuado de Optional para manejar resultados que pueden ser nulos
3. Manejo correcto de excepciones y códigos de estado HTTP
4. Estructura adecuada del proyecto siguiendo las prácticas de Spring Boot
5. Implementación correcta de las consultas personalizadas en el repositorio
6. Validación básica de los datos de entrada