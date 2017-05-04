package fastTextContent;
import fastTextContent.getRequest;

public class MiThread implements Runnable {
	private String palabra;
	public MiThread(String pPalabra){
		palabra = pPalabra;
	}
	    Thread t;
	    public void run() {
	        getRequest html = new getRequest();
	        try {
				html.sendGet(palabra);
			} catch (Exception e) {
				System.out.println("No se pudo.");
			}
	    }
}
