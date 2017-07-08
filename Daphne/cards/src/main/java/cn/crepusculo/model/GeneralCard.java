package cn.crepusculo.model;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.cards
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/8
 */

public class GeneralCard {
    public String getStreamTitle() {
        return streamTitle;
    }

    public GeneralCard setStreamTitle(String streamTitle) {
        this.streamTitle = streamTitle;
        return this;
    }

    public String getStreamSubtitle() {
        return streamSubtitle;
    }

    public GeneralCard setStreamSubtitle(String streamSubtitle) {
        this.streamSubtitle = streamSubtitle;
        return this;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public GeneralCard setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
        return this;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public GeneralCard setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    public String getEventContent() {
        return eventContent;
    }

    public GeneralCard setEventContent(String eventContent) {
        this.eventContent = eventContent;
        return this;
    }

    private String streamTitle;
    private String streamSubtitle;
    private String eventTitle;
    private String eventInfo;
    private String eventContent;

    public GeneralCard(){

    }

}
