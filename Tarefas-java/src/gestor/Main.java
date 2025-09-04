package gestor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int opcao;
        

        do {
            System.out.println("\n==== GESTOR DE TAREFAS ====");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Listar Tarefas");
            System.out.println("3 - Concluir Tarefa");
            System.out.println("4 - Remover Tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 
            
            switch (opcao) {
            	
                case 1:
                    System.out.print("Digite a descrição: ");
                    String desc = sc.nextLine();
                    
                    System.out.println("\n==== DEFINA A PRIORIDADE DA TAREFA ====");
                    System.out.println("1 - Baixa");
                    System.out.println("2 - Média");
                    System.out.println("3 - Alta");
                    System.out.print("Escolha: ");
                    int opcao_prioridade = sc.nextInt();
                    sc.nextLine();
                    
                    String prioridade = switch (opcao_prioridade) {
                    case 1 -> "Baixa";
                    case 2 -> "Média";
                    case 3 -> "Alta";
                    default -> "Baixa"; 
                    };
                    manager.adicionarTarefa(desc, prioridade);
                    System.out.println("✅ Descrição adicionada!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Tarefas ---");
                    if (manager.listarTarefas().isEmpty()) {
                        System.out.println("(Nenhuma tarefa cadastrada)");
                    } else {
                        manager.listarTarefas().forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID da tarefa: ");
                    int idConcluir = sc.nextInt();
                    if (manager.concluirTarefa(idConcluir)) {
                        System.out.println("✔️ Tarefa concluída!");
                    } else {
                        System.out.println("❌ ID não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID da tarefa: ");
                    int idRemover = sc.nextInt();
                    if (manager.removerTarefa(idRemover)) {
                        System.out.println("🗑️ Tarefa removida!");
                    } else {
                        System.out.println("❌ ID não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
