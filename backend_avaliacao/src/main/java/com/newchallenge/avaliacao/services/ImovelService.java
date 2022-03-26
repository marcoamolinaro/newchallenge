package com.newchallenge.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newchallenge.avaliacao.dto.ImovelDTO;
import com.newchallenge.avaliacao.entities.Imovel;
import com.newchallenge.avaliacao.repositories.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ImovelDTO> findAll(Pageable pageable) {
		Page<Imovel> result = repository.findAll(pageable);
		
		Page<ImovelDTO> page = result.map(x -> new ImovelDTO(x));
		
		return page;
	}
	
	@Transactional(readOnly = true)
	public ImovelDTO findById(Long id) {
		Imovel result = repository.findById(id).get();
		
		ImovelDTO dto = new ImovelDTO(result);
		
		return dto;
	}
}
