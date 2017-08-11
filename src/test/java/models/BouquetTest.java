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

    public Bouquet newArrangement(){
        return new Bouquet("rose", "lily", "daisy", "gerbera");
    }

    @Test
    public void instantiatesCorrectly() throws Exception {
        Bouquet newFlower = newArrangement();
        assertEquals(false, newFlower instanceof Bouquet);
    }

}