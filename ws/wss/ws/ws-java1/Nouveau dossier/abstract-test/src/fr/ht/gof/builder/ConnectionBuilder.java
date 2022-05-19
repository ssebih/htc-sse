package fr.ht.gof.builder;

public class ConnectionBuilder {

	private String login;
	private String pwd;
	private String url;
	private String dbName;
	private boolean acceptSss;

	private ConnectionBuilder() {
		// TODO Auto-generated constructor stub
	}

	public static ConnectionBuilder build() {
		return new ConnectionBuilder();
	}

	public ConnectionBuilder addLogin(String login) {
		this.login = login;
		return this;
	}

	public ConnectionBuilder addPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public ConnectionBuilder addUrl(String url) {
		this.url = url;
		return this;
	}

	public ConnectionBuilder addDBName(String dbName) {
		this.dbName = dbName;
		return this;
	}

	public ConnectionBuilder acceptSSL() {
		this.acceptSss = true;
		return this;
	}

	@Override
	public String toString() {
		return "ConnectionBuilder [login=" + login + ", pwd=" + pwd + ", url=" + url + ", dbName=" + dbName
				+ ", acceptSss=" + acceptSss + "]";
	}

	public ConnectionBuilder noSSL() {
		this.acceptSss = false;
		return this;
	}
	


}
