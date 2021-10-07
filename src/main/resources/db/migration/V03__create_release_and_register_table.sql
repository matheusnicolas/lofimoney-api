CREATE TABLE IF NOT EXISTS public.release (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    value DECIMAL(10, 2) NOT NULL,
    note VARCHAR(100),
    type VARCHAR(20) NOT NULL,
    category_id integer NOT NULL,
    person_id integer NOT NULL,

    CONSTRAINT fk_category
        FOREIGN KEY(category_id)
            REFERENCES public.category(id),

    CONSTRAINT fk_person
        FOREIGN KEY(person_id)
            REFERENCES public.person(id)
);

-- CREATE SEQUENCE release_id_seq
--     INCREMENT 1
--     MINVALUE 1
--     MAXVALUE 9223372036854775807
--     START 1
--     CACHE 1;

-- ALTER TABLE release ALTER COLUMN id SET DEFAULT NEXTVAL('release_id_seq'::regclass);

INSERT INTO release(description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Viagem EUA', '2021-12-01', '2021-12-30', 6.500, 'Passeio Disney', 'DESPESA', 1, 1);
INSERT INTO release(description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Alimentação', '2021-12-01', '2021-12-30', 30.0, 'Lanche no Burger King', 'DESPESA', 2, 2);
INSERT INTO release(description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Supermercado', '2021-12-01', '2021-12-30', 2.000, 'Compras no supermercado', 'DESPESA', 3, 3);
INSERT INTO release(description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Salário', '2021-12-01', '2021-12-30', 5000, 'Dinheiro trabalho', 'RECEITA', 5, 1);
