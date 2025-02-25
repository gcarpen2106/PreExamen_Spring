# Ejercicio: Pokedex Innovadora

## Descripción General

Desarrolla una aplicación web en Java utilizando Spring Boot, Spring Data JPA y MySQL para gestionar una pokedex de Pokémon mejorada con nuevos campos. La aplicación deberá exponer 5 endpoints REST (2 GET, 1 PUT, 1 POST, 1 DELETE) que permitan realizar operaciones específicas utilizando JpaRepository.

## Estructura de la Base de Datos

### Entidad Pokémon
La entidad Pokémon incluirá los siguientes campos:
- `id` (Long, autogenerado) - Identificador único del Pokémon
- `name` (String, no nulo) - Nombre del Pokémon
- `type` (String, no nulo) - Tipo principal del Pokémon
- `hitPoints` (Long, no nulo) - Puntos de vida del Pokémon
- `level` (Integer, no nulo) - Nivel actual del Pokémon
- `evolution` (String, nullable) - Nombre de la evolución del Pokémon
- `captureRate` (Integer, no nulo) - Tasa de captura del Pokémon (0-255)
- `legendary` (Boolean, no nulo) - Indica si el Pokémon es legendario

## Requisitos Funcionales

### 1. Filtrado Avanzado de Pokémon
**Endpoint:** GET `/api/pokemons/advanced-filter`
- Parámetros: 
  - `type` (String): Tipo de Pokémon
  - `minLevel` (Integer): Nivel mínimo
  - `maxLevel` (Integer): Nivel máximo
- Devuelve la lista de Pokémon que coinciden con el tipo especificado y cuyo nivel está dentro del rango indicado.
- Ejemplo de uso: `/api/pokemons/advanced-filter?type=Fuego&minLevel=10&maxLevel=30`

### 2. Listar Pokémon Legendarios
**Endpoint:** GET `/api/pokemons/legendary`
- No requiere parámetros
- Devuelve la lista de todos los Pokémon legendarios (donde legendary = true).
- Ejemplo de uso: `/api/pokemons/legendary`

### 3. Actualizar Tasa de Captura
**Endpoint:** PUT `/api/pokemons/{id}/capture-rate`
- Parámetro de ruta: `id` (Long)
- Cuerpo de la solicitud:
  ```json
  {
    "captureRate": 120
  }
  ```
- Actualiza la tasa de captura de un Pokémon específico.
- Debe validar que la tasa esté en el rango 0-255.
- Devuelve el Pokémon actualizado.
- Ejemplo de uso: `PUT /api/pokemons/5/capture-rate` con el cuerpo JSON correspondiente

### 4. Registrar Evolución de Pokémon
**Endpoint:** POST `/api/pokemons/evolve`
- Cuerpo de la solicitud:
  ```json
  {
    "id": 1,
    "level": 10,
    "hitPoints": 20,
    "evolution": "Venusaur"
  }
  ```
- Actualiza un Pokémon con los nuevos valores y registra su evolución.
- Incrementa el nivel y los puntos de vida según los valores proporcionados.
- Actualiza el campo evolution con el nuevo valor.
- Devuelve el Pokémon actualizado.
- Ejemplo de uso: `POST /api/pokemons/evolve` con el cuerpo JSON correspondiente

### 5. Eliminar Pokémon (utilizando Optional)
**Endpoint:** DELETE `/api/pokemons/{id}`
- Parámetro de ruta: `id` (Long)
- Elimina un Pokémon por su ID
- Debe utilizar Optional para verificar si el Pokémon existe antes de eliminarlo
- Si el Pokémon no existe, devuelve un código de estado 404
- Si el Pokémon existe y se elimina correctamente, devuelve un código de estado 200 y un mensaje de éxito
- Ejemplo de uso: `DELETE /api/pokemons/10`

## Requisitos Técnicos

### Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── pokedex/
│   │           ├── controllers/
│   │           │   └── EjercicioPrexamen2Application.java
│   │           ├── models/
|   |           |   └── PokemonsDTO.java
│   │           │   └── Pokemons.java
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

### Configuración de la Base de Datos
En el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pokedex_innovadora
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

### Implementación del Repositorio
```java
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByTypeAndLevelBetween(String type, Integer minLevel, Integer maxLevel);
    List<Pokemon> findByLegendaryTrue();
    // Los métodos básicos CRUD son proporcionados automáticamente por JpaRepository
}
```

### Implementación del Servicio
El servicio debe implementar la lógica necesaria para:
1. Filtrar Pokémon por tipo y rango de nivel
2. Obtener Pokémon legendarios
3. Actualizar la tasa de captura de un Pokémon
4. Evolucionar un Pokémon
5. Eliminar un Pokémon utilizando Optional

### Implementación del Controlador
El controlador debe implementar los 5 endpoints requeridos y utilizar los servicios correspondientes.

## Criterios de Evaluación
1. Implementación correcta de los 5 endpoints requeridos
2. Uso adecuado de Optional en el endpoint DELETE
3. Correcta definición de la entidad con los nuevos campos
4. Uso de los métodos proporcionados por JpaRepository
5. Manejo adecuado de excepciones y códigos de respuesta HTTP
6. Validación de datos de entrada (por ejemplo, rango de captura)

## Población de Datos
Se proporciona un archivo `import.sql` con datos de ejemplo para probar la aplicación. Este archivo incluye varios Pokémon con información completa para todos los campos, incluyendo algunos Pokémon legendarios.