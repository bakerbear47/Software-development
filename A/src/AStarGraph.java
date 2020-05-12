import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStarGraph {
    private ArrayList<Vertex> vertices;
    public AStarGraph() {
        vertices=new ArrayList<Vertex>();
    }
    public void addvertex(Vertex v) {
        vertices.add(v);
    }
    public void newconnection(Vertex v1, Vertex v2, Double dist) {
        v1.addOutEdge(v2,dist);
        v2.addOutEdge(v1,dist);
    }
    public boolean A_Star(Vertex start, Vertex destination)
    {   if (start==null || destination==null)
        return false;
        PriorityQueue<Vertex> Openlist = new PriorityQueue<Vertex>();
        ArrayList<Vertex> Closedlist = new ArrayList<Vertex>();
        Openlist.offer(start);
        Vertex Current;
        ArrayList<Vertex> CurrentNeighbors; // Current.getNeighbors()
        Vertex Neighbor; //Current.getNeighbors().get(i) and the distance to this is current.getNeighoursDistance().get(i)
        //Initialize h with chosen heuristic

        for (int i =0; i<vertices.size();i++)
        {
            vertices.get(i).setPrev(null);
            vertices.get(i).seth(Manhattan(vertices.get(i),destination));
            //vertices.get(i).getNeighbours();
            //vertices.get(i).getNeighbourDistance();


            Openlist.offer(vertices.get(i));

        }
        Openlist.remove(start);
        start.setg(0.0);

        Openlist.offer(start);

        //Start algorithm
        System.out.println("Start Algorithm");
        //Implement the Astar algorithm
        while (!Openlist.isEmpty()){
            Current = Openlist.poll();
            if(Current.equals(destination)){
                return true;
            }
            Closedlist.add(Current);

            CurrentNeighbors = Current.getNeighbours();

            for(int i = 0; i< CurrentNeighbors.size(); i++){

                Neighbor = CurrentNeighbors.get(i);

                //if(Neighbor && (Current.geth() + CurrentNeighbors.get(i).getNeighbourDistance() < Neighbor.geth())){
                    Current.getPrev();
                }

                 //Neighbor = Current.getNeighbours() + Current.getNeighbourDistance().get(i);
                        //CurrentNeighbors.get(i).addOutEdge(Current, );


               // if(Nextvertex && (Current.getf() + CurrentNeighbors.get(i) < Nextvertex.getNeighbourDistance()))





              // Current.getNeighbourDistance() = Current.getNeighbours(i);
                //double Neighbor = Current.getg() + Current.getNeighbourDistance().get(i);
                //if(tempgofv < Current.getg()){
                //if(Current.getNeighbourDistance() && (Current.getg() + Current.getNeighbours().get(i)<Current.getNeighbourDistance())){

                    //Current.setPrev(Current.Neighbor) = Current;
                    //Current.getNeighbours().get(i).getPrev()= Current;
                }




        return false;
    }
    public Double Manhattan(Vertex from,Vertex goal){
        //Implement this
        double D = 0;
        //for(int getx = 0; getx < vertices.size(); getx++){
          //  for(int gety = 0; gety < vertices.size(); gety++){
                int dx = Math.abs(from.getx() - goal.getx());
                int dy = Math.abs(from.gety() - goal.gety());
                D = vertices.size() * (dx + dy);
                //D = vertices.size() * (Math.abs(from.getx()-goal.getx())+Math.abs(from.gety()-goal.gety()));
            //}
        //}
        return D;
    }
    public Double Euclidean( Vertex from,Vertex to){
        //Implement this
        return 0.0;
    }
}

class Vertex implements Comparable<Vertex>{
    private String id;
    private ArrayList<Vertex> Neighbours=new ArrayList<Vertex>();
    private ArrayList<Double> NeighbourDistance =new ArrayList<Double>();
    private Double f;
    private Double g;
    private Double h;
    private Integer x;
    private Integer y;
    private Vertex prev =null;
    public Vertex(String id, int x_cor,int y_cor){
        this.id=id;
        this.x = x_cor;
        this.y = y_cor;
        f=Double.POSITIVE_INFINITY;
        g=Double.POSITIVE_INFINITY;
        h=0.0;
    }
    public void addOutEdge(Vertex toV, Double dist){
        Neighbours.add(toV);
        NeighbourDistance.add(dist);
    }
    public ArrayList<Vertex> getNeighbours(){
        return Neighbours;
    }
    public ArrayList<Double> getNeighbourDistance(){
        return NeighbourDistance;
    }
    public String getid(){ return id;};
    public Integer getx(){ return x; }
    public Integer gety(){return y; }
    public Double getf() { return f; }
    public void calculatef(){ f=g+h; }

    public Double getg() { return g; }

    public void setg(Double newg){ g=newg; calculatef();}
    public Double geth(){ return h; }
    public void seth(Double estimate){ h=estimate; calculatef();}
    public Vertex getPrev() { return prev; }
    public void setPrev(Vertex v){prev=v;}
    public void printVertex(){
        System.out.println(id + " g: "+g+ ", h: "+h+", f: "+f);
    }
    @Override
    public int compareTo(Vertex o) {
        if (this.f > o.getf()+0.00001){
            return 1;}
        else if (this.f < o.getf()+0.00001){
            return -1;}
        else {
            return 0;
        }
    }
}
