package aasdntool;

import java.util.ArrayList;

public class Switches {
	public String inetAddress;
	public String role;
	public static class Ports{
		public String hardwareAddress;
		public long portNumber;
		public long config;
		public long currentFeatures;
		public long advertisedFeatures;
		public long supportedFeatures;
		public long peerFeatures;
		public String name;
		public long state;
		public String getHardwareAddress() {
			return hardwareAddress;
		}
		public void setHardwareAddress(String hardwareAddress) {
			this.hardwareAddress = hardwareAddress;
		}
		public long getPortNumber() {
			return portNumber;
		}
		public void setPortNumber(long portNumber) {
			this.portNumber = portNumber;
		}
		public long getConfig() {
			return config;
		}
		public void setConfig(long config) {
			this.config = config;
		}
		public long getCurrentFeatures() {
			return currentFeatures;
		}
		public void setCurrentFeatures(long currentFeatures) {
			this.currentFeatures = currentFeatures;
		}
		public long getAdvertisedFeatures() {
			return advertisedFeatures;
		}
		public void setAdvertisedFeatures(long advertisedFeatures) {
			this.advertisedFeatures = advertisedFeatures;
		}
		public long getSupportedFeatures() {
			return supportedFeatures;
		}
		public void setSupportedFeatures(long supportedFeatures) {
			this.supportedFeatures = supportedFeatures;
		}
		public long getPeerFeatures() {
			return peerFeatures;
		}
		public void setPeerFeatures(long peerFeatures) {
			this.peerFeatures = peerFeatures;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getState() {
			return state;
		}
		public void setState(long state) {
			this.state = state;
		}
	}
	public ArrayList<Ports> ports;
	public int buffers;

	public static class FeaturesReplyFromSwitch {
		public int transactionId;
		public boolean cancelled;
		public boolean done;

		public int getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}

		public boolean isCancelled() {
			return cancelled;
		}

		public void setCancelled(boolean cancelled) {
			this.cancelled = cancelled;
		}

		public boolean isDone() {
			return done;
		}

		public void setDone(boolean done) {
			this.done = done;
		}
	}

	public FeaturesReplyFromSwitch featuresReplyFromSwitch;
	public long connectedSince;
	public long capabilities;
	public long tables;
	public long actions;
	public String dpid;

	public static class Attributes {
		public boolean supportsOfppFlood;
		public long FastWildcards;

		public static class DescriptionData {
			public String manufacturerDescription;
			public String hardwareDescription;
			public String softwareDescription;
			public String datapathDescription;
			public String serialNumber;
			public long length;

			public String getManufacturerDescription() {
				return manufacturerDescription;
			}

			public void setManufacturerDescription(String manufacturerDescription) {
				this.manufacturerDescription = manufacturerDescription;
			}

			public String getHardwareDescription() {
				return hardwareDescription;
			}

			public void setHardwareDescription(String hardwareDescription) {
				this.hardwareDescription = hardwareDescription;
			}

			public String getSoftwareDescription() {
				return softwareDescription;
			}

			public void setSoftwareDescription(String softwareDescription) {
				this.softwareDescription = softwareDescription;
			}

			public String getDatapathDescription() {
				return datapathDescription;
			}

			public void setDatapathDescription(String datapathDescription) {
				this.datapathDescription = datapathDescription;
			}

			public String getSerialNumber() {
				return serialNumber;
			}

			public void setSerialNumber(String serialNumber) {
				this.serialNumber = serialNumber;
			}

			public long getLength() {
				return length;
			}

			public void setLength(long length) {
				this.length = length;
			}
		}

		public DescriptionData DescriptionData;
		public boolean supportsOfppTable;

		public boolean isSupportsOfppFlood() {
			return supportsOfppFlood;
		}

		public void setSupportsOfppFlood(boolean supportsOfppFlood) {
			this.supportsOfppFlood = supportsOfppFlood;
		}

		public long getFastWildcards() {
			return FastWildcards;
		}

		public void setFastWildcards(long FastWildcards) {
			this.FastWildcards = FastWildcards;
		}

		public DescriptionData getDescriptionData() {
			return DescriptionData;
		}

		public void setDescriptionData(DescriptionData DescriptionData) {
			this.DescriptionData = DescriptionData;
		}

		public boolean isSupportsOfppTable() {
			return supportsOfppTable;
		}

		public void setSupportsOfppTable(boolean supportsOfppTable) {
			this.supportsOfppTable = supportsOfppTable;
		}
	}

	public Attributes attributes;

	public String getInetAddress() {
		return inetAddress;
	}

	public void setInetAddress(String inetAddress) {
		this.inetAddress = inetAddress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<Ports> getPorts() {
		return ports;
	}

	public void setPorts(ArrayList<Ports> ports) {
		this.ports = ports;
	}

	public int getBuffers() {
		return buffers;
	}

	public void setBuffers(int buffers) {
		this.buffers = buffers;
	}

	public FeaturesReplyFromSwitch getFeaturesReplyFromSwitch() {
		return featuresReplyFromSwitch;
	}

	public void setFeaturesReplyFromSwitch(FeaturesReplyFromSwitch featuresReplyFromSwitch) {
		this.featuresReplyFromSwitch = featuresReplyFromSwitch;
	}

	public long getConnectedSince() {
		return connectedSince;
	}

	public void setConnectedSince(long connectedSince) {
		this.connectedSince = connectedSince;
	}

	public long getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(long capabilities) {
		this.capabilities = capabilities;
	}

	public long getTables() {
		return tables;
	}

	public void setTables(long tables) {
		this.tables = tables;
	}

	public long getActions() {
		return actions;
	}

	public void setActions(long actions) {
		this.actions = actions;
	}

	public String getDpid() {
		return dpid;
	}

	public void setDpid(String dpid) {
		this.dpid = dpid;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	
}
