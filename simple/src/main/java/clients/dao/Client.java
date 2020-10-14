package clients.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@Column(name = "client_id")
	private int clientId;

	@Column(name = "name")
	private String name;

	public Client() {

	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + "]";
	}

}
