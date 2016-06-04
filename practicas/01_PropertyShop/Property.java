 
package propertyshop;
 
public class Property {
    String name;
    String addres;
    double constructedSurface;
    double availabeSurface;
    String ownername;
    String owneraddres;
    int price;
    
    /**
     * constructor to initialize the object. It is not mandatory to implement
     */
    public Property() {
        String name ="";
        String addres ="";
        float  constructedSurface = 0;
        float  availabeSurface = 0;
        String ownername = "";
        String owneraddres = "";
        int price = 0;
    }

    /**
     * Method to set the name of the Property (lowercase)
     */
    public void setName(String name)
    {
        if (name != null)
            this.name = name.toLowerCase();
    }

    /**
     * Method to set the adress of th Property (uppercase)
     */
    public void setAddress(String addres)
    {
        if (addres != null)
            this.addres = addres.toUpperCase();
    }

    /** 
     * Method to set in meters the constructed surface of the Property.
     * Must be greates than zero
     */
    public void setConstructedSurface(double meters)
    {
        if (meters > 0)
            constructedSurface = meters;
    }

    /** 
     * Method to set in meters the available surface of the Property. 
     * Must be greates than zero
     */    
    public void setAvailableSurface(double meters)
    {
        if (meters > 0)
            availabeSurface = meters;
    }   

    /**
     * Method to set the owner's name
     */
    public void setOwner(String ownername)
    {
        if (ownername != null)
            this.ownername = ownername;
    }  

    /** 
     * Method to set the owner's adress
     */
    public void setOwnerAddress(String owneradress)
    {
        if (owneradress != null)
            this.owneraddres = owneradress;
    } 
 
     /** 
     * Method to set the price of the property. Must be greates than zero
     */
    
    public void setPrice(int price)
    {
        if( price > 0)
            this.price = price;
    } 

    /**
     * Method to get the name of the property
     */
    public String getName()
    {
        return name;
    }
 
    /** 
     * Method to get the adress of the property
     */
    public String getAddress()
    {
        return addres;
    }

    /** 
     * Method to get the surface constructed
     */
    public double getConstructedSurface()
    {
        return constructedSurface;
    }
    
    /** 
     * Method to get the surface avaible
     */    
    public double getAvailableSurface()
    {
        return availabeSurface;
    }   
    
    /** 
     * Method to get the owner's name
     */    
    public String getOwner()
    {
        return ownername;
    }  

    /** 
     * Method to get the owner's adress
     */  
    public String getOwnerAddress()
    {
        return owneraddres;
    } 
    
    /** 
     * Method to get the  price of the property
     */  
    public int getPrice()
    {
        return price;
    } 


}
