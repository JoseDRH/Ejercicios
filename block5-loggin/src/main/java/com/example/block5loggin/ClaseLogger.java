package com.example.block5loggin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaseLogger {

    Logger logger= LoggerFactory.getLogger(Block5LogginApplication.class);
    @RequestMapping("/")
    public String logs() {
        logger.trace("TRACE");
        logger.debug("DEBUG");
        logger.info("INFO");
        logger.warn("WARNING");
        logger.error("ERROR");

        return "Resultados en logs";
    }
}
