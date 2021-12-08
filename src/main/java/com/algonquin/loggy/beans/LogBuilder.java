package com.algonquin.loggy.beans;

import java.util.Date;
import java.util.UUID;

public class LogBuilder {
    private String dummyUuid;
    private String title;
    private String content;
    private String createTimestamp;
    private String fileType;

    public LogBuilder setCreateTimestamp(String createTimestamp){
        this.createTimestamp = createTimestamp;
        return this;
    }

    public LogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public LogBuilder setContent(String content) {
        this.content = content;
        return this;
    }
    public LogBuilder setDummyUuid(String dummyUuid){
        this.dummyUuid = dummyUuid;
        return this;
    }
    public LogBuilder setFileType(String fileType){
        this.fileType = fileType;
        return this;
    }

    public Log createLog() {
        return new Log(dummyUuid,title, content,createTimestamp,fileType);
    }
}