
package java2project;

public class EnumerationClass {
    enum CabinClass
    {
    ECONOMY_CLASS,PRESTIGE_CLASS,FIRST_CLASS;
    }
    enum Plane
    {
        AIRBUSA350(270),AIRBUSA280(500),BOEING737(215),BOEING747(460);
        private int passengerCapacity;
        private Plane(int passengerCapacity)
        {
            this.passengerCapacity=passengerCapacity;
        }
        public int getPassengerCapacity()
        {
            return passengerCapacity;
        }
        
            
    };
    
            
    }

