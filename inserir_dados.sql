-- INSERT TABELA COMPANHIA
	
INSERT INTO public.companhia(
	id_companhia, nome_companhia, media_companhia)
	VALUES (1, 'tap', 14.5);
	
	
	
-- INSERT TABELA DESTINOS
	
INSERT INTO public.destinos(
	id_destino, pais, cidade, descricao_destino, media_destino)
	VALUES (1, 'portugal', 'coimbra', 'cidade ...', 17.8);
	



-- INSERT TABELA USER

INSERT INTO public."user"(
	id_user, username, password, primeiro_nome, ultimo_nome, nif, morada, tipo_user, estado, data_ultimo_login)
	VALUES (1, 'joao', '1234', 'joão', 'antorio', '231498', 'rua da casa', 'operador', 1, '2019/01/12');

	
	
-- INSERT TABELA VOO

INSERT INTO public.voo(
	id_voo, id_companhia, id_destino, lugares_maximo, lugares_disponiveis, preco_bilhete, data_partida, hora_partida, duracao_voo, maior_licitacao)
	VALUES (1, 1, 1, 400, 380, 199.99, '2019/02/17', 50, 2, 5.2);
	
	
	
-- INSERT TABELA CARRINHO

INSERT INTO public.carrinho(
	id_carrinho, id_user, id_voo, valor_total, numero_lugares, data_compra, estado_carrinho, tipo_compra)
	VALUES (1, 1, 1, 299.99, 4, '2018-01-20' ,'pago', 'normal');
	
	
	
-- INSERT TABELA CARTEIRA	

INSERT INTO public.carteira(
	id_carteira, "Montante")
	VALUES (1, 500);
	
	

-- INSERT TABELA FEEDBACK
	
INSERT INTO public.feedback(
	id_feedback, id_user, id_voo, classificacao_companhia, classificacao_destinos)
	VALUES (1, 1, 1, 18, 16);
	

-- INSERT TABELA LICITACOES
	
INSERT INTO public.licitacoes(
	id_licitacao, id_user, id_voo, valor, data, hora, estado_licitacao)
	VALUES (1, 1, 1, 79.7, '2019-01-23', 25, 'pendente');
	
	
-- INSERT TABELA mensagem
	
INSERT INTO public.mensagens(
	id_mensagem, id_user_remetente, username_destinatario, assunto, mensagem, data_mensagem, hora_mensagem)
	VALUES (1, 1, 'joao', 'assunto', 'mensagem é esta', '2018/08/09', 10);
	

-- INSERT TABELA movimentos	
INSERT INTO public.movimentos(
	id_movimento, id_user, id_carteira, descricao_movimento, data, hora)
	VALUES (1, 1, 1, 'descricao movimento', '2018/07/10', 24);
	
	
	
	
	
	