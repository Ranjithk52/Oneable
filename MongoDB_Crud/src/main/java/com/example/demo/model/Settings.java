package com.example.demo.model;

import java.util.List;

public  class Settings {
    
    private List<Domain> domains;
    private SessionRecording sessionRecording;
    private List<PmTool> pmTools;
    
    public List<Domain> getDomains() {
        return domains;
    }
    
    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }
    
    public SessionRecording getSessionRecording() {
        return sessionRecording;
    }
    
    public void setSessionRecording(SessionRecording sessionRecording) {
        this.sessionRecording = sessionRecording;
    }
    
    public List<PmTool> getPmTools() {
        return pmTools;
    }
    
    public void setPmTools(List<PmTool> pmTools) {
        this.pmTools = pmTools;
    }
}
