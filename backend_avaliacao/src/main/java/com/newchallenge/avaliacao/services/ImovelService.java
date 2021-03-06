package com.newchallenge.avaliacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newchallenge.avaliacao.dto.ImovelDTO;
import com.newchallenge.avaliacao.entities.Imovel;
import com.newchallenge.avaliacao.repositories.ImovelRepository;
import com.newchallenge.avaliacao.repositories.impl.ImovelRepositoryCustomImpl;
import com.newchallenge.avaliacao.services.exceptions.ObjectNotFoundException;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository repository;
	
	@Autowired
	private ImovelRepositoryCustomImpl repositoryCustomImpl;

	@Transactional(readOnly = true)
	public Page<ImovelDTO> findAll(Pageable pageable) {
		Page<Imovel> result = repository.findAll(pageable);

		Page<ImovelDTO> page = result.map(x -> new ImovelDTO(x));

		return page;
	}

	@Transactional(readOnly = true)
	public ImovelDTO findById(Long id) {

		ImovelDTO dto = null;

		try {
			Imovel result = repository.findById(id).get();
			dto = new ImovelDTO(result);

		} catch (Exception e) {
			throw new ObjectNotFoundException("Imovel não encontrado! Id: " + id);
		}

		return dto;

	}

	@Transactional
	public ImovelDTO save(Imovel imovel) {
		Imovel result = repository.saveAndFlush(imovel);
		return new ImovelDTO(result);
	}

	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Imovel não encontrado! Id: " + id);
		}
	}
	
	@Transactional
	public List<Imovel> findByCidadeAndValor(String cidade, Integer valor, String criteria) {
		List<Imovel> result = repositoryCustomImpl.findByCidadeAndValor(cidade, valor, criteria);

		return result;
	
	}
}
