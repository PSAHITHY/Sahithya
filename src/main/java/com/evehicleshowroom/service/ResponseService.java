package com.evehicleshowroom.service;

import com.evehicleshowroom.entity.Response;

public interface ResponseService 
{
	Response addResponseDetails(Response response, int requestId);
}
