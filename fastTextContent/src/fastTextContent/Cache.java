package fastTextContent;
import java.util.Hashtable;

public class Cache {
	private Hashtable<String, String> memory;
	private static Cache cacheMemory;
	
	public  static Cache getCache() {
		 
		 if (cacheMemory == null) {
		 
			 cacheMemory = new Cache();
		 }
		 return cacheMemory;
	}
	
	private Cache(){
		
	}
	
	public String searchHTML(String pKey){
		if (memory.get(pKey) != null){
			return memory.get(pKey);
		}
		return null;
	}
	
	public boolean insertHTML(String pKey, String pHTML){
		memory.put(pKey, pHTML);
		return true;
	}
}