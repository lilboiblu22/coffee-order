package edu.iu.habahram.coffeeorder;


import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ModelTest {

    @Test
    public void testHouseBlend() {
        HouseBlend houseBlend = new HouseBlend();
        assert(houseBlend.getDescription().equals("House Blend"));
        assert(houseBlend.cost() == 1.65F);
    }

    @Test
    public void testHouseBlendWithMocha() {
        Mocha mocha = new Mocha(new HouseBlend());
        assert(mocha.getDescription().equals("House Blend, Mocha"));
        assert(mocha.cost() == 1.95F);
    }

    @Test
    public void testHouseBlendWithMilk() {
        Milk milk = new Milk(new HouseBlend());
        assert(milk.getDescription().equals("House Blend, Milk"));
        assert(milk.cost() == 2.05F);
    }

    @Test
    public void testHouseBlendWithWhip() {
        Whip whip = new Whip(new HouseBlend());
        assert(whip.getDescription().equals("House Blend, Whip"));
        assert(whip.cost() == 1.9F);
    }

    @Test
    public void testHouseBlendWithSoy(){
        Soy soy = new Soy(new HouseBlend());
        assert(soy.getDescription().equals("House Blend, Soy"));
        assert(soy.cost() == 1.92F);
    }

    @Test
    public void testEspresso() {
        Espresso espresso = new Espresso();
        assert(espresso.getDescription().equals("Espresso"));
        assert(espresso.cost() == 1.34F);
    }

    @Test
    public void testEspressoWithMocha() {
        Mocha mocha = new Mocha(new Espresso());
        mocha.getDescription();
        assert(mocha.getDescription().equals("Espresso, Mocha"));
        //added delta to the assertEquals since floating points wee not matching exactly
        assertEquals(1.64F, mocha.cost(), 0.01);

    }

    @Test
    public void testEspressoWithMilk() {
        Milk milk = new Milk(new Espresso());
        assert(milk.getDescription().equals("Espresso, Milk"));
        assert(milk.cost() == 1.74F);
    }

    @Test
    public void testEspressoWithWhip() {
        Whip whip = new Whip(new Espresso());
        assert(whip.getDescription().equals("Espresso, Whip"));
        assert(whip.cost() == 1.59F);
    }

    @Test
    public void testEspressoWithSoy() {
        Soy soy = new Soy(new Espresso());
        assert(soy.getDescription().equals("Espresso, Soy"));
        assert(soy.cost() == 1.61F);
    }

    @Test
    public void testDecaf() {
        Decaf decaf = new Decaf();
        assert(decaf.getDescription().equals("Decaf"));
        assert(decaf.cost() == 1.28F);
    }

    @Test
    public void testDecafWithMocha() {
        Mocha mocha = new Mocha(new Decaf());
        assert(mocha.getDescription().equals("Decaf, Mocha"));
        //added delta to the assertEquals since floating points wee not matching exactly
        assertEquals(1.58F, mocha.cost(), 0.01);
    }

    @Test
    public void testDecafWithMilk() {
        Milk milk = new Milk(new Decaf());
        assert(milk.getDescription().equals("Decaf, Milk"));
        assert(milk.cost() == 1.68F);
    }

    @Test
    public void testDecafWithWhip() {
        Whip whip = new Whip(new Decaf());
        assert(whip.getDescription().equals("Decaf, Whip"));
        assert(whip.cost() == 1.53F);
    }

    @Test
    public void testDecafWithSoy() {
        Soy soy = new Soy(new Decaf());
        assert(soy.getDescription().equals("Decaf, Soy"));
        assert(soy.cost() == 1.55F);
    }

    @Test
    public void testDarkRoast(){
        DarkRoast darkRoast = new DarkRoast();
        assertEquals(darkRoast.getDescription(), "Dark Roast");
        assertEquals(darkRoast.cost(), 1.99F);
    }

    @Test
    public void testDarkRoastWithMocha() {
        Mocha mocha = new Mocha(new DarkRoast());
        assert(mocha.getDescription().equals("Dark Roast, Mocha"));
        assert(mocha.cost() == 2.29F);
    }

    @Test
    public void testDarkRoastWithMilk() {
        Milk milk = new Milk(new DarkRoast());
        assert(milk.getDescription().equals("Dark Roast, Milk"));
        assert(milk.cost() == 2.39F);
    }

    @Test
    public void testDarkRoastWithWhip() {
        Whip whip = new Whip(new DarkRoast());
        assert(whip.getDescription().equals("Dark Roast, Whip"));
        assert(whip.cost() == 2.24F);
    }

    @Test
    public void testDarkRoastWithSoy() {
        Soy soy = new Soy(new DarkRoast());
        assert(soy.getDescription().equals("Dark Roast, Soy"));
        assert(soy.cost() == 2.26F);
    }


}
