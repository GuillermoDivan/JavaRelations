package Services;
import Entities.Client;
import java.util.HashMap;
import java.util.Scanner;

public class ClientService {
    HashMap<String, Client> ClientList = new HashMap<String, Client>();
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void addClient(){
        Client c1 = new Client();
        String dni = "";
        System.out.println("Ingrese el DNI del cliente.");
        dni = input.next();
        c1.setDni(dni);
        System.out.println("Ingrese el nombre y apellido del cliente.");
        c1.setName(input.next());
        System.out.println("Ingrese el email del cliente.");
        c1.setEmail(input.next());
        System.out.println("Ingrese el teléfono del cliente.");
        c1.setPhone(input.nextInt());
        System.out.println("Ingrese la dirección del cliente.");
        c1.setAddress(input.next());
        c1.setActive(true);
        ClientList.put(dni, c1);
    }

    public void showClientList(){
        System.out.println(ClientList.toString());
    }

    public void showClientData(){
        Client c1 = lookForClient();
        System.out.println(c1.toString());
    }

    public boolean updateClient(){
        Client c1 = lookForClient();
        System.out.println("¡Cliente " +c1.getDni() + " hallado exitosamente! Elija el campo que desea editar: " +
                "1) Nombre y Apellido. 2) Email. 3) Teléfono. 4) Dirección.");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Ingrese nombre y apellido."); c1.setName(input.next()); break;
            case 2: System.out.println("Ingrese email."); c1.setEmail(input.next()); break;
            case 3: System.out.println("Ingrese teléfono."); c1.setPhone(input.nextInt()); break;
            case 4: System.out.println("Ingrese dirección."); c1.setAddress(input.next()); break;
            default:
                System.out.println("Ha seleccionado una opción no válida."); return false;
        }
        return true;
    }

    public boolean deleteClient() {
        Client c1 = lookForClient();
        if (c1 != null && c1.isActive()) {
            c1.setActive(false);
            System.out.println("El cliente se ha eliminado exitosamente.");
            return true;
        } else if (!c1.isActive()) {
            System.out.println("El cliente ya ha sido eliminado anteriormente.");
        } else {
            System.out.println("No se ha podido eliminar el cliente seleccionado.");
        }
        return false;
    }

    public boolean reactivateClient(){
            Client c1 = lookForClient();
            if (c1 != null && !c1.isActive()) {
                c1.setActive(true);
                System.out.println("El cliente se ha reactivado exitosamente."); }
            else if (c1.isActive()) { System.out.println("El cliente ya se encontraba activo."); }
            else { System.out.println("No se ha podido eliminar el cliente seleccionado."); return false;}
        return true;
    }

    private Client lookForClient(){
        System.out.println("Ingrese el dni del cliente que desea hallar.");
        String searchedDni = input.next();
        if (ClientList.containsKey(searchedDni)) {
            Client c1 = ClientList.get(searchedDni);
            return c1;
        } else {
            System.out.println("El dni buscado no se encontró en la base de datos.");
            return null;
        }
    }
}
