/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aasdntool;

import java.util.ArrayList;

/**
 *
 * @author ateethkumar
 */
public class Device {
    public String entityClass;
    public ArrayList<String> mac;
    public ArrayList<String> ipv4;
    public ArrayList<String> vlan;
    public static class AttachmentPoint{
    	public boolean errorStatus;
    	public String switchDPID;
    	public int port;
		public boolean isErrorStatus() {
			return errorStatus;
		}
		public void setErrorStatus(boolean errorStatus) {
			this.errorStatus = errorStatus;
		}
		public String getSwitchDPID() {
			return switchDPID;
		}
		public void setSwitchDPID(String switchDPID) {
			this.switchDPID = switchDPID;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
    }
    public ArrayList<AttachmentPoint> attachmentPoint;
    public String lastSeen;
	public String getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}
	public ArrayList<String> getMac() {
		return mac;
	}
	public void setMac(ArrayList<String> mac) {
		this.mac = mac;
	}
	public ArrayList<String> getIpv4() {
		return ipv4;
	}
	public void setIpv4(ArrayList<String> ipv4) {
		this.ipv4 = ipv4;
	}
	public ArrayList<String> getVlan() {
		return vlan;
	}
	public void setVlan(ArrayList<String> vlan) {
		this.vlan = vlan;
	}
	public ArrayList<AttachmentPoint> getAttachmentPoint() {
		return attachmentPoint;
	}
	public void setAttachmentPoint(ArrayList<AttachmentPoint> attachmentPoint) {
		this.attachmentPoint = attachmentPoint;
	}
	public String getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}
	
}
