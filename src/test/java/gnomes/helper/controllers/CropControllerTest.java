package gnomes.helper.controllers;

import org.junit.Test;

import static org.junit.Assert.*;


public class CropControllerTest {

    @Test
    public void crops() {
        CropController cropController = new CropController();
        String result = cropController.crops();
        assertEquals(result, "crops");
    }
}