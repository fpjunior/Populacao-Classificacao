package com.arthurvinicius.cursomc.Dto;

public class ClassificacaoDto {

	private String id;	
	private Integer qnt;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQnt() {
		return qnt;
	}

	public void setQnt(Integer qnt) {
		this.qnt = qnt;
	}

	public ClassificacaoDto(String id, Integer qnt) {		
		this.id = id;
		this.qnt = qnt;		
	}


}
