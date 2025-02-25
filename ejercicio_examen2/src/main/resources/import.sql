-- Script de importación para Pokedex Innovadora con campos adicionales
-- Pokémon de tipo Planta
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Bulbasaur', 'Planta', 45, 5, 'Ivysaur', 45, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Ivysaur', 'Planta', 60, 16, 'Venusaur', 30, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Venusaur', 'Planta', 80, 32, null, 15, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Oddish', 'Planta/Veneno', 45, 7, 'Gloom', 50, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Gloom', 'Planta/Veneno', 60, 21, 'Vileplume', 35, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Vileplume', 'Planta/Veneno', 75, 42, null, 20, false);

-- Pokémon de tipo Fuego
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Charmander', 'Fuego', 39, 5, 'Charmeleon', 45, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Charmeleon', 'Fuego', 58, 16, 'Charizard', 30, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Charizard', 'Fuego/Volador', 78, 36, null, 15, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Vulpix', 'Fuego', 38, 8, 'Ninetales', 40, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Ninetales', 'Fuego', 73, 25, null, 25, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Growlithe', 'Fuego', 55, 10, 'Arcanine', 35, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Arcanine', 'Fuego', 90, 30, null, 20, false);

-- Pokémon de tipo Agua
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Squirtle', 'Agua', 44, 5, 'Wartortle', 45, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Wartortle', 'Agua', 59, 16, 'Blastoise', 30, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Blastoise', 'Agua', 79, 36, null, 15, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Psyduck', 'Agua', 50, 12, 'Golduck', 40, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Golduck', 'Agua', 80, 28, null, 25, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Poliwag', 'Agua', 40, 6, 'Poliwhirl', 50, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Poliwhirl', 'Agua', 65, 18, 'Poliwrath', 30, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Poliwrath', 'Agua/Lucha', 90, 33, null, 20, false);

-- Pokémon de tipo Eléctrico
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Pikachu', 'Eléctrico', 35, 12, 'Raichu', 35, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Raichu', 'Eléctrico', 60, 28, null, 20, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Magnemite', 'Eléctrico/Acero', 25, 8, 'Magneton', 40, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Magneton', 'Eléctrico/Acero', 50, 26, null, 25, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Voltorb', 'Eléctrico', 40, 15, 'Electrode', 35, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Electrode', 'Eléctrico', 60, 30, null, 20, false);

-- Pokémon de tipo Psíquico
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Abra', 'Psíquico', 25, 8, 'Kadabra', 45, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Kadabra', 'Psíquico', 40, 22, 'Alakazam', 30, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Alakazam', 'Psíquico', 55, 38, null, 15, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Drowzee', 'Psíquico', 60, 15, 'Hypno', 40, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Hypno', 'Psíquico', 85, 29, null, 25, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Mewtwo', 'Psíquico', 106, 70, null, 3, true);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Mew', 'Psíquico', 100, 65, null, 5, true);

-- Pokémon de tipo Bicho
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Caterpie', 'Bicho', 45, 3, 'Metapod', 60, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Metapod', 'Bicho', 50, 7, 'Butterfree', 45, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Butterfree', 'Bicho/Volador', 60, 15, null, 30, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Weedle', 'Bicho/Veneno', 40, 3, 'Kakuna', 60, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Kakuna', 'Bicho/Veneno', 45, 7, 'Beedrill', 45, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Beedrill', 'Bicho/Veneno', 65, 15, null, 30, false);

-- Pokémon de tipo Hielo
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Articuno', 'Hielo/Volador', 90, 55, null, 3, true);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Jynx', 'Hielo/Psíquico', 65, 32, null, 25, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Lapras', 'Agua/Hielo', 130, 40, null, 20, false);

-- Pokémon de tipo Roca
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Geodude', 'Roca/Tierra', 40, 10, 'Graveler', 50, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Graveler', 'Roca/Tierra', 55, 25, 'Golem', 35, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Golem', 'Roca/Tierra', 80, 40, null, 20, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Onix', 'Roca/Tierra', 35, 22, null, 30, false);

-- Pokémon de tipo Fantasma
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Gastly', 'Fantasma/Veneno', 30, 15, 'Haunter', 40, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Haunter', 'Fantasma/Veneno', 45, 28, 'Gengar', 25, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Gengar', 'Fantasma/Veneno', 60, 42, null, 15, false);

-- Pokémon de tipo Dragón
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Dratini', 'Dragón', 41, 15, 'Dragonair', 35, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Dragonair', 'Dragón', 61, 30, 'Dragonite', 20, false);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Dragonite', 'Dragón/Volador', 91, 55, null, 10, false);

-- Pokémon Legendarios adicionales
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Zapdos', 'Eléctrico/Volador', 90, 60, null, 3, true);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Moltres', 'Fuego/Volador', 90, 60, null, 3, true);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Lugia', 'Psíquico/Volador', 106, 70, null, 3, true);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Ho-Oh', 'Fuego/Volador', 106, 70, null, 3, true);
INSERT INTO pokemons (name, type, hit_points, level, evolution, capture_rate, legendary) VALUES ('Celebi', 'Psíquico/Planta', 100, 60, null, 5, true);