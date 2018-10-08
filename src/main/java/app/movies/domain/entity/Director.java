package app.movies.domain.entity;

public class Director {

	private long id;
	private String identityDocument;
	private String name;
	
	
	
	protected void setId(long id) {
		this.id = id;
	}
	protected void setIdentityDocument(String identityDocument) {
		this.identityDocument = identityDocument;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public String getIdentityDocument() {
		return identityDocument;
	}
	public String getName() {
		return name;
	}
	

}
