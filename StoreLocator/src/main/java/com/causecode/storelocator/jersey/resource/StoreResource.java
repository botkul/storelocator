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

import com.causecode.storelocator.jaxrs.service.StoreService;
import com.causecode.storelocator.jersey.dto.StoreDistanceDto;
import com.causecode.storelocator.jersey.dto.StoreDto;

@Path("stores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class StoreResource {
	@Autowired
	StoreService storeService;
	
	@GET
	public List<StoreDto> getAllStores(){
		return storeService.listStoreDto();
	}
	
	@GET
	@Path("/{zipcode}/{xMiles}") //GET list of store from {zipcode} within {xMiles} miles
	public List<StoreDistanceDto> getAllStoresWithin_xMiles(@PathParam("zipcode")int zipcode,@PathParam("xMiles")float xMiles){
		return storeService.listAllStoresWithin_xMiles(zipcode, xMiles);
	}
	
	@GET
	@Path("/{storeId}")
	public StoreDto getStore(@PathParam("storeId") int storeId){
		return storeService.getStore(storeId);
	}
	
	@POST
	public Response addStore(StoreDto storeDto){
		storeService.addStore(storeDto);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/{storeId}")
	public Response updateStore(StoreDto storeDto,@PathParam("storeId") int storeId){
		storeDto.setStoreId(storeId); storeService.updateStore(storeDto);
		return Response.status(Status.OK).build();
	}
	
	@DELETE
	@Path("/{storeId}")
	public Response removeStore(@PathParam("storeId") int storeId){
		storeService.removeStore(storeId);
		return Response.status(Status.OK).build();
	}
}
