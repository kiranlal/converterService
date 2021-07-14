package com.training.converter.resource;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Api(value = "A Converter Class for JSON to XML")
public class ConverterController  {
	
	  private static final Logger logger = LoggerFactory.getLogger(ConverterController.class);

	  
	  @RequestMapping(method = GET, value = "/whoamI")
	  @ApiOperation(value = " returns the current deployed server configuration")
	  public ResponseEntity<String> whoAmI(@RequestParam String requester) {
		logger.debug("Entering whoAmI  with "+requester );
		  String result="unknown host";
		try {
			result = InetAddress.getLocalHost().getHostName()+" at this time -"+Instant.now();
		} catch (UnknownHostException e) {
			logger.error("whoAmI", e);
		}
		  logger.debug("Exiting whoAmI  with "+requester );
		  return new ResponseEntity<String>("I am "+result,HttpStatus.OK);
		  
	  }

	  @RequestMapping(method = POST, value = "/convertJson")
	  @ApiOperation(value = "Converts Json to a XML and returns")
	  public ResponseEntity<String> convertJsonToXML(@RequestBody String jsonInput) {
		  logger.debug("Entering Conversion Service");
		  String result = "";
		  try {
			  result = jsonInput;////TODO Conversion Service
		  } catch (Exception e) {
			  logger.error("ConversionService", e);
		  }
		  logger.debug("Existing Conversion Service");
		  return new ResponseEntity<String>("Output as XML is "+result,HttpStatus.OK);
		  
	  }
	  
}