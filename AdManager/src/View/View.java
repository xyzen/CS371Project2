/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import UserView.UserView;

/**
 *
 * @author Tyler
 */
public class View {
    private Controller master;
    private UserView uv;
    private ModView mv;
    private LoginView lv;
    
    public View(Controller master) {
        this.master = master;
    }
    
    public void populateSTDUserTable(String[][] published_data) {
        uv.populateSTDTable(published_data);
    }
    
    public void populateMyUserTable(String[][] my_data) {
        uv.populateMyTable(my_data);
    }
    
    public void populateSTDModTable(String[][] published_data) {
        mv.populateSTDTable(published_data);
    }
    
    public void populateMyModTable(String[][] my_data) {
        mv.populateMyTable(my_data);
    }
    
    public void showEditAdvertisements() {
        uv.showEditAdvertisements();
    }

    public void show(){
       
    }
}
