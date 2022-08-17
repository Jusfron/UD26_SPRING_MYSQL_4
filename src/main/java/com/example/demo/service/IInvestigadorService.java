package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorService {

	public List<Investigador> listarInvestigadores();
	
	public Investigador guardarInvestigador(Investigador investigador);
	
	public Investigador investigadorXID(int id);
	
	public Investigador actualizarInvestigador(Investigador investigador);
	
	public void eliminarInvestigador(int id);
	
}
