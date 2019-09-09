/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import java.util.ArrayList;
import logica.ControladorRemote;
import regras.negocio.entidade.AgenciaPojo;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.LocalPojo;
import regras.negocio.entidade.UtilizadorPojo;
import regras.negocio.entidade.VooPojo;

/**
 *
 * @author sergio
 */
public class Operador extends Menu {

    public Operador(ControladorRemote controladorEJB) {
        super(controladorEJB);
    }

    @Override
    protected void imprimeMenu() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Operador");
        System.out.println("  1  - Area de Gestão");
        System.out.println("  2  - Controlo do tempo");
        System.out.println("  3  - Consultar voos e ocupações");
        System.out.println("  4  - Consultar logs da aplicação");
        System.out.println("--------------------------");
        System.out.println("  0  - logout");
        System.out.println("--------------------------");
    }

    protected void imprimeMenuGestaoUtilizadores() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("GESTÂO DE UTILIZADORES");
        System.out.println("  1  - Registar utilizador");
        System.out.println("  2  - Remover utilizador");
        System.out.println("  3  - Editar utilizadores");
        System.out.println("  4  - Pedidos de registo pendentes");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }

    protected void imprimeMenuConsultarVoos() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Consultar voos");
        System.out.println("  1  - Listar voos");
        System.out.println("  2  - Listar voos activos");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }

    protected void imprimeMenuTempo() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("CONTROLO DO TEMPO");
        System.out.println("  1  - Tempo actual");
        System.out.println("  2  - Editar tempo");
        System.out.println("  3  - Alterar velocidade do tempo");

        if (controladorEJB.isTempoActivado()) {
            System.out.println("  4  - Parar tempo");
        } else {
            System.out.println("  4  - Activar tempo");
        }

        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }

    protected void imprimeMenuGestaoGeral() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("GESTÃO");
        System.out.println("  1  - Gestão de utilizadores");
        System.out.println("  2  - Gestão de voos");
        System.out.println("  3  - Gestão de locais");
        System.out.println("  4  - Gestão de companhias");
        System.out.println("  5  - Gestão de agencias");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }

    //crude imprime utilizador
    protected void imprimeMenuGestaoUtilizadores_Registar() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("REGISTAR");
        System.out.println("  1  - Cliente");
        System.out.println("  2  - Operador");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }

    protected void imprimeMenuGestaoUtilizadores_Editar() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("EDITAR");
        System.out.println("  1  - Username");
        System.out.println("  2  - Password");
        System.out.println("  3  - Cidade");
        System.out.println("  4  - Nif");
        System.out.println("--------------------------");
        System.out.println("  0  - Voltar");
        System.out.println("--------------------------");
    }

    public void cicloDeVidaGestaoUtilizadores_Registar() {
        boolean naoSairRegistar = true;

        try {
            while (naoSairRegistar) {
                imprimeMenuGestaoUtilizadores_Registar();

                opcao = obtemOpcaoMenu(3);

                switch (opcao) {
                    case 1:
                        registarCliente();
                        break;
                    case 2:
                        registarOperador();
                        break;
                    case 0:
                        naoSairRegistar = false;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //crude imprime locais
    protected void imprimeMenuGestaoLocal_Editar() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("EDITAR LOCAL");
        System.out.println("  1  - Pais");
        System.out.println("  2  - Cidade");
        System.out.println("  3  - Descrição");
        System.out.println("--------------------------");
        System.out.println("  0  - Voltar");
        System.out.println("--------------------------");
    }

    public void cicloDeVidaGestaoUtilizadores() {
        boolean naoSairUtilizador = true;

        try {
            while (naoSairUtilizador) {
                imprimeMenuGestaoUtilizadores();

                opcao = obtemOpcaoMenu(5);

                switch (opcao) {
                    case 1:
                        cicloDeVidaGestaoUtilizadores_Registar();
                        break;
                    case 2:
                        removerUtilizador();
                        break;
                    case 3:
                        editarUtilizadores();
                        break;
                    case 4:
                        ListaDeUtilizadoresComRegistoPendente();
                        break;
                    case 0:
                        //logout();
                        naoSairUtilizador = false;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    public void menuGestaoDeLocais() {
        boolean Sair = false;

        try {
            while (!Sair) {
                imprimeMenuGestaoUtilizadores();

                opcao = obtemOpcaoMenu(5);

                switch (opcao) {
                    case 1:
                        registarLocal();
                        break;
                    case 2:
                        removerLocal();
                        break;
                    case 3:
                        editarLocal();
                        break;
                    case 0:
                        Sair = !true;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    public void menuGestaoGeral() {
        boolean Sair = false;

        try {
            while (!Sair) {
                imprimeMenuGestaoGeral();

                opcao = obtemOpcaoMenu(6);

                switch (opcao) {
                    case 1:
                        cicloDeVidaGestaoUtilizadores();
                        break;
                    case 2:

                        break;
                    case 3:
                        menuGestaoDeLocais();
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 0:

                        Sair = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    public void menuTempo() {
        boolean Sair = false;

        try {
            while (!Sair) {
                imprimeMenuTempo();

                opcao = obtemOpcaoMenu(5);

                switch (opcao) {
                    case 1:
                        obtemTempoActual();
                        break;
                    case 2:
                        alteraTempo();
                        break;
                    case 3:
                        alteraVelocidadeDoTempo();
                        break;
                    case 4:
                        if (controladorEJB.isTempoActivado()) {
                            controladorEJB.paraTempo();
                        } else {
                            controladorEJB.activarTempo();
                        }
                        break;
                    case 0:
                        Sair = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuConsularVoos() {
        boolean Sair = false;

        try {
            while (!Sair) {
                imprimeMenuConsultarVoos();

                opcao = obtemOpcaoMenu(3);

                switch (opcao) {
                    case 1:
                        ListarVoos();
                        break;
                    case 2:
                        ListarVoosActivos();
                        break;
                    case 0:
                        Sair = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int cicloDeVida() {
        int estado = ESTADO_OPERADOR;
        try {
            while (naoSair) {
                imprimeMenu();
                opcao = obtemOpcaoMenu(5);

                switch (opcao) {
                    case 1:
                        menuGestaoGeral();
                        break;
                    case 2:
                        menuTempo();
                        break;
                    case 3:
                        menuConsularVoos();
                        break;
                    case 4:

                        break;
                    case 0:
                        naoSair = false;
                        estado = ESTADO_VISITANTE;
                        System.out.println("Operador log out");
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
        }
        return estado;
    }

    //Tempo
    private void obtemTempoActual() {
        System.out.print("Tempo actual: " + controladorEJB.tempoAtual());
    }

    private void alteraTempo() {

        int tempo = 0;
        System.out.print("Novo tempo: ");
        tempo = sc.nextInt();
        controladorEJB.alteraTempo(tempo);
    }

    private void alteraVelocidadeDoTempo() {
        System.out.println("Intervalo de velocidade aceite: [1-30]");
        System.out.print("Nova velocidade de tempo: ");
        int tempo = sc.nextInt();

        if (tempo >= 1 && tempo <= 30) {
            controladorEJB.alteraTempo(tempo);
        } else {
            System.out.println("entre [1-30] se faz favor");
        }
    }

    //Listar Utilizadores
    public ArrayList<UtilizadorPojo> ListarUtilizadores() {

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  UTILIZADORES ");
        System.out.println("--------------------------");

        ArrayList<UtilizadorPojo> lista_utilizadores = controladorEJB.listaClientes();

        int i = 1;
        for (UtilizadorPojo utilizadorPojo : lista_utilizadores) {

            System.out.println(" " + i + "-" + utilizadorPojo.getUsername() + " tipo:" + utilizadorPojo.getTipoUser());
            i++;

        }

        if (lista_utilizadores.isEmpty()) {
            System.out.println("Não tem Utilizadores");
        }

        return lista_utilizadores;
    }

    public void ListaDeUtilizadoresComRegistoPendente() {

        try {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  UTILIZADORES QUE AGUARDAM APROVAÇÂO ");
            System.out.println("--------------------------------------");

            ArrayList<UtilizadorPojo> lista_utilizadores = controladorEJB.listaContasQueAguardamAprovação();
            int i = 1;
            for (UtilizadorPojo utilizadorPojo : lista_utilizadores) {

                System.out.println(" " + i + "-" + utilizadorPojo.getUsername() + " tipo:" + utilizadorPojo.getTipoUser());
                i++;

            }

            if (!lista_utilizadores.isEmpty()) {
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
                --opcao;
                if (opcao != -1) {

                    UtilizadorPojo utilizadorPojo = lista_utilizadores.get(opcao);
                    utilizadorPojo.setEstado(1);

                    controladorEJB.actualizaUtilizadorEstado(utilizadorPojo);

                }

            } else {
                System.out.println("Não tem pedido pendentes");
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }

    }

    public ArrayList<VooPojo> ListarVoos() {

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  VOOS ");
        System.out.println("--------------------------");

        ArrayList<VooPojo> lista_voos = controladorEJB.listaVoos();

        int i = 1;
        for (VooPojo vooPojo : lista_voos) {

            System.out.println(" " + i + "- Agencia: " + vooPojo.getIdAgencia().getNome()
                    + " companhia: " + vooPojo.getIdCompanhia().getNome()
                    + " lugares MAX: " + vooPojo.getLugaresMaximo()
                    + " lugares Disponiveis: " + vooPojo.getLugaresDisponiveis()
                    + " duracao: " + vooPojo.getDuracaoVoo());
            System.out.println(" PARTIDA - Tempo:" + vooPojo.getLista_partidas().get(0).getDataPartida());
            System.out.println(" CHEGADA - Tempo:" + vooPojo.getLista_chegadas().get(0).getDataChegada());
            i++;
        }

        if (lista_voos.isEmpty()) {
            System.out.println("Não tem Voos");
        }

        return lista_voos;
    }

    public ArrayList<VooPojo> ListarVoosActivos() {

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  VOOS ACTIVOS");
        System.out.println("--------------------------");

        ArrayList<VooPojo> lista_voos = controladorEJB.listaVoos();
        int tempoactual = controladorEJB.tempoAtual();

        int i = 1;
        for (VooPojo vooPojo : lista_voos) {
            int tempopartida = vooPojo.getLista_partidas().get(0).getDataPartida();
            int tempochegada = vooPojo.getLista_chegadas().get(0).getDataChegada();

            if (tempopartida <= tempoactual && tempochegada <= tempoactual) {
                System.out.println(" " + i + "- Agencia: " + vooPojo.getIdAgencia().getNome()
                        + " companhia: " + vooPojo.getIdCompanhia().getNome()
                        + " lugares MAX: " + vooPojo.getLugaresMaximo()
                        + " lugares Disponiveis: " + vooPojo.getLugaresDisponiveis()
                        + " duracao: " + vooPojo.getDuracaoVoo());
                System.out.println(" CHEGADA - Tempo:" + vooPojo.getLista_chegadas().get(0).getDataChegada());
                i++;
            }
        }

        if (lista_voos.isEmpty()) {
            System.out.println("Não tem Voos activos");
        }

        return lista_voos;
    }

    //Listar Locais
    public ArrayList<LocalPojo> ListarLocais() {

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  LOCAIS ");
        System.out.println("--------------------------");

        ArrayList<LocalPojo> lista_locais = controladorEJB.listaLocais();

        int i = 1;
        for (LocalPojo localPojo : lista_locais) {

            System.out.println(" " + i + "- Pais: " + localPojo.getPais() + " | cidade: " + localPojo.getCidade());
            System.out.println("descrição: " + localPojo.getDescricaoLocal());
            i++;

        }

        if (lista_locais.isEmpty()) {
            System.out.println("Não tem locais");
        }

        return lista_locais;
    }

    //Listar companhias
    public ArrayList<CompanhiaPojo> ListarCompanhias() {

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  COMPANHIAS ");
        System.out.println("--------------------------");

        ArrayList<CompanhiaPojo> lista_companhia = controladorEJB.listaCompanhias();

        int i = 1;
        for (CompanhiaPojo companhiaPojo : lista_companhia) {

            System.out.println(" " + i + "- Companhia: " + companhiaPojo.getNome());
            i++;

        }

        if (lista_companhia.isEmpty()) {
            System.out.println("Não tem Companhias");
        }

        return lista_companhia;
    }

    //Listar agencias 
    public ArrayList<AgenciaPojo> ListarAgencias() {

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  AGENCIAS ");
        System.out.println("--------------------------");

        ArrayList<AgenciaPojo> lista_agencias = controladorEJB.listaAgencias();

        int i = 1;
        for (AgenciaPojo agenciaPojo : lista_agencias) {

            System.out.println(" " + i + "- Agencia: " + agenciaPojo.getNome());
            i++;

        }

        if (lista_agencias.isEmpty()) {
            System.out.println("Não tem Agencias");
        }

        return lista_agencias;
    }

    //Crud utilizador
    private void editarUtilizadores() {
        try {

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  EDITAR UTILIZADORES  ");
            System.out.println("--------------------------------------");

            ArrayList<UtilizadorPojo> lista_utilizadores = ListarUtilizadores();

            if (!lista_utilizadores.isEmpty()) {
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
                --opcao;
                if (opcao != -1) {

                    UtilizadorPojo utilizadorPojo = lista_utilizadores.get(opcao);
                    imprimeMenuGestaoUtilizadores_Editar();

                    opcao = obtemOpcaoMenu(5);

                    switch (opcao) {
                        case 1:
                            System.out.print("username: ");
                            String username = sc.nextLine();
                            utilizadorPojo.setUsername(username);
                            break;
                        case 2:
                            System.out.print("password: ");
                            String password = sc.nextLine();
                            utilizadorPojo.setPassword(password);
                            break;
                        case 3:
                            System.out.print("cidade: ");
                            String cidade = sc.nextLine();
                            utilizadorPojo.setPais(cidade);
                        case 4:
                            System.out.print("nif: ");
                            String nif = sc.next();
                            utilizadorPojo.setNif(nif);
                            break;

                    }

                    if (controladorEJB.editarUtilizador(utilizadorPojo)) {
                        System.out.print("Editou COM sucesso");
                    } else {
                        System.out.print("Não foi possivel editar");
                    }
                }

            } else {
                System.out.println("Não ha utilizadores");
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }

    }

    private void removerUtilizador() {

        try {

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  UTILIZADORES  ");
            System.out.println("--------------------------------------");

            ArrayList<UtilizadorPojo> lista_utilizadores = ListarUtilizadores();

            if (!lista_utilizadores.isEmpty()) {
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
                --opcao;
                if (opcao != -1) {

                    int id = lista_utilizadores.get(opcao).getIdUtilizador();

                    if (controladorEJB.apagaUtilizador(id)) {
                        System.out.print("Apagou COM sucesso");
                    } else {
                        System.out.print("Não foi possivel apagar");
                    }
                }

            } else {
                System.out.println("Não ha utilizadores");
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void registarCliente() {
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  REGISTAR CLIENTE");
            System.out.println("--------------------------");
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            String password = sc.nextLine();
            System.out.print("nif: ");
            String nif = sc.next();
            //TODO fazer verificaçao do nif
            System.out.println();
            if (controladorEJB.registarUtilizador(username, password, nif)) {
                System.out.print("Registou COM sucesso");
            } else {
                System.out.print("Não registou");
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void registarOperador() {
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  REGISTAR OPERADOR");
            System.out.println("--------------------------");
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            String password = sc.nextLine();
            System.out.print("nif: ");
            String nif = sc.next();
            //TODO fazer verificaçao do nif
            System.out.println();
            if (controladorEJB.registarUtilizador(username, password, nif)) {
                System.out.print("Registou COM sucesso");
            } else {
                System.out.print("Não registou");
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    //crud locais
    private void editarLocal() {
        try {

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  EDITAR LOCAL  ");
            System.out.println("--------------------------------------");

            ArrayList<LocalPojo> lista_locais = ListarLocais();

            if (!lista_locais.isEmpty()) {
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_locais.size());
                --opcao;
                if (opcao != -1) {

                    LocalPojo localPojo = lista_locais.get(opcao);
                    imprimeMenuGestaoLocal_Editar();

                    opcao = obtemOpcaoMenu(4);

                    switch (opcao) {
                        case 1:
                            System.out.print("pais: ");
                            String pais = sc.nextLine();
                            localPojo.setPais(pais);
                            break;
                        case 2:
                            System.out.print("cidade: ");
                            String cidade = sc.nextLine();
                            localPojo.setCidade(cidade);
                            break;
                        case 3:
                            System.out.print("descrição: ");
                            String descricao = sc.nextLine();
                            localPojo.setDescricaoLocal(descricao);
                    }

                    if (controladorEJB.editarLocal(localPojo)) {
                        System.out.print("Editou COM sucesso");
                    } else {
                        System.out.print("Não foi possivel editar");
                    }
                }

            } else {
                System.out.println("Não ha locais");
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }

    }

    private void removerLocal() {
        /*
        try {

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  UTILIZADORES  ");
            System.out.println("--------------------------------------");

            ArrayList<UtilizadorPojo> lista_utilizadores = ListarUtilizadores();

            if (!lista_utilizadores.isEmpty()) {
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
                --opcao;
                if (opcao != -1) {

                    int id = lista_utilizadores.get(opcao).getIdUtilizador();

                    if (controladorEJB.apagaUtilizador(id)) {
                        System.out.print("Apagou COM sucesso");
                    } else {
                        System.out.print("Não foi possivel apagar");
                    }
                }

            } else {
                System.out.println("Não ha utilizadores");
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }
         */
    }

    private void registarLocal() {
        /*try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  REGISTAR LOCAL");
            System.out.println("--------------------------");
            System.out.print("pais: ");
            String pais = sc.nextLine();
            System.out.print("cidade: ");
            String cidade = sc.nextLine();
            System.out.print("descrição: ");
            String descricao = sc.nextLine();

            System.out.println();
            if (controladorEJB.registarLocal(Localpojo)) {
                System.out.print("Registou COM sucesso");
            } else {
                System.out.print("Não registou");
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace(System.out);
        }*/
    }
}
