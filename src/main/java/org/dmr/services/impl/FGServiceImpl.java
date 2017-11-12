package org.dmr.services.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.dmr.services.FGService;
import org.springframework.stereotype.Service;

/**
 * Created by davidmartinezros on 31/08/2017.
 * 
 * email: davidnezan@gmail.com
 * 
 * web: http://davidmartinezros.com
 */
@Service
public class FGServiceImpl implements FGService {

    public FGServiceImpl() {
        
    }
    
    @Override
    public void constructPhrase(String theme, String phrase) throws Exception {
    	
    	String path = "/deeplearning4j/" + theme + "_PHRASES_FILE.txt";
    	
    	String phraseToWrite = "";
    	
    	Path p = Paths.get(path);
    	File file = p.toFile();
    	if(!file.exists()) {
    		file.createNewFile();
    	} else {
    		phraseToWrite = System.lineSeparator();
    	}
    	
    	phraseToWrite += phrase;
    	
    	try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
    	    writer.write(phraseToWrite);
    	} catch (IOException ioe) {
    	    System.err.format("IOException: %s%n", ioe);
    	}
    
    }
    	
}
