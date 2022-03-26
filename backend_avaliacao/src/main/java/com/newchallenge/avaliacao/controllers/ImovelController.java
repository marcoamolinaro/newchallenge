package com.newchallenge.avaliacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newchallenge.avaliacao.dto.ImovelDTO;
import com.newchallenge.avaliacao.entities.Imovel;
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
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	
	@PostMapping
	public ImovelDTO insert(@RequestBody ImovelDTO imovelDTO) {
		Imovel imovel = fromDTO(imovelDTO);
		imovel.setId(null);		
		ImovelDTO dto = service.save(imovel);
		return dto;
	}
	
	@PutMapping
	public ImovelDTO update(@RequestBody ImovelDTO imovelDTO) {
		
		ImovelDTO dto = service.findById(imovelDTO.getId());
		
		System.out.println("IMOVEL " + dto.toString());
		
		Imovel imovel = fromDTO(imovelDTO);
		imovel.setId(imovelDTO.getId());
		
		System.out.println("IMOVEL " + imovel.toString());
		
		dto = service.save(imovel);
		
		return dto;
	}
	
	public Imovel fromDTO(ImovelDTO dto) {
		Imovel imovel = new Imovel();

		imovel.setArea(dto.getArea());
		imovel.setBairro(dto.getBairro());
		imovel.setCidade(dto.getCidade());
		imovel.setDescricao(dto.getDescricao());
		imovel.setDormitorios(dto.getDormitorios());
		imovel.setLogradouro(dto.getLogradouro());
		imovel.setNumero(dto.getNumero());
		imovel.setSuites(dto.getSuites());
		imovel.setUf(dto.getUf());
		imovel.setValor(dto.getValor());
		
		return imovel;
	}
}
