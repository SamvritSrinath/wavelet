import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler{
	ArrayList<String> list = new ArrayList<String>();

	public String handleRequest(URI url){

		if (url.getPath().equals("/")) {
            return "Welcome to the Search Engine, your items are: " + list.toString();
		} else if (url.getPath().contains("/add")) {
			//looking for query param so /add?count=5: Query Parameter
			String[] parameters = url.getQuery().split("=");
			if (parameters[0].equals("s")) {
				list.add(parameters[1]);
				return String.format("Item " + parameters[1] + " was added!");
			}
		}else if(url.getPath().contains("/search")){
				System.out.println("Path: " + url.getPath());
				String[] parameters = url.getQuery().split("=");
				if(parameters[0].equals("s")){
					ArrayList<String> subList = new ArrayList<>();
					String search = parameters[1];
					for(int i = 0; i < list.size(); i++){
						if(list.get(i).contains(search)){

							subList.add(list.get(i));
						}
					}
					return subList.toString();
				}
				return "404 Not Found!";
			
			}
		return "404 Not Found!";
		}
}
public class SearchEngine {
	public static void main(String[] args) throws IOException{
		if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
	

