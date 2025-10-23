package project.annotations.api;
import project.annotations.ConceptualAPIPrototype;

public class EnginePrototype {
	@ConceptualAPIPrototype
    public void prototype(EngineAPI computeapi) {
    	 String result = computeapi.compute(42);
         System.out.println("Prototype compute(42): " + result);
    }
}