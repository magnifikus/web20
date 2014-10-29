package my.model.nav;

import java.util.List;

public interface Navigatable {
	public void addChild(Navigatable child);
	public List<Navigatable> getChilds();
	public String getName();
	public String getPage();
	public Boolean isActive(String page);
	public Navigatable exists(String page);
	
}
