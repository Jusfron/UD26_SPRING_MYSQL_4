package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.FacultadServiceImpl;
import com.example.demo.dto.Facultad;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultad")
	public List<Facultad> listarFacultad() {
		return facultadServiceImpl.listarFacultad();
	}
	
	@PostMapping("/facultad")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultad/{id}")
	public Facultad facultadXID(@PathVariable(name="id") int id) {
		
		Facultad Facultad_xid= new Facultad();
		
		Facultad_xid=facultadServiceImpl.facultadXID(id);
		
		System.out.println("Facultad XID: "+Facultad_xid);
		
		return Facultad_xid;
	}
	
	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="id")int id,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionado= new Facultad();
		Facultad facultad_actualizado= new Facultad();
		
		facultad_seleccionado= facultadServiceImpl.facultadXID(id);
		
		facultad_seleccionado.setNombre(facultad.getNombre());
		
		facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);
		
		System.out.println("La facultad actualizada es: "+ facultad_actualizado);
		
		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultad/{id}")
	public void eliminarFacultad(@PathVariable(name="id")int id) {
		facultadServiceImpl.eliminarFacultad(id);
	}
	
}
