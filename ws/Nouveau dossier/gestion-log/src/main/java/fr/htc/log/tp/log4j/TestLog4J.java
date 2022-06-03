package fr.htc.log.tp.log4j;

import org.apache.log4j.Logger;

public class TestLog4J {

	 // Récupération  de notre logger.
    private static final Logger logger = Logger.getLogger(TestLog4J.class );

    // Le point d'entrée du programme.
    public static void main (String [] args)  {
    	

        
        logger.warn("warn");
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
        logger.trace("trace");
        logger.fatal("fatal");
    	
    }
    
}