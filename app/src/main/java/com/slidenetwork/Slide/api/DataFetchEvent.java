package com.slidenetwork.Slide.api;

public final class DataFetchEvent<T> {

    private long requestTimestamp;
    private T dataObject;
    private String url;
    private String message;
    private int requestId;

    /**
     * Instantiates a new Data fetch event.
     *
     * @param requestId        the request id
     * @param requestTimestamp the request timestamp
     * @param url              the url
     */
    public DataFetchEvent(int requestId, long requestTimestamp, String url) {
        this.requestId = requestId;
        this.requestTimestamp = requestTimestamp;
        this.url = url;
    }

    /**
     * Instantiates a new Data fetch event.
     *
     * @param requestId        the request id
     * @param requestTimestamp the request timestamp
     * @param url              the url
     * @param dataObject       the data object
     * @param message          the message
     */
    public DataFetchEvent(int requestId, long requestTimestamp, String url, T dataObject, String message) {
        this.requestId = requestId;
        this.requestTimestamp = requestTimestamp;
        this.dataObject = dataObject;
        this.url = url;
        this.message = message;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }


    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets request timestamp.
     *
     * @return the request timestamp
     */
    public long getRequestTimestamp() {
        return requestTimestamp;
    }

    /**
     * Gets data object.
     *
     * @return the data object
     */
    public T getDataObject() {
        return dataObject;
    }

    /**
     * Gets request id.
     *
     * @return the request id
     */
    public int getRequestId() {
        return requestId;
    }
}
