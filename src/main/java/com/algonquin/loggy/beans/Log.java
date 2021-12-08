package com.algonquin.loggy.beans;

import java.util.UUID;

public class Log {

    private String uuid;
    private String title;
    private String content;
    private String createTimestamp;
    private String fileType;

    public Log(String dummyUuid, String title, String content, String createTimestamp, String fileType) {
        this.uuid = dummyUuid;
        this.title = title;
        this.content = content;
        this.createTimestamp = createTimestamp;
        this.fileType = fileType;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public String getFileType() {
        return fileType;
    }

    public Log() {
    }

//    public Log(Character uuid,String title, String content, Date createTimestamp) {
//        this.uuid = uuid;
//        this.title = title;
//        this.content = content;
//        this.createTimestamp = createTimestamp;
//    }




//    /**
//     * @return the id
//     */
//    public UUID getId() {
//        return id;
//    }
//
//    /**
//     * @param id the id to set
//     */
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    /**
//     * @return the title
//     */
//    public String getTitle() {
//        return title;
//    }
//
//    /**
//     * @param title the title to set
//     */
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    /**
//     * @return the content
//     */
//    public String getContent() {
//        return content;
//    }
//
//    /**
//     * @param content the content to set
//     */
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    /**
//     * @return the createTimestamp
//     */
//    public Date getCreateTimestamp() {
//        return createTimestamp;
//    }
//
//    /**
//     * @param createTimestamp the createTimestamp to set
//     */
//    public void setCreateTimestamp(Date createTimestamp) {
//        this.createTimestamp = createTimestamp;
//    }

}
