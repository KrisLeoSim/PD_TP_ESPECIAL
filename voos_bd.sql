-- Exported from QuickDBD: https://www.quickdatatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/FXclF4
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.

CREATE SEQUENCE "user_seq";

CREATE TABLE IF NOT EXISTS "user" (
    "id_user" int NOT NULL DEFAULT NEXTVAL ('user_seq'),
    "username" varchar(50)   NOT NULL,
    "password" varchar(200)   NOT NULL,
    "primeiro_nome" varchar(50)   NOT NULL,
    "ultimo_nome" varchar(50)   NOT NULL,
    "nif" int   NOT NULL,
    "morada" varchar(100)   NOT NULL,
    "tipo_user" varchar(50)   NOT NULL,
    "estado" int   NOT NULL,
    -- Estado é para saber se esta logado ou nao
    "data_ultimo_login" date   NOT NULL,
    CONSTRAINT "pk_user" PRIMARY KEY (
        "id_user"
     )
);

CREATE SEQUENCE "companhia_seq";
CREATE TABLE IF NOT EXISTS "companhia" (
    "id_companhia" int NOT NULL DEFAULT NEXTVAL ('companhia_seq'),
    "nome_companhia" varchar(200)   NOT NULL,
    "media_companhia" int   NOT NULL,
    CONSTRAINT "pk_companhia" PRIMARY KEY (
        "id_companhia"
     )
);

CREATE SEQUENCE "destino_seq";
CREATE TABLE IF NOT EXISTS "destinos" (
    "id_destino" int NOT NULL DEFAULT NEXTVAL ('destino_seq'),
    "pais" varchar(200)   NOT NULL,
    "cidade" varchar(200)   NOT NULL,
    "descricao_destino" varchar(200)   NOT NULL,
    "media_destino" int   NOT NULL,
    CONSTRAINT "pk_destinos" PRIMARY KEY (
        "id_destino"
     )
);

CREATE SEQUENCE "voo_seq";
CREATE TABLE IF NOT EXISTS "voo" (
    "id_voo" int NOT NULL DEFAULT NEXTVAL ('voo_seq'),
    "id_companhia" int   NOT NULL,
    "id_destino" int   NOT NULL,
    "lugares_maximo" int   NOT NULL,
    "lugares_disponiveis" int   NOT NULL,
    "preco_bilhete" money   NOT NULL,
    "data_partida" date   NOT NULL,
    "hora_partida" int   NOT NULL,
    "duracao_voo" int   NOT NULL,
    "maior_licitacao" money   NOT NULL,
    CONSTRAINT "pk_voo" PRIMARY KEY (
        "id_voo"
     )
);

CREATE SEQUENCE "carteira_seq";
CREATE TABLE IF NOT EXISTS "carteira" (
    "id_carteira" int NOT NULL DEFAULT NEXTVAL ('carteira_seq'),
    "Montante" money   NOT NULL,
    CONSTRAINT "pk_carteira" PRIMARY KEY (
        "id_carteira"
     )
);

CREATE SEQUENCE "movimento_seq";
CREATE TABLE IF NOT EXISTS "movimentos" (
    "id_movimento" int NOT NULL DEFAULT NEXTVAL ('movimento_seq'),
    "id_user" int   NOT NULL,
    "id_carteira" int   NOT NULL,
    "descricao_movimento" varchar(200)   NOT NULL,
    "data" date   NOT NULL,
    "hora" int   NOT NULL,
    CONSTRAINT "pk_movimentos" PRIMARY KEY (
        "id_movimento"
     )
);

CREATE SEQUENCE "carrinho_seq";
CREATE TABLE IF NOT EXISTS "carrinho" (
    "id_carrinho" int NOT NULL DEFAULT NEXTVAL ('carrinho_seq'),
    "id_user" int   NOT NULL,
    "id_voo" int   NOT NULL,
    "valor_total" money   NOT NULL,
    "numero_lugares" int   NOT NULL,
    "data_compra" date   NOT NULL,
    "estado_carrinho" varchar(50)   NOT NULL,
    "tipo_compra" varchar(50)   NOT NULL,
    CONSTRAINT "pk_carrinho" PRIMARY KEY (
        "id_carrinho"
     )
);

CREATE SEQUENCE "mensagem_seq";
CREATE TABLE IF NOT EXISTS "mensagens" (
    "id_mensagem" int NOT NULL DEFAULT NEXTVAL ('mensagem_seq'),
    "id_user_remetente" int   NOT NULL,
    "username_destinatario" varchar(50)   NOT NULL,
    "assunto" varchar(200)   NOT NULL,
    "mensagem" varchar(500)   NOT NULL,
    "data_mensagem" date   NOT NULL,
    "hora_mensagem" int   NOT NULL,
    CONSTRAINT "pk_mensagens" PRIMARY KEY (
        "id_mensagem"
     )
);

CREATE SEQUENCE "licitacao_seq";
CREATE TABLE IF NOT EXISTS "licitacoes" (
    "id_licitacao" int NOT NULL DEFAULT NEXTVAL ('licitacao_seq'),
    "id_user" int   NOT NULL,
    "id_voo" int   NOT NULL,
    "valor" money   NOT NULL,
    "data" date   NOT NULL,
    "hora" int   NOT NULL,
    "estado_licitacao" varchar(50)   NOT NULL,
    CONSTRAINT "pk_licitacoes" PRIMARY KEY (
        "id_licitacao"
     )
);

CREATE SEQUENCE "feedback_seq";
CREATE TABLE IF NOT EXISTS "feedback" (
    "id_feedback" int NOT NULL DEFAULT NEXTVAL ('feedback_seq'),
    "id_user" int   NOT NULL,
    "id_voo" int   NOT NULL,
    "classificacao_companhia" int   NOT NULL,
    "classificacao_destinos" int   NOT NULL,
    CONSTRAINT "pk_feedback" PRIMARY KEY (
        "id_feedback"
     )
);

ALTER TABLE "voo" ADD CONSTRAINT "fk_voo_id_companhia" FOREIGN KEY("id_companhia")
REFERENCES "companhia" ("id_companhia");

ALTER TABLE "voo" ADD CONSTRAINT "fk_voo_id_destino" FOREIGN KEY("id_destino")
REFERENCES "destinos" ("id_destino");

ALTER TABLE "movimentos" ADD CONSTRAINT "fk_movimentos_id_user" FOREIGN KEY("id_user")
REFERENCES "user" ("id_user");

ALTER TABLE "movimentos" ADD CONSTRAINT "fk_movimentos_id_carteira" FOREIGN KEY("id_carteira")
REFERENCES "carteira" ("id_carteira");

ALTER TABLE "carrinho" ADD CONSTRAINT "fk_carrinho_id_user" FOREIGN KEY("id_user")
REFERENCES "user" ("id_user");

ALTER TABLE "carrinho" ADD CONSTRAINT "fk_carrinho_id_voo" FOREIGN KEY("id_voo")
REFERENCES "voo" ("id_voo");

ALTER TABLE "mensagens" ADD CONSTRAINT "fk_mensagens_id_user_remetente" FOREIGN KEY("id_user_remetente")
REFERENCES "user" ("id_user");

ALTER TABLE "licitacoes" ADD CONSTRAINT "fk_licitacoes_id_user" FOREIGN KEY("id_user")
REFERENCES "user" ("id_user");

ALTER TABLE "licitacoes" ADD CONSTRAINT "fk_licitacoes_id_voo" FOREIGN KEY("id_voo")
REFERENCES "voo" ("id_voo");

ALTER TABLE "feedback" ADD CONSTRAINT "fk_feedback_id_user" FOREIGN KEY("id_user")
REFERENCES "user" ("id_user");

ALTER TABLE "feedback" ADD CONSTRAINT "fk_feedback_id_voo" FOREIGN KEY("id_voo")
REFERENCES "voo" ("id_voo");

