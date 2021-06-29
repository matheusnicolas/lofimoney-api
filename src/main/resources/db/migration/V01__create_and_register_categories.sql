DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS public.category (
    code SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

INSERT INTO category (name) VALUES('Lazer');
INSERT INTO category (name) VALUES('Alimentação');
INSERT INTO category (name) VALUES('Supermercado');
INSERT INTO category (name) VALUES('Farmácia');
INSERT INTO category (name) VALUES('Outros');
