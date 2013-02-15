package br.com.mypst.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mypst.infra.JPAUtil;
import br.com.mypst.modelo.Usuario;
import br.com.mypst.usuario.dao.UsuarioDAO;

public class TestaListaUsuario {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		UsuarioDAO dao = new UsuarioDAO(em);

		List<Usuario> usuarios = new ArrayList<>();

		usuarios = dao.lista();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNome());
		}

	}

}
