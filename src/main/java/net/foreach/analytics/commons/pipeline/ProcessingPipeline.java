package net.foreach.analytics.commons.pipeline;

/**
 * Created by aitor on 26/2/17.
 */
public interface ProcessingPipeline<T extends ProcessingPipeline<T>> {

    ProcessingPipeline<T> ingestion();

    ProcessingPipeline<T> cleaning();

    ProcessingPipeline<T> normalisation();

    ProcessingPipeline<T> processing();

    ProcessingPipeline<T> persistence();

}
