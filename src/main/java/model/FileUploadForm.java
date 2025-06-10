package model;

import org.jboss.resteasy.reactive.PartFilename;
import org.jboss.resteasy.reactive.PartType;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;

public class FileUploadForm {
	
	@FormParam("fileName")
	@PartType(MediaType.TEXT_PLAIN)
	public String fileName;
	
	@FormParam("file")
	@PartType(MediaType.APPLICATION_OCTET_STREAM)
	public byte[] file;


	

}
