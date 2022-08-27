package com.ungs.agenda.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.ungs.agenda.dto.ReporteDTO;

import net.sf.jasperreports.engine.JRException;

public interface IReporteService {
	
	public ReporteDTO obtenerReporteSignos(Map<String, Object> params) throws JRException, IOException, SQLException;
	
}
