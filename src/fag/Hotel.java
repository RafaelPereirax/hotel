package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    List<Quarto> quartos = new ArrayList<>();
    List<Reserva> reservas = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void cadastrarQuarto() {
    	
        System.out.println("Número do quarto:");
        int numero = scan.nextInt();
        scan.nextLine(); 

        System.out.println("Tipo do quarto (solteiro, casal, suíte):");
        String tipo = scan.nextLine();

        System.out.println("Preço diário:");
        double preco = scan.nextDouble();

        quartos.add(new Quarto(numero, tipo, preco));
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public void cadastrarReserva() {
    	
        System.out.println("Nome do hóspede:");
        scan.nextLine(); 
        String nomeHospede = scan.nextLine();

        System.out.println("Data de check-in (dd/mm/aaaa):");
        String checkIn = scan.nextLine();

        System.out.println("Data de check-out (dd/mm/aaaa):");
        String checkOut = scan.nextLine();

        System.out.println("Número do quarto:");
        int numeroQuarto = scan.nextInt();

        Quarto quartoReservado = buscarQuarto(numeroQuarto);

        if (quartoReservado != null && quartoReservado.disponivel) {
            quartoReservado.alterarDisponibilidade(false);
            reservas.add(new Reserva(nomeHospede, checkIn, checkOut, quartoReservado));
            System.out.println("Reserva cadastrada com sucesso!");
        } else {
            System.out.println("Quarto não encontrado ou já ocupado.");
        }
    }

    public void realizarCheckIn() {
    	
        System.out.println("Número do quarto para check-in:");
        int numeroQuarto = scan.nextInt();
        Quarto quarto = buscarQuarto(numeroQuarto);

        if (quarto != null && quarto.disponivel) {
            quarto.alterarDisponibilidade(false);
            System.out.println("Check-in realizado com sucesso!");
        } else {
            System.out.println("Quarto não encontrado ou já ocupado.");
        }
    }

    public void realizarCheckOut() {
    	
        System.out.println("Número do quarto para check-out:");
        int numeroQuarto = scan.nextInt();
        Quarto quarto = buscarQuarto(numeroQuarto);

        if (quarto != null && !quarto.disponivel) {
            quarto.alterarDisponibilidade(true);
            System.out.println("Check-out realizado com sucesso!");
        } else {
            System.out.println("Quarto não encontrado ou já está disponível.");
        }
    }

    public void acompanharOcupacao() {
    	
        System.out.println("Relatório de Ocupação:");
        for (Quarto quarto : quartos) {
            String status = quarto.disponivel ? "Disponível" : "Ocupado";
            System.out.printf("Quarto %d - %s - %s%n", quarto.numero, quarto.tipo, status);
        }
    }

    public void historicoReservas() {
    	
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.printf(
                "Hóspede: %s | Quarto: %d (%s) | Check-in: %s | Check-out: %s%n",
                reserva.nomeHospede, reserva.quarto.numero, reserva.quarto.tipo,
                reserva.dataCheckIn, reserva.dataCheckOut
            );
        }
    }

    private Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numero) {
                return quarto;
            }
        }
        return null;
    }

    public void menu() {
    	
        int opcao;
        do {
            System.out.println("=== Sistema de Gerenciamento de Hotel ===");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Acompanhar Ocupação");
            System.out.println("6. Histórico de Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1 -> cadastrarQuarto();
                case 2 -> cadastrarReserva();
                case 3 -> realizarCheckIn();
                case 4 -> realizarCheckOut();
                case 5 -> acompanharOcupacao();
                case 6 -> historicoReservas();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
