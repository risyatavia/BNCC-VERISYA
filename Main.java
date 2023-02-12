package verisya_lnt;

import java.util.Scanner;
import java.util.Formatter;
class HelloWorld {
    
    static void menu (){
        System.out.println("1. Input");
        System.out.println("2. View");
        System.out.println("3. Remove");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
        
    }
    
    static void view (String name[], String gender[], String jabatan[], int counter){
        Formatter fmt = new Formatter();
        
        fmt.format("%s %s %s %s %s\n", "No.","Nama", "Jenis kelamin", "Jabatan");
        
        for(int i=0;i<counter;i++){
            fmt.format("%s %s %s %s %s", i+1,name[i], gender[i], jabatan[i]);
                        
                    }
        System.out.println(fmt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        
        String name[] = new String[100];
        String gender[] = new String[100];
        String jabatan[] = new String[100];
        
        
        int counter = 0;
        
        do{
            menu();
            input = sc.nextInt();
            
            switch(input){
            case 1:
                //menu 1
                System.out.println("Input Data");
                Scanner sc1 = new Scanner(System.in);
                String input_name;
                String split_name[];
                String input_gender;
                String input_jabatan;
                
                do{
                    System.out.print("Input nama karyawan [>= 3]: ");
                    input_name = sc1.nextLine();
                    
                    split_name = input_name.trim().split(" ");
    
                }while(
                    (input_name.length() < 3 ) || 
                    
                    split_name.length < 2 
                );
                
                do{
                    System.out.print("Input jenis kelamin [Laki-laki | Perempuan] : ");
                    input_gender = sc1.nextLine();
                } while(!input_gender.equals("Laki-laki") && !input_gender.equals("Perempuan")
                );
                
                do{
                	 System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
                     input_jabatan = sc1.nextLine();
                }while(!input_jabatan.equals("Manager") && !input_jabatan.equals("Supervisor") && !input_jabatan.equals("Admin")
                        );
                
                
                for(int i=0;i<split_name.length;i++){
                    System.out.print(split_name[i].toUpperCase().charAt(0));
                }
                
                name[counter] = input_name;
                gender[counter] = input_gender;
                jabatan[counter] = input_jabatan;
                
                counter++;
            
                for(int i=0;i<counter-1;i++){
                    for(int j = 0; j<counter-i-1;j++){
                        if(name[j].compareTo(name[j+1]) > 0){
                            String temp = name[j];
                            name[j] = name[j+1];
                            name[j+1] = temp;
                            
                            String temp_gender = gender[j];
                            gender[j] = gender[j+1];
                            gender[j+1] = temp_gender;
                            
                            String temp_jabatan = jabatan[j];
                            jabatan[j] = jabatan[j+1];
                            jabatan[j+1] = temp_jabatan;
                            
                            
                            
                        }
                        
                    }
                }
                                 
                                
                
                break;
            case 2:
                
                
                System.out.println("View Data");
                if(counter == 0){
                    System.out.println("No Data");
                }
                else{
                    view(name,gender,jabatan, counter);
                }
                break;
            case 3: 
                
                System.out.println("Remove Data");
                 if(counter == 0){
                    System.out.println("No Data");
                }
                else{
                    view(name,gender,jabatan, counter);
                }
                
                Scanner sc2 = new Scanner(System.in);
                
                System.out.print("Input number: ");
                int input_delete = sc2.nextInt();
                    if(input_delete == 0){
                        break;
                    }
                int delete_array = input_delete - 1;
               
                
                for(int i= delete_array; i<counter-1; i++){
                    name[i] = name[i+1];
                    gender[i] = gender[i+1];
                    jabatan[i] = jabatan[i+1];
                
                }
                
                counter --;
                System.out.println("Successfully deleted");
                
                break;
            case 4:
                break;
            
            }
        }while(input != 4);
        
    }}
