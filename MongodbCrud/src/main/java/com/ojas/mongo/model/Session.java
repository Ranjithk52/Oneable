package com.ojas.mongo.model;

public class Session {
	private String recordingPath;
	//private String _class;
	public String getRecordingPath() {
		return recordingPath;
	}
	public void setRecordingPath(String recordingPath) {
		this.recordingPath = recordingPath;
	}
//	public String get_class() {
//		return _class;
//	}
//	public void set_class(String _class) {
//		this._class = _class;
//	}
	public Session(String recordingPath) {
		super();
		this.recordingPath = recordingPath;
		
	}
	public Session() {
		
	}
	

}
