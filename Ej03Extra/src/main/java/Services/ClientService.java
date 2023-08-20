package Services;
import Entities.Client;
import java.util.HashMap;
import java.util.Scanner;

public class ClientService {
    HashMap<String, Client> ClientList = new HashMap<String, Client>();
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    /*addClient method charges all attributes to the object and puts it as a value of the hasmap
    ClientList. The key in each case is the DNI. Active attribute always sets active when a client
    is added. */
    public Client addClient(){
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
        return c1;
    }

    /*In progress. They're four show-related methods needed: showAllClientList,
    showActiveClientList, showInactiveClientList, showClientData. The only one that's suposed to be
    accesed by the client is their own "showClientData". That would be programmed on diferent
    menus for client and salesman.*/
    public void showAllClientList(){
        System.out.println(ClientList.toString());
    }
    public void showActiveClientList() {
        for (HashMap.Entry<String, Client> i : ClientList.entrySet()) {
            if (i.getValue().isActive()) { System.out.print(ClientList.toString()); }
        }
    }
    public void showInactiveClientList() {
        for (HashMap.Entry<String, Client> i : ClientList.entrySet()) {
            if (!i.getValue().isActive()) { System.out.print(ClientList.toString()); }
        }
    }
    public void showClientData(){
        Client c1 = lookForClient();
        { System.out.println(c1.toString()); } }

    /*UpdateClient method might be usefull to be accesed by both client and salesman,
    in order to keep contact data updated. Maybe paymentMode information should be included
    here to.*/
    public boolean updateClient(){
        Client c1 = lookForClient();
        System.out.println("¡Cliente " +c1.getDni() + " hallado exitosamente! Elija el campo que " +
                "desea editar: 1) Nombre y Apellido. 2) Email. 3) Teléfono. 4) Dirección.");
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

    /*DeleteClient must be logical, as turning off the "active" attribute. Therefore, it should be a
    "ReactiveteClient method that turns it on if needed. This method should only be accesible
    by salesman and/or be triggered when the associated policy is properly finished.*/
    public boolean deleteClient() {
        Client c1 = lookForClient();
        //if () Póliza asociada !isActive...
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
