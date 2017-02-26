package net.foreach.analytics.commons.model;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by aitor on 26/2/17.
 */
public abstract class JsonModel extends GenericModel {

    private static final Logger logger= LogManager.getLogger(JsonModel.class);

    private static ObjectMapper objectMapper= null;

    public static <T> ObjectReader getReaderInstance(Class<T> clazz) {
        return getMapperInstance().reader(clazz);
    }

    public static <T> String modelToString(T model) {
        try {
            return getMapperInstance().writeValueAsString(model);
        } catch (JsonGenerationException e) {
            logger.error("Unable to generate json from model", e);
        } catch (JsonMappingException e) {
            logger.error("Unable to generate json from model", e);
        } catch (IOException e) {
            logger.error("Unable to generate json from model", e);
        }
        return "{}";
    }

    private static ObjectMapper getMapperInstance() {
        if (objectMapper == null)
            objectMapper= new ObjectMapper();
        return objectMapper;
    }
}
