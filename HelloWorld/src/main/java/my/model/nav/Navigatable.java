package my.model.nav;

public interface Navigatable {
	public void addChild(Navigatable child);
	public String getName();
	public String getPage();
	public Boolean isActive(String page);
	public Navigatable exists(String page);
	
}
