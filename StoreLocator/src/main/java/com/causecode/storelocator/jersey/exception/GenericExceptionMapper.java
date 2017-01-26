package com.causecode.storelocator.jersey.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.causecode.storelocator.jersey.dto.ErrorMessage;

@Provider
public class GenericExceptionMapper extends WebApplicationException implements ExceptionMapper<Throwable> {
	private static final long serialVersionUID = 5565651440303420363L;

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errMsg=new ErrorMessage();
		setHttpStatus(ex,errMsg);
		errMsg.setErroMessage(ex.getMessage()); errMsg.setDocumentation("http://causecode.com/wiki/error/"+errMsg.getErroCode());
		
		return Response.status(errMsg.getErroCode())
						.entity(errMsg)
						.type(MediaType.APPLICATION_JSON)
						.build();
	}
	
	private void setHttpStatus(Throwable ex, ErrorMessage errMsg){
		if(ex instanceof WebApplicationException){
			errMsg.setErroCode(((WebApplicationException)ex).getResponse().getStatus());
		}
		else{
			errMsg.setErroCode(Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}
}
