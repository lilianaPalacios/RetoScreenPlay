package com.demoqa.automation.interactions;

import com.demoqa.automation.ui.PracticeFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;



public class OpenFile implements Interaction {

    private String carpeta;
    private String archivo;
    private Robot robot;
    private File tempFile;

    public OpenFile(String carpeta, String archivo) {

        this.carpeta = carpeta;
        this.archivo = archivo;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        carpeta =  carpeta +"\\" ;
        File ruta = new File (carpeta);
        tempFile = new File (ruta +"\\"+ archivo );
        ruta.mkdirs();
        try {
            tempFile.createNewFile();
        }catch (IOException ex){
            System.out.println("error: " + ex);
        }
        actor.attemptsTo(JavaScriptClick.on(PracticeFormPage.imagenBtn));//clic(imagenBtn);


        try {
            BuscarImagen(carpeta +archivo);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        tempFile.deleteOnExit();
    }

    public void BuscarImagen(String ruta) throws AWTException {

        try {
            StringSelection selection = new StringSelection(ruta);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);

            robot = new Robot();
            robot.delay(7000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public static OpenFile OpF (String carpeta, String archivo){
        return new OpenFile(carpeta,archivo);
    }

}
