package com.newchallenge.avaliacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newchallenge.avaliacao.dto.ImovelDTO;
import com.newchallenge.avaliacao.services.ImovelService;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelController {
	
	@Autowired
	private ImovelService service;
	
	@GetMapping
	public Page<ImovelDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public ImovelDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
