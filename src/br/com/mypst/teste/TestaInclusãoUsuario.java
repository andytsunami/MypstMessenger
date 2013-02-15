package br.com.mypst.teste;

import javax.persistence.EntityManager;

import br.com.mypst.infra.JPAUtil;
import br.com.mypst.modelo.Usuario;
import br.com.mypst.usuario.dao.UsuarioDAO;

public class TestaInclusãoUsuario {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Usuario usuario = new Usuario();
		usuario.setNome("Sou unico?");
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);

		em.getTransaction().begin();
		usuarioDAO.adiciona(usuario);
		em.getTransaction().commit();
		em.close();

	}

}
