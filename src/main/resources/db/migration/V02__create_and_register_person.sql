
CREATE TABLE IF NOT EXISTS public.person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL,
    public_place VARCHAR(50) NOT NULL,
    number VARCHAR(50) NOT NULL,
    complement VARCHAR(50) NOT NULL,
    district VARCHAR(50) NOT NULL,
    zip_code VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL
);

INSERT INTO person (name, active, public_place, number, complement, district, zip_code, city, state) VALUES('Ruth', TRUE, 'Cuité', '100', 'Rua de Trás', 'Centro', '58289000', 'Cuité', 'Paraiba');
INSERT INTO person (name, active, public_place, number, complement, district, zip_code, city, state) VALUES('Ivete', TRUE, 'Cuité', '100', 'Rua de Trás', 'Centro', '58289000', 'Cuité', 'Paraiba');
INSERT INTO person (name, active, public_place, number, complement, district, zip_code, city, state) VALUES('Livia', TRUE, 'Cuité', '100', 'Rua de Trás', 'Centro', '58289000', 'Cuité', 'Paraiba');
INSERT INTO person (name, active, public_place, number, complement, district, zip_code, city, state) VALUES('Zito bomba', TRUE, 'Cuité', '100', 'Rua de Trás', 'Centro', '58289000', 'Cuité', 'Paraiba');