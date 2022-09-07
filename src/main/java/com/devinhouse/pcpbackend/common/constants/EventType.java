package com.devinhouse.pcpbackend.common.constants;

public enum EventType {

    CREATE("Create"),
    UPDATE("Update"),
    DELETE("Delete"),
	ARCHIVE("Arquivar"),
	UNARCHIVE("DESARQUIVAR");

    private final String event;

    EventType(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
