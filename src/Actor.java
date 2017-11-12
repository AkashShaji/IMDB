import java.util.ArrayList;

public class Actor extends Node{
    public String name;
    public ArrayList<Movie> movies;

    public String getName(){
        return this.name;
    }

    public ArrayList<Movie> getNeighbors(){
        return this.movies;
    }

    public Actor(String name, ArrayList<Movie> movies){
        this.name = name;
        this.movies = movies;
    }

}
