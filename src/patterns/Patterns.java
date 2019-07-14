/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

/**
 *
 * @author Estudiante
 */
public class Patterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        client bob = new client();
        burgerBuilder cheeseBurger = new CheeseBurgerBuilder();
        burgerBuilder veggieBurger = new VeggieBurgerBuilder();
        
        bob.setBurgerBuilder(cheeseBurger);
        bob.constructBurger();
        
        Burger burger = bob.getArepa();
        System.out.println(burger.getDrink());
        
    }
    static class Burger{
        private String sauce = "";
        private String type = "";
        private String meat = "";
        private String drink = "";
        
        public void setType(String tipo){
            this.type = tipo;
        }
        
        public void setSauce(String salsa){
            this.sauce = salsa;
        }
        
        public void setMeat(String relleno){
            this.meat = relleno;
        }
        
        public void setDrink(String bebida){
            this.drink = bebida;
        }
        public String getType(){
            return this.type;
        }
        
        public String getSauce(){
            return this.sauce;
        }
        
        public String getMeat(){
            return this.meat;
        }
        
        public String getDrink(){
            return this.drink;
        }
    }
    
    static abstract class burgerBuilder{
        protected Burger burger;
        
        public Burger getBurger(){
            return burger;
        }
        
        public void createNewBurger(){
            burger = new Burger();
        }
        
        public abstract void buildType();
        public abstract void buildSauce();
        public abstract void buildMeat();
        public abstract void buildDrink();
    }
    
    static class CheeseBurgerBuilder extends burgerBuilder {
        @Override
        public void buildType(){
            burger.setType("cheese");
        }
        @Override
        public void buildSauce(){
            burger.setSauce("mayo");
        }
        @Override
        public void buildMeat(){
            burger.setMeat("beef");
        }
        @Override
        public void buildDrink(){
            burger.setDrink("pepsi");
        }
    }
    
    static class VeggieBurgerBuilder extends burgerBuilder{
        @Override
        public void buildType(){
            burger.setType("veggie");
        }
        @Override
        public void buildSauce(){
            burger.setSauce("ketchup");
        }
        @Override
        public void buildMeat(){
            burger.setMeat("veggie");
        }
        @Override
        public void buildDrink(){
            burger.setDrink("Cocacola");
        }
    }
    
    static class client{
        private burgerBuilder burgerBuilder;
        
        public void setBurgerBuilder(burgerBuilder ab){
            burgerBuilder = ab;
        }
        
        public Burger getArepa(){
            return burgerBuilder.getBurger();
        }
        
        public void constructBurger(){
            burgerBuilder.createNewBurger();
            burgerBuilder.buildType();
            burgerBuilder.buildSauce();
            burgerBuilder.buildMeat();
            burgerBuilder.buildDrink();
        }
    }
    
}
