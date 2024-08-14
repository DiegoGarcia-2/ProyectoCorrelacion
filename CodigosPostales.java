package mx.unison;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodigosPostales {
    public static void main(String[] args) {
        String archivoCsv = "codigos_postales.csv";
        int contadorUrbano = 0;
        int contadorRural = 0;

        try {
            FileReader archivoF = new FileReader(archivoCsv);
            BufferedReader archivoL = new BufferedReader(archivoF);

            String registro;
            while ((registro = archivoL.readLine()) != null) {
                String[] campos = registro.split(",");

                String tipoAsentamiento = campos[2];

                if (tipoAsentamiento.equalsIgnoreCase("Urbano")) {
                    contadorUrbano++;
                } else if (tipoAsentamiento.equalsIgnoreCase("Rural")) {
                    contadorRural++;
                }
            }

            archivoL.close();
            archivoF.close();

            System.out.println("Asentamientos urbanos: " + contadorUrbano);
            System.out.println("Asentamientos rurales: " + contadorRural);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
