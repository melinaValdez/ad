package fastTextContent;

public class Main {

	public static void main(String[] args) {
			try{
				getRequest request = new getRequest();
				String momo = request.sendGet("perro").toString();
				System.out.println(momo);
			}
			catch (Exception e){
				System.out.println("Jaja pendeja");
			}
		}
}
