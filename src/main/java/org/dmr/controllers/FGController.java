package org.dmr.controllers;

import org.dmr.services.FGService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by davidmartinezros on 31/08/2017.
 * 
 * email: davidnezan@gmail.com
 * 
 * web: http://davidmartinezros.com
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class FGController {
	
	@Autowired
    private FGService fgService;
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public FGController() {
        
    }
    
    @RequestMapping(value = "/fg/constructPhrase", method = RequestMethod.GET)
    public String constructPhrase(
    		@RequestParam("theme") String theme,
    		@RequestParam("phrase") String phrase) throws Exception {
    	
    	fgService.constructPhrase(theme, phrase);
    	
    	return "Added: " + phrase;
    	
    }
    
    @RequestMapping(value = "/fg/state", method = RequestMethod.GET)
    public String getState() throws Exception {
    	
    	return "OK";
    	
    }
    
}
