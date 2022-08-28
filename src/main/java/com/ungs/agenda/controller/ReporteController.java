package com.ungs.agenda.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.ReporteDTO;
import com.ungs.agenda.service.IReporteService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class ReporteController {
	
	@Autowired
	private IReporteService reporteService;
	
	@GetMapping(path="/signos/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) throws JRException, IOException, SQLException{
		ReporteDTO reporte = reporteService.obtenerReporteSignos(params);
		InputStreamResource streamResource = new InputStreamResource(reporte.getData());
		return ResponseEntity.ok().header("Content-Disposition", 
										  "inline; filename=\"" + reporte.getNombre() + "\"")
										  .contentLength(reporte.getLength())
										  .contentType(MediaType.APPLICATION_PDF).body(streamResource);
	}
}
