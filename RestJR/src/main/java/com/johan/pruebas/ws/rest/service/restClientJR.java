package com.johan.pruebas.ws.rest.service;

import com.johan.pruebas.ws.rest.vo.VOUsuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class restClientJR {

	public static void main (String[] args) {
		
		final String urlRestService = "http://localhost:8080/RestJR-0.0.1-SNAPSHOT/services/JavaRevolutions/validaUsuario";
		System.out.println("····· Response :  Servicio Rest invocado : [ " + urlRestService + " ]");
		VOUsuario vo = new  VOUsuario();
		vo.setUsuario("Java");
		vo.setPassword("Revolutions");
		vo.setUserVal(false); 
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING , Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResourse = client.resource(urlRestService);
		ClientResponse response = webResourse.type("application/json").post(ClientResponse.class , vo);
		
		vo = response.getEntity(VOUsuario.class);
		System.out.println("····· Response : Usuario: [ " + vo.getUsuario() + " ]");
		System.out.println("····· Response : El usuario es valido: [ " + vo.isUserVal() + " ]");
	}
	
}
