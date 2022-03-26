package com.newchallenge.avaliacao.dto;

import java.math.BigDecimal;

import com.newchallenge.avaliacao.entities.Imovel;

public class ImovelDTO {
    private Long id;
    private String descricao;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private Integer dormitorios;
    private Integer suites;
    private BigDecimal area;
    private Integer valor;
    
    public ImovelDTO() {}

	public ImovelDTO(Long id, String descricao, String logradouro, String numero, String bairro, String cidade,
			String uf, Integer dormitorios, Integer suites, BigDecimal area, Integer valor) {
		this.id = id;
		this.descricao = descricao;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.dormitorios = dormitorios;
		this.suites = suites;
		this.area = area;
		this.valor = valor;
	}
    
	public ImovelDTO(Imovel imovel) {
		this.id = imovel.getId();
		this.descricao = imovel.getDescricao();
		this.logradouro = imovel.getLogradouro();
		this.numero = imovel.getNumero();
		this.bairro = imovel.getBairro();
		this.cidade = imovel.getCidade();
		this.uf = imovel.getUf();
		this.dormitorios = imovel.getDormitorios();
		this.suites = imovel.getSuites();
		this.area = imovel.getArea();
		this.valor = imovel.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}

	public Integer getSuites() {
		return suites;
	}

	public void setSuites(Integer suites) {
		this.suites = suites;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	
}
