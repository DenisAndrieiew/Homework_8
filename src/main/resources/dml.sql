INSERT INTO roles (identifier, role)
VALUES (gen_random_uuid(),, 'ROLE_USER'),
(gen_random_uuid(),, 'ROLE_ADMIN');


INSERT INTO manufacturers
(identifier, manufacturer_name)
VALUES
(gen_random_uuid(), 'carpentry cut down with an ax'),
(gen_random_uuid(), 'Iron forge metalwork'),
(gen_random_uuid(), 'Luxury Jewelery');


INSERT INTO products
(identifier, product_name, product_cost, manufacturer_id)
VALUES
(gen_random_uuid(), 'Rusty nail', 10,
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'Iron forge metalwork')),
(gen_random_uuid(), 'Iron rail', 600,
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'Iron forge metalwork')),

(gen_random_uuid(), 'Uncomfortable chair', '50',
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'carpentry cut down with an ax')),
(gen_random_uuid(), 'wooden frame', 30,
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'carpentry cut down with an ax')),
(gen_random_uuid(), 'splintered table', 100,
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'carpentry cut down with an ax')),

(gen_random_uuid(), 'Golden ring', 1000,
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'Luxury Jewelery')),
(gen_random_uuid(), 'precious necklace', 2000,
(SELECT identifier FROM manufacturers WHERE manufacturer_name = 'Luxury Jewelery')),