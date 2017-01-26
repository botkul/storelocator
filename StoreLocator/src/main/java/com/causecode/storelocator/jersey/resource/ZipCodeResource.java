package com.causecode.storelocator.jersey.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.causecode.storelocator.jaxrs.service.ZipCodeService;
import com.causecode.storelocator.jersey.dto.ZipCodeDto;

@Path("zipcodes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ZipCodeResource {
	@Autowired
	ZipCodeService zipCodeService;
	
	@GET
	public List<ZipCodeDto> getAllZipCodes(){
		return zipCodeService.listZipCodeDto();
	}
	
	@GET
	@Path("/{zipcode}")
	public ZipCodeDto getStore(@PathParam("zipcode") int zipcode){
		return zipCodeService.getZipCode(zipcode);
	}
	
	@POST
	public Response addStore(ZipCodeDto zipCodeDto){
		zipCodeService.addZipCode(zipCodeDto);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/{zipcode}")
	public Response updateStore(ZipCodeDto zipCodeDto,@PathParam("zipcode") int zipcode){
		zipCodeDto.setZipcode(zipcode); zipCodeService.updateZipCode(zipCodeDto);
		return Response.status(Status.OK).build();
	}
	
	@DELETE
	@Path("/{zipcode}")
	public Response removeStore(@PathParam("zipcode") int zipcode){
		zipCodeService.removeZipCode(zipcode);
		return Response.status(Status.OK).build();
	}
}
