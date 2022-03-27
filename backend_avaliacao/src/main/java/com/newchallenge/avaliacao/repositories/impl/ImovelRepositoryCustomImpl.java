package com.newchallenge.avaliacao.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.newchallenge.avaliacao.entities.Imovel;
import com.newchallenge.avaliacao.repositories.ImovelRepositoryCustom;

@Repository
public class ImovelRepositoryCustomImpl implements ImovelRepositoryCustom {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Imovel> findByCidadeAndValor(String cidade, Integer valor, String criteria) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Imovel> query = cb.createQuery(Imovel.class);
		Root<Imovel> imovel = query.from(Imovel.class);
		
		Path<String> cidadePath = imovel.get("cidade");
		Expression<? extends Integer> valorPath = imovel.get("valor");
		
		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(cb.like(cidadePath, cidade));

		if (criteria.equals("<")) {
			predicates.add(cb.lt(valorPath, valor));
		} else if (criteria.equals("=")) {
			predicates.add(cb.equal(valorPath, valor));
		} else if (criteria.equals(">")) {
			predicates.add(cb.greaterThan(valorPath, valor));
		} else if (criteria.equals("<=")) {
			predicates.add(cb.lessThanOrEqualTo(valorPath, valor));
		} else if (criteria.equals(">=")) {
			predicates.add(cb.greaterThanOrEqualTo(valorPath, valor));
		}
			
		query.select(imovel)
			.where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
		
		return entityManager.createQuery(query).getResultList();
	}

}
