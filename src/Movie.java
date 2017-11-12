import java.util.ArrayList;

public class Movie implements Node {
    public String name;
    public ArrayList<Actor> actors;

    public String getName(){
        return this.name;
    }

    public ArrayList<Actor> getNeighbors(){
        return this.actors;
    }

    public Movie(String name, ArrayList<Actor> actors){
        this.name = name;
        this.actors = actors;
    }

}
