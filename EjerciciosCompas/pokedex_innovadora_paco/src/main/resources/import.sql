-- Insertar datos de Pokémon
INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Pikachu', 'Eléctrico', 35, 25, 6.0, 'Kanto', 2, 40, 'Ash', 35, 20);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Charizard', 'Fuego', 78, 36, 90.5, 'Kanto', 3, 78, 'Ash', 78, 15);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Bulbasaur', 'Planta', 45, 15, 6.9, 'Kanto', 1, 49, 'Profesor Oak', 45, 25);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Gyarados', 'Agua', 95, 40, 235.0, 'Kanto', 2, 79, 'Misty', 95, 18);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Mewtwo', 'Psíquico', 106, 70, 122.0, 'Kanto', 1, 90, 'Entrenador Desconocido', 106, 22);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Gengar', 'Fantasma', 60, 45, 40.5, 'Kanto', 3, 60, 'Agatha', 60, 30);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Dragonite', 'Dragón', 91, 55, 210.0, 'Kanto', 3, 95, 'Lance', 91, 15);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Snorlax', 'Normal', 160, 50, 460.0, 'Kanto', 1, 65, 'Rojo', 160, 10);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Vaporeon', 'Agua', 130, 35, 29.0, 'Kanto', 2, 60, 'Pueblo Paleta', 130, 25);

INSERT INTO pokemons (name, type, hit_points, level, weight, region, evolution_number, defense, trainer, ps, pp) 
VALUES ('Machamp', 'Lucha', 90, 45, 130.0, 'Kanto', 3, 80, 'Bruno', 90, 20);

-- Insertar habilidades para cada Pokémon
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (1, 'Impactrueno');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (1, 'Ataque Rápido');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (1, 'Rayo');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (2, 'Lanzallamas');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (2, 'Garra Dragón');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (2, 'Vuelo');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (3, 'Látigo Cepa');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (3, 'Rayo Solar');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (3, 'Placaje');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (4, 'Hidrobomba');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (4, 'Cascada');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (4, 'Hiperrayo');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (5, 'Psíquico');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (5, 'Confusión');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (5, 'Barrera');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (6, 'Bola Sombra');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (6, 'Pesadilla');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (6, 'Hipnosis');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (7, 'Furia Dragón');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (7, 'Ala de Acero');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (7, 'Puño Fuego');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (8, 'Golpe Cuerpo');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (8, 'Descanso');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (8, 'Ronquido');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (9, 'Hidropulso');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (9, 'Rayo Aurora');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (9, 'Niebla');

INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (10, 'Tiro Vital');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (10, 'Sumisión');
INSERT INTO pokemons_abilities (pokemon_id, abilities) VALUES (10, 'Puño Dinámico');

-- Insertar ataques especiales para cada Pokémon
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (1, 'Tacleada de Voltios');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (1, 'Bola Voltio');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (2, 'Anillo Ígneo');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (2, 'Giro Fuego');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (3, 'Planta Feroz');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (3, 'Bomba Germen');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (4, 'Hidrobomba');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (4, 'Vendaval');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (5, 'Bola Neblina');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (5, 'Psicocorte');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (6, 'Come Sueños');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (6, 'Puño Sombra');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (7, 'Cometa Draco');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (7, 'Enfado');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (8, 'Terremoto');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (8, 'Hiperrayo');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (9, 'Hidrocañón');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (9, 'Última Baza');

INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (10, 'Golpe Cruz');
INSERT INTO pokemons_special_attacks (pokemon_id, special_attacks) VALUES (10, 'Puño Incremento');