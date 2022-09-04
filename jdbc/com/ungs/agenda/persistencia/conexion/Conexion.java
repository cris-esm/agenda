package com.ungs.agenda.persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = LogManager.getLogger(Conexion.class);	
	
	private Conexion()
	{
		try
		{
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:3306/agenda","postgres","prueba");
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
			System.out.println("conexion exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
			System.out.println("conexion fallida");
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}

