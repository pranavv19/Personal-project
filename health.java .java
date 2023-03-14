import java.util.*;

class messages{
    Scanner sc=new Scanner(System.in);
    int regno;
    String role;
    String message;
    messages(){}
    messages(String rol,int id){
        role=rol;
        regno=id;
        System.out.println("Enter Message To Send");
        message=sc.nextLine();
    }
    void welcome(){
        for (int w1 = 1; w1 <= 5; w1++) {
            for (int w2 = 0; w2 <= 20; w2++) {
                if (w1 == 1 || w1 == 5)
                    System.out.print("--");
                else if (w1 == 3) {
                    System.out.print("        |      MEDICINE HOME      |");
                    break;
                } else if ((w1 == 2 || w1 == 4)) {

                    System.out.print("        |                         |");
                    break;
                }
            }
            System.out.println();

        }
    }
}

class doctor {
    Scanner sc=new Scanner(System.in);
    String dname;
    int regno;
    int dpass;
    messages dM[]=new messages[50];


    doctor() {
        System.out.println("Enter Registration Number");
        regno = sc.nextInt();
        System.out.println("Enter Name:");
        dname = sc.next();
        sc.nextLine();
        System.out.println("Enter Password");
        dpass = sc.nextInt();

    }
    doctor(String n,int id,int p){
        dname=n;
        regno=id;
        dpass=p;
    }

    void showProfile() {
        System.out.println("Name: " + dname);
        System.out.println("Registration Number: " + regno);
        ;
    }

    boolean dSearch(int a) {
        if (a == regno ) {
            return true;
        }
        return false;
    }
    boolean dSearch(int a, int b) {
        if (a == regno && b == dpass) {
            return true;
        }
        return false;
    }
}

class patient {
    Scanner sc=new Scanner(System.in);
    String pname;
    int regno;
    int ppass;
    int mCount=0;
    messages pM[]=new messages[50];
    char bt;
    int age;
    

   

    patient() {
        System.out.println("Enter Registration Number");
        regno = sc.nextInt();
        System.out.println("Enter PName:");
        pname = sc.next();
        sc.nextLine();
        System.out.println("Enter Password");
        ppass = sc.nextInt();
    }
    patient(String n,int id,int p){
        pname=n;
        regno=id;
        ppass=p;
    }
    void showProfile() {
        System.out.println("Name: " + pname);
        System.out.println("Registration Number: " + regno);
        ;
    }
    boolean pSearch(int a) {
        if (a == regno ) {
            return true;
        }
        return false;
    }
    boolean pSearch(int a, int b) {
        if (a == regno && b == ppass) {
            return true;
        }
        return false;
    }
    void viewInbox(){
        for(int show=0;show<mCount;show++){
            System.out.print(pM[show].role+"("+pM[show].regno+"): ");
            System.out.println(pM[show].message);
        }
        System.out.println();

    }
    void addMsg(String rol,int reg){
       pM[mCount]=new messages(rol, reg);
        mCount++;


    }
    void detailsp(){
        System.out.println("Enter The Blood Type of the Person to Donate Blood: ");
        this.bt=sc.next().charAt(0);
        System.out.println("Thank You for donating Blood!");
    }
    void de(){
        System.out.println("Enter The Age of the Person to Donate Eyes: ");
        this.age=sc.nextInt();
        if(age>21&&age<75){
            System.out.println("Thank You for donating Your Vision!");
        }
        else{
            System.out.println("Apologies, Your Age is not Appropriate to Donate your Eyes.");
        }
    }

}


class health {
    public static void main(String[] args) {
        doctor D[] = new doctor[10];
        patient P[] = new patient[20];
        messages m=new messages();
        D[0]= new doctor("Uzair",1,1);
        P[0]= new patient("Anish",1,1);
        m.welcome();
        int role = 0, i = 1, k = 1;
        boolean find = false;
        while (role != 4) {
            int registered = 0, choice = 0, id, pass;
            System.out.println("Enter Your Role:\n1.For Doctor\n2.For Patient\n3.Exit");
            Scanner sc = new Scanner(System.in);
            role = sc.nextInt();
            while (registered != 3) {
                switch (role) {
                    case 1:
                        System.out.println("\nDOCTOR:");
                        System.out.println(
                                "Choose any one to proceed:\n1.Already Registered\n2.Register Yourself\n3.Change Role");
                        registered = sc.nextInt();
                        switch (registered) {
                            case 1:
                                System.out.println("Enter Registration Number");
                                id = sc.nextInt();
                                System.out.println("Enter Your Password");
                                pass = sc.nextInt();
                                for (int j = 0; j < i; j++) {
                                    find = D[j].dSearch(id, pass);
                                    if (find) {
                                        System.out.println("You Logged in Sucessfully!!!\n");
                                        choice = 0;
                                        while (choice != 3) {
                                            System.out.println("1.View Profile");
                                            System.out.println("2.Access Messaging Server");
                                            System.out.println("3.Exit");
                                            choice = sc.nextInt();
                                            switch (choice) {
                                                case 1:
                                                    D[j].showProfile();
                                                    break;
                                                case 2:System.out.println("Doctor Patient Messaging Service\n1.View Message\n2.Send Message");
                                                    int choice2=sc.nextInt();
                                                    switch(choice2){
                                                        case 1:
                                                        System.out.println("Enter Registration Number");
                                                        id = sc.nextInt();
                                                        boolean find2 = false;
                                                        for ( int p = 0; p < k; p++) {
                                                            find2 = P[p].pSearch(id);
                                                            if (find2) {
                                                                if(P[p].mCount==0){
                                                                    System.out.println("No COnversation");
                                                                    break;
                                                                }
                                                                P[p].viewInbox();
                                                                                                                             
                                                                break;
                                                            }
    
                                                        }
                                                        if (!find2) {
                                                            System.out.println("Patient Not Found\n");
                                                        }
                                                        break;

                                                        case 2:
                                                        System.out.println("Enter Registration Number");
                                                        id = sc.nextInt();
                                                        find2 = false;
                                                        for ( int p = 0; p < k; p++) {
                                                            find2 = P[p].pSearch(id);
                                                            if (find2) {
                                                                
                                                                P[p].viewInbox();
                                                                P[p].addMsg("Doctor",D[j].regno);
                                                                
                                                                
                                                                
                                                                break;
                                                            }
    
                                                        }
                                                        if (!find2) {
                                                            System.out.println("Patient Not Found\n");
                                                        }
                                                        break;

                                                    }
                                                    
                                                    
                                                   
                                            }
                                            

                                        }
                                        break;

                                    }
                                    

                                }
                                
                                if (!find)
                                    System.out.println("Wrong Credentials\n");
                                break;

                            case 2:

                                D[i] = new doctor();
                                i++;
                                break;

                        }
                        break;

                        case 2:
                        System.out.println("\nPatient");
                        System.out.println(
                                "Choose any one to proceed:\n1.Already Registered\n2.Register Yourself\n3.Change Role");
                        registered = sc.nextInt();
                        switch (registered) {
                            case 1:
                                System.out.println("Enter ID");
                                id = sc.nextInt();
                                System.out.println("Enter Your Password");
                                pass = sc.nextInt();
                                for (int p = 0; p < k; p++) {
                                    find = P[p].pSearch(id, pass);
                                    if (find) {
                                        System.out.println("You Logged in Sucessfully!!!\n");
                                        choice = 0;
                                        while (choice != 5) {
                                            System.out.println("1.View Profile\n2.Donate Blood\n3.Consult Doctor Via Message\n4.Donate Eyes\n5.Exit");
                                            
                                            choice = sc.nextInt();
                                            switch (choice) {
                                                case 1:
                                                    P[p].showProfile();
                                                    break;
                                                case 2:
                                                    P[p].detailsp();
                                                    break;
                                                    
                                                case 3:
                                                System.out.println("Doctor Patient Messaging Service\n1.View Message\n2.Send Message");
                                                int choice2=sc.nextInt();
                                                switch(choice2){
                                                    case 1:
                                                    System.out.println("Enter Registration Number");
                                                    id = sc.nextInt();
                                                    boolean find2 = false;
                                                    for ( int j = 0; j < i; j++) {
                                                        find2 = D[j].dSearch(id);
                                                        if (find2) {
                                                            if(P[p].mCount==0){
                                                                System.out.println("No Cnversation");
                                                                break;
                                                            }
                                                            P[p].viewInbox();
                                                                                                                         
                                                            break;
                                                        }

                                                    }
                                                    if (!find2) {
                                                        System.out.println("Doctor Not Found\n");
                                                    }
                                                    break;

                                                    case 2:
                                                    System.out.println("Enter Registration Number");
                                                    id = sc.nextInt();
                                                    find2 = false;
                                                    for ( int j = 0; j < i; j++) {
                                                        find2 = D[j].dSearch(id);
                                                        if (find2) {
                                                            
                                                            P[p].viewInbox();
                                                            P[p].addMsg("Patient",P[p].regno);
                                                            
                                                            
                                                            
                                                            break;
                                                        }

                                                    }
                                                    if (!find2) {
                                                        System.out.println("Doctor Not Found\n");
                                                    }
                                                    break;

                                                }
                                                break;
                                                case 4:
                                                P[p].de();
                                                break;

                                                   

                                            }

                                        }
                                        break;

                                    }

                                }
                                if (!find)
                                    System.out.println("Wrong Credentials");
                                break;

                            case 2:
                                
                                P[k] = new patient();
                                k++;

                                break;

                        }

                    
                }
            }
        }
    }
}