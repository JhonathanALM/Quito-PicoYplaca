/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.espe.Test;

import edu.ec.espe.Main.Predict;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JhonathanW10
 */
public class PredictTest {
    
    @Test
    public void testCalculateDate1() {
        System.out.println("Plate in 'Pico y Placa' Day");
        String plate = "PLC-120";
        String date = "2019-05-31";
        String time = "15:00";
        Predict instance = new Predict();
        String expResult = "Allowed";
        String result = instance.calculateDate(plate, date, time);
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculateDate2() {
        System.out.println("Plate in 'Pico y Placa' Day");
        String plate = "PLC-120";
        String date = "2019-05-31";
        String time = "19:00";
        Predict instance = new Predict();
        String expResult = "Not Allowed";
        String result = instance.calculateDate(plate, date, time);
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("The test case is a prototype.");
    }
    @Test
    public void testCalculateDate3() {
        System.out.println("Plate not in 'Pico y Placa' Day");
        String plate = "PLC-120";
        String date = "2019-05-30";
        String time = "19:00";
        Predict instance = new Predict();
        String expResult = "Allowed";
        String result = instance.calculateDate(plate, date, time);
        assertEquals(expResult, result);
        if(!result.equals(expResult))
            fail("The test case is a prototype.");
    }
}
