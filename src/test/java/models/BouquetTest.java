package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BouquetTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Bouquet newArrangement() {
        return new Bouquet("rose", "lily", "daisy", "gerbera");
    }

    public Bouquet newArrangement2() {
        return new Bouquet("sunflower", "dandelion", "poppy", "thistle");
    }

    @Test
    public void instantiatesCorrectly() throws Exception {
        Bouquet newFlower = newArrangement();
        assertEquals(true, newFlower instanceof Bouquet);
    }

    @Test
    public void countsBouquetInstancesCorrectly() throws Exception {
        Bouquet.clearAllFlowers();
        Bouquet newFlower = newArrangement();
        Bouquet newFlower2 = newArrangement2();
        assertEquals(2, Bouquet.getAllFlowers().size());
    }
}