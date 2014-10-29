package my.model.nav;

import java.util.LinkedList;
import java.util.List;

public class NavObject implements Navigatable {
	private String name;
	private String page;
	protected List<Navigatable> childs = new LinkedList<Navigatable>();
	
	public NavObject(String name, String page) {
		super();
		this.name = name;
		this.page = page;
	
	}
	
	public String getName() {
		return name;
	}
	public String getPage() {
		return page;
	}

	public void addChild(Navigatable child) {
		childs.add(child);
	}

	public Boolean isActive(String page) {
		if (this.testActive(page))
			return true;
		for (Navigatable child : childs)
			if (child.isActive(page))
				return true;
		return false;
	}
	
	public Boolean testActive(String page) {
		return this.page.equals(page);
	}

	public Navigatable exists(String page) {
		for (Navigatable navigatable : childs) {
			if(navigatable.getPage().equals(page)){
				return navigatable;
			}
			Navigatable nav2 =  navigatable.exists(page);
			if (nav2 != null)
				return nav2;
		}
		
		return null;
	}

	public List<Navigatable> getChilds() {
		return childs;
	}


	
	
}
