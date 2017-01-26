package com.causecode.storelocator.jersey.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.causecode.storelocator.jersey.dto.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
	public Response toResponse(DataNotFoundException ex){
		ErrorMessage errorMessage=new ErrorMessage(404,ex.getMessage(),"http://causecode.com/wiki/error/404");
		return Response.status(Status.NOT_FOUND)
						.entity(errorMessage).build();
	}
}
