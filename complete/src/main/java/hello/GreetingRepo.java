package hello;

import java.util.ArrayList;

public class GreetingRepo {
    ArrayList<Greeting> greetings = new ArrayList<Greeting>();

    public void add(Greeting greeting){
        greetings.add(greeting);
    }

    public int size(){
        return greetings.size();
    }

    public ArrayList<Greeting> getGreetings() {
        return greetings;
    }
}
