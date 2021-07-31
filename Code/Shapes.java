import static java.lang.Math.PI;
public class Shapes
{
    public static void main(String[] args)
    {
        //Create a Rectangle (height,length,width,mass)
        ThreeDShape rect1 = new Rectangle_Parallelepiped(5,3,2,50);
        //Print volume of the Rectangle
        System.out.println("Volume of Rectangle Parallelepiped is : " + rect1.Volume());
        //Print area of the Rectangle
        System.out.println("Area of Renctangle Parallelepiped is : " + rect1.Area());

        //Create a Cube (radius,mass)
        ThreeDShape cube1 = new Cube(9,5);
        //Print volume of the Cube
        System.out.println("Volume of Cube is : " + cube1.Volume());
        //Print area of the Cube
        System.out.println("Area of Cube is : " + cube1.Area());

        //Create a Cylinder (height,radius,mass)
        ThreeDShape cylinder1 = new Spherical_Cylinder(9,2,45);
        //Print volume of the Cylinder
        System.out.println("Volume of Cylinder is : " + cylinder1.Volume());
        //Print area of the Cylinder
        System.out.println("Area is Cylinder is : " + cylinder1.Area());

        //Create a Cylinder (radius,mass)
        ThreeDShape sphere1 = new Sphere(3,45);
        //Print volume of the Sphere
        System.out.println("Volume of Sphere is : " + sphere1.Volume());
        //Print area of the Sphere
        System.out.println("Area of Sphere is : " + sphere1.Area());
    }
}

abstract class ThreeDShape
{
    private double length;
    private double height;
    private double width;
    private double mass;

    //Default Contructor
    public ThreeDShape() 
    {
        length = width = height = mass = 0;
    }

    //Contructor of Cube shapes
    public ThreeDShape(double acme,double mass)
    {
        length = width = height = acme;
        this.mass = mass;
    }

    //Constructor of Cylinder shapes
    public ThreeDShape(double height,double radius,double mass)
    {
        width = length = 2*radius;
        this.height = height;
        this.mass = mass;
    }

    //ThreeDshape Constructor
    public ThreeDShape(double length,double height,double width,double mass)
    {
        this.length = length;
        this.height = height;
        this.width = width;
        this.mass = mass;
    }

    // getters
    public double get_length()
    {
        return this.length;
    }

    public double get_height()
    {
        return this.height;
    }

    public double get_width()
    {
        return this.width;
    }

    public double get_mass()
    {
        return this.mass;
    }

    // setters
    public void set_length(double length)
    {
        this.length = length;
    }

    public void set_height(double height)
    {
        this.height = height;
    }

    public void set_width(double width)
    {
        this.width = width;
    }

    public void set_mass(double mass)
    {
        this.mass = mass;
    }

    //abstract methods of Area and Volume
    abstract double Area();
    abstract double Volume();

    //Checks if object shape is empty 
    boolean CheckEmpty()
    {
        if(get_mass() > 0)
            return true;
        else
        {
            System.out.println("Object is empty!");
            return false;
        }
    }

}










// Sphere class inherits from ThreeDShape
class Sphere extends ThreeDShape
{
    private double radius;

    //Constructor Sphere
    public Sphere(double radius,double mass)
    {
        super(0,0,0,mass);
        this.radius = radius;
    }


    //Volume of Sphere
    public double Volume()
    {
        if(CheckEmpty())
            return (4/3 * PI * radius * radius * radius);
        else
            return 0;
    }

    //Area of Sphere
    public double Area()
    {
        if(CheckEmpty())
            return (4*PI*radius*radius);
        else
            return 0;
    }

}






// Spherical_Cylinder class inherits from ThreeDShape
class Spherical_Cylinder extends ThreeDShape
{
    private double radius;

    //Constructor Spherical Cylinder
    public Spherical_Cylinder(double height,double radius,double mass)
    {
        super(height,radius,mass);
        this.radius = radius;
    }

    //getters
    public double get_radius()
    {
        return this.radius;
    }

    //setters
    void set_radius(double radius)
    {
        this.radius = radius;
    }

    // Returns Volume of cylinder
    public double Volume()
    {
        if(CheckEmpty())
            return (PI*radius*radius*get_height());
        return 0;
    }

    //returns Area of cylinder
    public double Area()
    {
        if(CheckEmpty())
            return (PI*radius*2*(radius+get_height()));
        return 0;
    }
}




// Cube class inherits from ThreeDShape
class Cube extends ThreeDShape
{
    //Constructor of cube
    public Cube(double acme,double mass)
    {
        super(acme,mass);
    }

    //Area of cube
    public double Area()
    {
        if(CheckEmpty())
            return (6*get_height()*get_length()*get_width());
        else
            return 0;
    }

    //Volume of cube
    public double Volume()
    {
        if(CheckEmpty())
            return(get_height()*get_length()*get_width());
        return 0;
    }
}



// RectangleParallelepiped class inherits from ThreeDShape
class Rectangle_Parallelepiped extends ThreeDShape
{
    //Constructor Rectangle Parallelepiped
    Rectangle_Parallelepiped(double length,double height,double width,double mass)
    {
        super(length,height,width,mass);
    }
    
    //Volume of rectangle parallelepiped
    public double Volume()
    {
        if(CheckEmpty())
            return(get_height()*get_length()*get_width());
        else
            return 0;
    }

    //Area of rectangle parallelepiped
    public double Area()
    {
        if(CheckEmpty())
            return (2*(get_length()*get_width()+get_length()*get_height()+get_height()*get_width()));
        else
            return 0;
    }

}


