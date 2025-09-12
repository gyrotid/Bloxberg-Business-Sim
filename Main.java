import java.util.Scanner;
public class Main
{
    
    static class Business 
    {
        //attributes
        private String name;
        private String owner;
        private double funds;
        private static int totalBusinesses = 0;
        public static final double TAX_RATE = 0.1;
        
        /**
         * This associates the name of the business, owner of the business, and the fund they have with the business that is created
         * and adds that to the total numbers of businesses
         * @param name = the name of the business
         * @param owner = the name of the owner
         * @param funds = the int value of the fund the business has
         */
        public Business(String name, String owner, double funds) 
        {
            this.name = name;
            this.owner = owner;
            this.funds = funds;
            totalBusinesses++;
        }

        Business(String busName, double funds)
        {
            this(busName, "", funds);
        }

        Business(String busName)
        {
            this(busName, "", 0.0);
        }
        
        /**
         * This method is used to calculate the funds after taxes are paid
         */
        public void payTaxes() 
        {
            funds -= funds * TAX_RATE;
        }

        public double getTaxes()
        {
            return funds;
        }

        public String getBusName()
        {
            return name;
        }

        public String getOwner()
        {
            return owner;
        }
        
        public double getFunds()
        {
            return funds;
        }

        public int getTotalBus()
        {
            return totalBusinesses;
        }

        /**
         * This class defines the employee's name, role in the company and their salary
         */
        class Employee 
        {
            private String name;
            private String role;
            private double salary;
 
            public Employee(String name, String role, double salary) 
            {
                this.name = name;
                this.role = role;
                this.salary = salary;
            }

            Employee(String name)
            {
                this(name, "", 0.0);
            }

            public String getEmpName()
            {
                return name;
            }

            public String getRole()
            {
                return role;
            }

            public double getSalary()
            {
                return salary;
            }
        }
    }
    
    /**
     * 
     */
    public class BloxburgGame 
    {
        public static void main(String[] args) 
        {
            Scanner input = new Scanner(System.in);
            String busName;
            String ownName;
            double startingFunds = 1000.0;
            String empName;
            String role;
            double salary;

            System.out.println("Welcome to Bloxburg Business Simulator!");
            System.out.println("Total businesses created: " + Business.totalBusinesses);

            //Business & Owner input
            System.out.println("\nPlease enter your name: ");
            ownName = input.nextLine();

            System.out.println("Please enter the name of your new business: ");
            busName = input.nextLine();

            //Employee input
            System.out.println("\nPlease enter the employee's name: ");
            empName = input.nextLine();

            System.out.println("Enter the employee's role: ");
            role = input.nextLine();

            System.out.println("Enter the employee's salary: ");
            salary = input.nextDouble();


            Business newPlace = new Business(busName, ownName, startingFunds);
            Business.Employee newEmployee = newPlace.new Employee(empName, role, salary);
 
            newPlace.payTaxes();

            //Output
            System.out.println("Business name: " + newPlace.getBusName());
            System.out.println("Owner: " + newPlace.getOwner());
            System.out.println("Funds before taxes: " + startingFunds);
            System.out.println("Funds after taxes: " + newPlace.getFunds());
            System.out.println("\nEmployee: " + newEmployee.getEmpName() + " | Role: " + newEmployee.getRole() + " | Salary: " + newEmployee.getSalary() + "/hour");
        }
        
    }

}
