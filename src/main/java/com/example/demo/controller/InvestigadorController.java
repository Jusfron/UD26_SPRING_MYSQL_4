package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.InvestigadorServiceImpl;
import com.example.demo.dto.Investigador;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores() {
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{id}")
	public Investigador investigadorXID(@PathVariable(name="id") int id) {
		
		Investigador Investigador_xid= new Investigador();
		
		Investigador_xid=investigadorServiceImpl.investigadorXID(id);
		
		System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;
	}
	
	@PutMapping("/investigadores/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name="id")int id,@RequestBody Investigador investigador) {
		
		Investigador investigador_seleccionado= new Investigador();
		Investigador investigador_actualizado= new Investigador();
		
		investigador_seleccionado= investigadorServiceImpl.investigadorXID(id);
		
		investigador_seleccionado.setNomApels(investigador.getNomApels());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		
		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);
		
		System.out.println("La investigador actualizada es: "+ investigador_actualizado);
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{id}")
	public void eliminarInvestigador(@PathVariable(name="id")int id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}
	
}
