package br.com.mypst.usuario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.mypst.modelo.Usuario;

public class UsuarioDAO {
	private EntityManager em;
	private final DAO<Usuario> dao;

	public UsuarioDAO(EntityManager em) {
		dao = new DAO<Usuario>(em, Usuario.class);
		this.em = em;
	}

	/*
	 * public void adiciona(Usuario t) { UsuarioDAO dao2 = new UsuarioDAO(em);
	 * 
	 * if (dao2.buscaPorNome(t.getNome()).size() > 0) {
	 * 
	 * new IllegalArgumentException("Usuario já existe!") .printStackTrace();
	 * 
	 * } else {
	 * 
	 * dao.adiciona(t); } }
	 */

	public void adiciona(Usuario t) {
		try {
			dao.adiciona(t);

		} catch (PersistenceException e) {
			e.printStackTrace();
			new IllegalArgumentException("Usuario já existe na base!");
		}
	}

	public Usuario busca(Integer id) {
		return dao.busca(id);
	}

	public List<Usuario> lista() {
		return dao.lista();
	}

	public void remove(Usuario t) {
		dao.remove(t);
	}

	public void altera(Usuario t) {
		dao.altera(t);
	}

	public List<Usuario> buscaPorNome(String nome) {
		CriteriaBuilder busca = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = busca.createQuery(Usuario.class);
		Root<Usuario> alias = criteria.from(Usuario.class);
		criteria.where(busca.equal(alias.<Usuario> get("nome"), nome));

		return em.createQuery(criteria).getResultList();

	}

}
