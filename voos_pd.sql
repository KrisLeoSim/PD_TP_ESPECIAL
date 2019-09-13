-- INSERT TABELA COMPANHIA

INSERT INTO public.companhia(
	id_companhia, nome_companhia)
	VALUES (66, 'tap');


-- INSERT TABELA LOCAL

INSERT INTO public.local(
	id_local, pais, cidade, descricao_local)
	VALUES (1, 'portugal', 'coimbra', 'cidade ...');


-- INSERT TABELA UTILIZADOR

INSERT INTO public."utilizador"(
	id_utilizador, username, password, primeiro_nome, ultimo_nome, nif, cc, passaporte, nacionalidade, data_nascimento, rua, n_porta, codigo_postal, localidade, distrito, pais, tipo_user, estado, data_ultimo_login)
	VALUES (1, 'joao', '1234', 'joão', 'antorio', '231498','123', '555', 'portuguesa', '2019/01/12', 'Rua ...', '5', '3030', 'coimbra', 'coimbra', 'Portugal', 'operador', null, null);


-- INSERT TABELA VOO

INSERT INTO public.voo(
	id_voo, id_agencia ,id_companhia, lugares_maximo, lugares_disponiveis, duracao_voo)
	VALUES (66,66,66, 300, 300, 55);



-- INSERT TABELA ITEM_CARRINHO

INSERT INTO public.item_carrinho(
	id_item_carrinho, id_utilizador, id_lugar, id_carrinho, valor_lugar, data_adicionado, estado)
	VALUES (88, 1, 1, 1, '2018-01-20' ,'pago');



-- INSERT TABELA CARTEIRA

INSERT INTO public.carteira(
	id_carteira, id_utilizador, "Montante")
	VALUES (1, 1, 500);


-- INSERT TABELA FEEDBACK

INSERT INTO public.feedback(
	id_feedback, id_utilizador, id_companhia, id_local, avaliacao)
	VALUES (1, 1, 1, 1, 8);


-- INSERT TABELA AGENCIA

INSERT INTO public.agencia(
	id_agencia, nome)
	VALUES (1, 'agencia_nome');


-- INSERT TABELA CHEGADA

INSERT INTO public.chegada(
	id_chegada, id_voo, id_local, data_chegada)
	VALUES (1, 1, 1, 20);


-- INSERT TABELA PARTIDA

INSERT INTO public.partida(
	id_chegada, id_voo, id_local, data_chegada)
	VALUES (1, 1, 1, 30);



-- INSERT TABELA LICITACAO

INSERT INTO public.licitacao(
	id_licitacao, id_utilizador, id_lugar, valor, data, estado)
	VALUES (1, 1, 1, 79.7, 120, 'pendente');



-- INSERT TABELA LUGAR

INSERT INTO public.lugar(
	id_lugar, id_voo, tipo, estado, preco_compra)
	VALUES (1, 1, 'tipo_lugar', 'comprado', 120);


-- INSERT TABELA MOVIMENTO
INSERT INTO public.movimento(
	id_movimento, id_carteira, valor, tipo_movimento, descricao_movimento, data, estado)
	VALUES (1, 1, 89, 'debito','descricao movimento', 55, 'efetuada');


-- INSERT TABELA COMPRA

INSERT INTO public.compra(
	id_compra, id_utilizador, id_lugar, valor, data, estado)
	VALUES (1, 1, 1, 33, 88, 'pendente');






