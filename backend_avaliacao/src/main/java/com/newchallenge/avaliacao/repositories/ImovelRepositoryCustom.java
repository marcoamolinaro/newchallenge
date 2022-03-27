package com.newchallenge.avaliacao.repositories;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.newchallenge.avaliacao.entities.Imovel;

public interface ImovelRepositoryCustom {
	List<Imovel> findByCidadeAndValor(@Param("cidade") String cidade, @Param("valor") Integer valor, @Param("criteria") String criteria);

}
