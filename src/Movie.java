import java.util.ArrayList;

public class Movie implements Node {

    private String name;
    private ArrayList<Actor> actors;

    public String getName(){
        return this.name;
    }

    public ArrayList<Actor> getNeighbors(){
        return this.actors;
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }

    public Movie(String name, ArrayList<Actor> actors){
        this.name = name;
        this.actors = actors;
    }

}
