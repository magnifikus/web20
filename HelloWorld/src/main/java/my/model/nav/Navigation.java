package my.model.nav;

import java.util.LinkedList;
import java.util.List;

public class Navigation implements Navigatable {

	protected List<Navigatable> childs = new LinkedList<Navigatable>();

	private static Navigation cache = null;

	public static Navigation getNavigation() {
		if (cache == null) {
			cache = new Navigation();
			NavObject t1 = new NavObject("Home", "home.jsp");
			NavObject t2 = new NavObject("About", "about.jsp");
			NavObject t3 = new NavObject("Impressum", "about2.jsp");
			NavObject t4 = new NavObject("Killswitch", "about3.jsp");
			
			cache.addChild(t1);
			cache.addChild(t2);
			cache.addChild(t3);
			cache.addChild(t4);
			
			NavObject p1 = new NavObject("Adresse", "adr.jsp");
			t2.addChild(p1);
			
			
		}
		
		return cache;
	}
	

	
	
	public void addChild(Navigatable child) {
		childs.add(child);
	}

	public Navigatable getParent() {
		return null;
	}

	public List<Navigatable> getChilds() {
		return childs;
	}

	public String getName() {
		return null;
	}

	public String getPage() {
		return null;
	}

	public Boolean isActive(String page) {
		return false;
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
	

}
