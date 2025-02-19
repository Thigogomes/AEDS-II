package ti2_exercicios.ti2_exercicios;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		int x;
		int codigo;
		String login, senha;
		char sexo;
		Scanner input = new Scanner(System.in);
		DAO dao = new DAO();
		dao.conectar();
		
		System.out.println("\n1-Listar\n2-Inserir\n3-Excluir\n4-Atualizar\n5-Sair\nDigite uma opção: \n");
		x = input.nextInt();
		while(x != 5) {
			if(x == 1) {
				Usuario[] usuarios = dao.getUsuarios();
				for(int i = 0; i < usuarios.length; i++) {
					System.out.println(usuarios[i].toString());
				}
			}else if(x == 2) {
				System.out.println("Digite o código: ");
				codigo = input.nextInt();
				input.nextLine();
				System.out.println("Digite o login: ");
				login = input.nextLine();
				System.out.println("Digite a senha: ");
				senha = input.nextLine();
				System.out.println("Digite o sexo: ");
				sexo = input.next().charAt(0);
				Usuario usuario = new Usuario(codigo,login,senha,sexo);
				dao.inserirUsuario(usuario);
			}else if(x == 3) {
				System.out.println("Digite o código do usuario que deseja excluir: ");
				codigo = input.nextInt();
				dao.delete(codigo);
			}else if(x == 4) {
				System.out.println("Digite o código do usuario que deseja atualizar: ");
				codigo = input.nextInt();
				input.nextLine();
				System.out.println("Digite o login: ");
				login = input.nextLine();
				System.out.println("Digite a senha: ");
				senha = input.nextLine();
				System.out.println("Digite o sexo: ");
				sexo = input.next().charAt(0);
				Usuario usuario = new Usuario(codigo,login,senha,sexo);
				dao.update(usuario);
			}else if(x == 5) {
				
			}else {
				System.out.println("Opção invalida!");
			}
			System.out.println("\n1-Listar\n2-Inserir\n3-Excluir\n4-Atualizar\n5-Sair\nDigite uma opção: \n");
			x = input.nextInt();
		}
	}
}
