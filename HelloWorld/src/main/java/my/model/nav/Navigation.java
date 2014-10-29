package my.model.nav;

import java.util.LinkedList;
import java.util.List;

public class Navigation implements Navigatable {

	protected List<Navigatable> childs = new LinkedList<Navigatable>();

	private static Navigation cache = null;

	public static Navigation getNavigation() {
		if (cache == null) {
			cache = new Navigation();
			NavObject t1 = new NavObject("Home", "home.cmd");
			NavObject t2 = new NavObject("Shop", "about.cmd");
			NavObject t3 = new NavObject("Kontakt", "about2.cmd");
			NavObject t4 = new NavObject("MyHelloWorld", "about3.cmd");
			
			cache.addChild(t1);
			cache.addChild(t2);
			cache.addChild(t3);
			cache.addChild(t4);
					
			t2.addChild(new NavObject("Autos", "shop/autos.cmd"));
			t2.addChild(new NavObject("Häuser", "shop/haeuser.cmd"));
			t2.addChild(new NavObject("Boote", "shop/boote.cmd"));
			t2.addChild(new NavObject("Inseln", "shop/inseln.cmd"));
			
			t3.addChild(new NavObject("Anfahrt", "adr.cmd"));
			t3.addChild(new NavObject("Impressum", "adr.cmd"));
			t3.addChild(new NavObject("Kontaktformular", "adr.cmd"));
			
			
			t4.addChild(new NavObject("Login", "adr.cmd"));
			t4.addChild(new NavObject("Signup", "adr.cmd"));
	
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
	
	
	
	private Navigatable getActiveTab(String page) {
		for (Navigatable nav : childs)
			if (nav.isActive(page))
				return nav;
		return null;
	}
	public List<Navigatable> getSubPages(String page) {
		Navigatable tab = this.getActiveTab(page);
		if (tab == null)
			return new LinkedList<Navigatable>();
		return tab.getChilds();
		
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
