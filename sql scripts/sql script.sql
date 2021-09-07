CREATE TABLE public.autores (
	id_autor serial NOT NULL,
	nome varchar NULL,
	email varchar NULL,
	dt_nascimento date NULL,
	mini_curriculo varchar NULL,
	CONSTRAINT autores_pkey PRIMARY KEY (id_autor)
);