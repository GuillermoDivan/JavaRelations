package Services;

import Entities.Viewer;

public class ViewerService {
    public Viewer createViewer(){
        Viewer v = new Viewer();
        int name = (int)(Math.random()*100);
        int age = (int)(Math.random()*75);
        double money = Math.random()*500;
        v.setName(name);
        v.setAge(age);
        v.setMoney(money);
        return v;
    }


}
