package aasdntool;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Topology {
	@JsonProperty("src-switch")
	public String src_switch;
	@JsonProperty("src-port")
	public int src_port;
	@JsonProperty("src-port-state")
	public int src_port_state;
	@JsonProperty("dst-switch")
	public String dst_switch;
	@JsonProperty("dst-port")
	public int dst_port;
	@JsonProperty("dst-port-state")
	public int dst_port_state;
	public String type;
	
	public String getSrc_switch() {
		return src_switch;
	}
	public void setSrc_switch(String src_switch) {
		this.src_switch = src_switch;
	}
	public int getSrc_port() {
		return src_port;
	}
	public void setSrc_port(int src_port) {
		this.src_port = src_port;
	}
	public int getSrc_port_state() {
		return src_port_state;
	}
	public void setSrc_port_state(int src_port_state) {
		this.src_port_state = src_port_state;
	}
	public String getDst_switch() {
		return dst_switch;
	}
	public void setDst_switch(String dst_switch) {
		this.dst_switch = dst_switch;
	}
	public int getDst_port() {
		return dst_port;
	}
	public void setDst_port(int dst_port) {
		this.dst_port = dst_port;
	}
	public int getDst_port_state() {
		return dst_port_state;
	}
	public void setDst_port_state(int dst_port_state) {
		this.dst_port_state = dst_port_state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
