package com.newchallenge.avaliacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.newchallenge.avaliacao.entities.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Imovel obj WHERE obj.cidade LIKE %:cidade% AND valor < :valor")
	Page<Imovel> findDistinctByCidadeContainingAndValorLessThan(@Param("cidade") String cidade, @Param("valor") Integer valor, Pageable pageRequest);
	
}
