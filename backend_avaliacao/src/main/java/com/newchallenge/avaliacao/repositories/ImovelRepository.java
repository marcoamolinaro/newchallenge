package com.newchallenge.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newchallenge.avaliacao.entities.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

}
