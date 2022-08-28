package com.ungs.agenda.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.commons.JasperReportManager;
import com.ungs.agenda.dto.ReporteDTO;
import com.ungs.agenda.service.IReporteService;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteServiceImpl implements IReporteService {
	
	@Autowired
	private JasperReportManager reportManager;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public ReporteDTO obtenerReporteSignos(Map<String, Object> params) throws JRException, IOException, SQLException {
		String nombreArchivo = "reporte_signos";
		ByteArrayOutputStream stream = reportManager.export(nombreArchivo, 
															params, 
															dataSource.getConnection());
		
		ReporteDTO reporte = new ReporteDTO();
		reporte.setNombre(nombreArchivo + ".pdf");
		byte[] bstream = stream.toByteArray();
		reporte.setData(new ByteArrayInputStream(bstream));
		reporte.setLength(bstream.length);
		
		return reporte;
	}
	
	@Override
	public ReporteDTO obtenerReporteTecnologiaAscendente(Map<String, Object> params) throws JRException, IOException, SQLException {
		String nombreArchivo = "TecnologiaAscendente";
		ByteArrayOutputStream stream = reportManager.export(nombreArchivo, 
															params, 
															dataSource.getConnection());
		
		ReporteDTO reporte = new ReporteDTO();
		reporte.setNombre(nombreArchivo + ".pdf");
		byte[] bstream = stream.toByteArray();
		reporte.setData(new ByteArrayInputStream(bstream));
		reporte.setLength(bstream.length);
		
		return reporte;
	}

	@Override
	public ReporteDTO obtenerReporteTecnologiaDescendete(Map<String, Object> params) throws JRException, IOException, SQLException {
		String nombreArchivo = "TecnologiaDescendente";
		ByteArrayOutputStream stream = reportManager.export(nombreArchivo, 
															params, 
															dataSource.getConnection());
		
		ReporteDTO reporte = new ReporteDTO();
		reporte.setNombre(nombreArchivo + ".pdf");
		byte[] bstream = stream.toByteArray();
		reporte.setData(new ByteArrayInputStream(bstream));
		reporte.setLength(bstream.length);
		
		return reporte;
	}

}
