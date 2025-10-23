package project.annotations.api;
import project.annotations.NetworkAPIPrototype;

public class UserPrototype {
	@NetworkAPIPrototype
    public void prototype(UserAPI userapi) {
    	 userapi.setInput("file://inputs.txt");
         userapi.setOutput("file://outputs.txt");
         userapi.useDefaultDelimiters(); 
    }
}