package project.annotations.api;

public class UserPrototype {
    public void prototype(UserAPI userapi) {
    	 userapi.setInput("file://inputs.txt");
         userapi.setOutput("file://outputs.txt");
         userapi.useDefaultDelimiters(); 
    }
}