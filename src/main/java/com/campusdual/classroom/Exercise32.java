package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Exercise32 {

    public static void main(String[] args) throws FileNotFoundException {
        String textoPrueba = generateStringToSave(null);
        printToFile(textoPrueba);


    }



    public static String generateStringToSave(String string) {
        if (string!=null){
            return string;
        }else{
            return generateUserInputToSave();
        }

    }

    private static String generateUserInputToSave(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el texto a guardar: ");
        return scanner.nextLine();
    }

    public static void printToFile(String string) {
            //DEFINICION: RUTA DE ARCHIVO
        Path filePath = Paths.get("src/main/resources/data.txt");
        File file = filePath.toFile();

        //VERIFICACION--> existe la carpeta resources?
        File parentDirectory= file.getParentFile();

        if (!parentDirectory.exists()){
            parentDirectory.mkdirs();
        }
            //BUFFEREDWRITER--> ESCRIBIR CONTENIDO EN LA CADENA DEL ARCHIVO
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile())))
            {
                writer.write(string); //ESCRIBE TODA LA CADENA SIN MODIFICAR LOS SALTOS DE LINEA
        } catch (IOException e){
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }


}
