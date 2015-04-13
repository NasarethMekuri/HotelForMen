package hotelformen.domain;

public class Service {
    final private int ID;
    private String _name; 
    private String _descripion;
    private double _price;
    
    public Service(int id, String name, String description, double price) {
        ID = id;
        setName(name);
        setDescripion(description);
        setPrice(price);
    }

    public int getID() { return ID; }

    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    public String getDescripion() { return _descripion; }
    public void setDescripion(String descripion) { _descripion = descripion; }

    public double getPrice() { return _price; }
    public void setPrice(double price) { _price = price; }
}
