package br.com.senai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Contatos> contatos = new ArrayList<>();

	static int id = 0;

	public static void main(String[] args) {

		int valorDigitado;
		while (true) {
			valorDigitado = exibirMenu();
			input.nextLine();
			switch (valorDigitado) {
			case 1:
				Contatos contato = cadastrarContato();
				contatos.add(contato);
				break;
			case 2:
				if (contatosIsEmpty()) {
					break;
				}
				listarContatos();
				break;
			case 3:
				buscarContato();
				break;
			case 4:
				//editarContato();
				break;
			case 5:
				// excluirContato();
				break;
			case 6:
				System.out.println("Sistema finalizado");
				System.exit(0);
			default:
				System.out.println("Valor inválido");
			}
		}
	}

	public static boolean isValidTelefone(String telefone) {
		if (telefone == null) {
			return false;
		}
		;
		String telefoneRegex = "\\d{2}\\ \\d{9}";
		;
		Pattern pattern = Pattern.compile(telefoneRegex);
		Matcher matcher = pattern.matcher(telefone);
		return matcher.matches();
	}

	public static boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		;
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		;
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static Contatos cadastrarContato() {
		Contatos contato = new Contatos();
		contato.idContato = ++id;
		System.out.print("Informe o nome: ");
		contato.nome = input.nextLine();

		do {
			System.out.println("Informe o numero: (XX) XXXX-XXXXX ");
			contato.numero = input.nextLine();
			if (!isValidTelefone(contato.numero)) {
				System.out.println("O número de telefone inválido.");
			}
		} while (!isValidTelefone(contato.numero));

		do {
			System.out.println("Informe um email: ");
			contato.email = input.nextLine();
			if (!isValidEmail(contato.email)) {
				System.out.println("Endereçoo de email inválido!");
			}
		} while (!isValidEmail(contato.email));
		return contato;

	}

	public static void listarContatos() {
		System.out.println("Lista de contatos:");
		for (Contatos contato : contatos) {
			System.out.println("ID: " + contato.idContato);
			System.out.println("Nome: " + contato.nome);
			System.out.println("Número: " + contato.numero);
			System.out.println("Email: " + contato.email);
			System.out.println("-----------------------------");
		}
	}

	public static void buscarContato() {
		System.out.println("Buscar contato por:");
		System.out.println("1- Nome");
		System.out.println("2- Número");
		System.out.println("3- Email");
		int opcao = input.nextInt();
		input.nextLine();

		switch (opcao) {
		case 1:
			buscarContatoNome();
			break;
		case 2:
			buscarContatoNumero();
			break;
		case 3:
			buscarContatoEmail();
			break;
		default:
			System.out.println("Opção inválida");
		}
	}

	public static void buscarContatoNome() {
		System.out.print("Informe o nome do contato que deseja buscar: ");
		String nomeBuscado = input.nextLine();
		boolean encontrado = false;

		for (Contatos contato : contatos) {
			if (contato.nome.equalsIgnoreCase(nomeBuscado)) {
				System.out.println("Contato encontrado:");
				System.out.println("ID: " + contato.idContato);
				System.out.println("Nome: " + contato.nome);
				System.out.println("Número: " + contato.numero);
				System.out.println("Email: " + contato.email);
				System.out.println("-----------------------------");
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Contato não encontrado.");
		}
	}

	public static void buscarContatoNumero() {
		System.out.print("Informe o número do contato que deseja buscar: ");
		String numeroBuscado = input.nextLine();
		boolean encontrado = false;

		for (Contatos contato : contatos) {
			if (contato.numero.equalsIgnoreCase(numeroBuscado)) {
				System.out.println("Contato encontrado:");
				System.out.println("ID: " + contato.idContato);
				System.out.println("Nome: " + contato.nome);
				System.out.println("Número: " + contato.numero);
				System.out.println("Email: " + contato.email);
				System.out.println("-----------------------------");
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Contato não encontrado.");
		}
	}

	public static void buscarContatoEmail() {
		System.out.print("Informe o email do contato que deseja buscar: ");
		String emailBuscado = input.nextLine();
		boolean encontrado = false;

		for (Contatos contato : contatos) {
			if (contato.email.equalsIgnoreCase(emailBuscado)) {
				System.out.println("Contato encontrado:");
				System.out.println("ID: " + contato.idContato);
				System.out.println("Nome: " + contato.nome);
				System.out.println("Número: " + contato.numero);
				System.out.println("Email: " + contato.email);
				System.out.println("-----------------------------");
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Contato não encontrado.");
		}
	}
	public static void excluirContato() {
		System.out.println("Excluir contato por:");
		System.out.println("1- Nome");
		System.out.println("2- Número");
		System.out.println("3- Email");
		int opcao = input.nextInt();
		input.nextLine();
		switch (opcao) {
			case 1:
				excluirContatoPorNome();
				break;
			case 2:
				excluirContatoPorNumero();
				break;
			case 3:
				excluirContatoPorEmail();
				break;
			default:
				System.out.println("Opção inválida");
		}
	}
	public static void excluirContatoPorNome() {
		System.out.print("Informe o nome do contato que deseja excluir: ");
		String nomeBuscado = input.nextLine();
		Iterator<Contatos> iterator = contatos.iterator();
		boolean encontrado = false;

		while (iterator.hasNext()) {
			Contatos contato = iterator.next();
			if (contato.nome.equalsIgnoreCase(nomeBuscado)) {
				System.out.println("Contato encontrado:");
				System.out.println("ID: " + contato.idContato);
				System.out.println("Nome: " + contato.nome);
				System.out.println("Número: " + contato.numero);
				System.out.println("Email: " + contato.email);
				System.out.println("Deseja realmente excluir este contato? (S/N)");
				String confirmacao = input.nextLine();
				if (confirmacao.equalsIgnoreCase("S")) {
					iterator.remove();
					System.out.println("Contato excluído com sucesso!");
				} else {
					System.out.println("Exclusão cancelada.");
				}
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Contato não encontrado.");
		}
	}public static void excluirContatoPorNumero() {
		System.out.print("Informe o número do contato que deseja excluir: ");
		String numeroBuscado = input.nextLine();
		Iterator<Contatos> iterator = contatos.iterator();
		boolean encontrado = false;

		while (iterator.hasNext()) {
			Contatos contato = iterator.next();
			if (contato.numero.equals(numeroBuscado)) {
				System.out.println("Contato encontrado:");
				System.out.println("ID: " + contato.idContato);
				System.out.println("Nome: " + contato.nome);
				System.out.println("Número: " + contato.numero);
				System.out.println("Email: " + contato.email);
				System.out.println("Deseja realmente excluir este contato? (S/N)");
				String confirmacao = input.nextLine();
				if (confirmacao.equalsIgnoreCase("S")) {
					iterator.remove();
					System.out.println("Contato excluído com sucesso!");
				} else {
					System.out.println("Exclusão cancelada.");
				}
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Contato não encontrado.");
		}
	}
	public static void excluirContatoPorEmail() {
		System.out.print("Informe o email do contato que deseja excluir: ");
		String emailBuscado = input.nextLine();
		Iterator<Contatos> iterator = contatos.iterator();
		boolean encontrado = false;

		while (iterator.hasNext()) {
			Contatos contato = iterator.next();
			if (contato.email.equalsIgnoreCase(emailBuscado)) {
				System.out.println("Contato encontrado:");
				System.out.println("ID: " + contato.idContato);
				System.out.println("Nome: " + contato.nome);
				System.out.println("Número: " + contato.numero);
				System.out.println("Email: " + contato.email);
				System.out.println("Deseja realmente excluir este contato? (S/N)");
				String confirmacao = input.nextLine();
				if (confirmacao.equalsIgnoreCase("S")) {
					iterator.remove();
					System.out.println("Contato excluído com sucesso!");
				} else {
					System.out.println("Exclusão cancelada.");
				}
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Contato não encontrado.");
		}
	}
	public static void editarContato() {
	    System.out.println("Editar contato por:");
	    System.out.println("1- Nome");
	    System.out.println("2- Número");
	    System.out.println("3- Email");
	    int opcao = input.nextInt();
	    input.nextLine();

	    switch (opcao) {
	        case 1:
	            editarContatoPorNome();
	            break;
	        case 2:
	            editarContatoPorNumero();
	            break;
	        case 3:
	            editarContatoPorEmail();
	            break;
	        default:
	            System.out.println("Opção inválida");
	    }
	}

	public static void editarContatoPorNome() {
	    System.out.print("Informe o nome do contato que deseja editar: ");
	    String nomeBuscado = input.nextLine();
	    boolean encontrado = false;

	    for (Contatos contato : contatos) {
	        if (contato.nome.equalsIgnoreCase(nomeBuscado)) {
	            System.out.println("Contato encontrado:");
	            System.out.println("ID: " + contato.idContato);
	            System.out.println("Nome: " + contato.nome);
	            System.out.println("Número: " + contato.numero);
	            System.out.println("Email: " + contato.email);
	            editarDetalhesContato(contato);
	            encontrado = true;
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Contato não encontrado.");
	    }
	}

	public static void editarContatoPorNumero() {
	    System.out.print("Informe o número do contato que deseja editar: ");
	    String numeroBuscado = input.nextLine();
	    boolean encontrado = false;

	    for (Contatos contato : contatos) {
	        if (contato.numero.equals(numeroBuscado)) {
	            System.out.println("Contato encontrado:");
	            System.out.println("ID: " + contato.idContato);
	            System.out.println("Nome: " + contato.nome);
	            System.out.println("Número: " + contato.numero);
	            System.out.println("Email: " + contato.email);
	            editarDetalhesContato(contato);
	            encontrado = true;
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Contato não encontrado.");
	    }
	}

	public static void editarContatoPorEmail() {
	    System.out.print("Informe o email do contato que deseja editar: ");
	    String emailBuscado = input.nextLine();
	    boolean encontrado = false;

	    for (Contatos contato : contatos) {
	        if (contato.email.equalsIgnoreCase(emailBuscado)) {
	            System.out.println("Contato encontrado:");
	            System.out.println("ID: " + contato.idContato);
	            System.out.println("Nome: " + contato.nome);
	            System.out.println("Número: " + contato.numero);
	            System.out.println("Email: " + contato.email);
	            editarDetalhesContato(contato);
	            encontrado = true;
	            break;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Contato não encontrado.");
	    }
	}

	public static void editarDetalhesContato(Contatos contato) {
	    System.out.print("Informe o novo nome (ou pressione Enter para manter o atual): ");
	    String novoNome = input.nextLine();
	    if (!novoNome.trim().isEmpty()) {
	        contato.nome = novoNome;
	    }

	    do {
	        System.out.print("Informe o novo número (ou pressione Enter para manter o atual): ");
	        String novoNumero = input.nextLine();
	        if (novoNumero.trim().isEmpty()) {
	            break;
	        }
	        if (!isValidTelefone(novoNumero)) {
	            System.out.println("O número de telefone é inválido.");
	        } else {
	            contato.numero = novoNumero;
	            break;
	        }
	    } while (true);

	    do {
	        System.out.print("Informe o novo email (ou pressione Enter para manter o atual): ");
	        String novoEmail = input.nextLine();
	        if (novoEmail.trim().isEmpty()) {
	            break;
	        }
	        if (!isValidEmail(novoEmail)) {
	            System.out.println("O endereço de email é inválido!");
	        } else {
	            contato.email = novoEmail;
	            break;
	        }
	    } while (true);

	    System.out.println("Contato atualizado com sucesso!");
	}
	public static Boolean contatosIsEmpty() {
		if (contatos.isEmpty()) {
			System.out.println("Não possui contatos cadastrados!");
			return true;
		}
		return false;
	}

	public static int exibirMenu() {
		System.out.println("BEM VINDO A AGENDA");
		System.out.println("Digite a opção desejada:");
		System.out.println("1- Cadastrar contatos");
		System.out.println("2- Listar contatos");
		System.out.println("3- Buscar contato");
		System.out.println("4- Editar contato");
		System.out.println("5- Excluir contato");
		System.out.println("6- Encerrar sistema");
		return input.nextInt();
	}
}
