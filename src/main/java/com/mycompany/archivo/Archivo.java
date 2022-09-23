/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.archivo;

/**
 *
 * @author USUARIO
 */
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.IOException;
public class Archivo {

   	public static void main(String[] args) {
	int palabrastotales=0;

		File Objet =new File("D:"+File.separator+"CURSOS DE UNIVERSIDAD1"+File.separator+"mi primer archivo.txt");

		File Objeto =new File("D:"+File.separator+"CURSOS DE UNIVERSIDAD1");
		
		try { //permite definir un bloque de cÃ³digo para probar errores mientras se ejecuta.
			System.out.println(Objet.getAbsolutePath());//imprimir la ruta del directorio
			System.out.println(Objeto.exists());
	if(Objet.createNewFile()) {
		System.out.println("el archivo se creÃ³ correctamente");
	}
	else {
		System.out.println("el archivo ya existe");
	}
	FileWriter escribir=new FileWriter(Objet);
	escribir.write("Steve Jobs\nInformÃ¡tico y empresario estadounidense.\nPadre del primer ordenador personal y fundador de Apple Computer, ");
	escribir.close();
	Scanner leer=new Scanner(Objet);
	while(leer.hasNextLine()) { //La funciÃ³n hasNext() comprueba si existe otra lÃ­nea en un archivo
		String variable =leer.nextLine();//funciÃ³n nextLine() lee la lÃ­nea dada.
		System.out.println(variable);
		StringTokenizer st =new StringTokenizer(variable);
		palabrastotales=palabrastotales + st.countTokens();		
	}
	System.out.println("palabras totales: "+palabrastotales);
	leer.close();
	String[] nombre_archivos=Objeto.list();
	for(int i=0;i<nombre_archivos.length;i++) {
		System.out.println(nombre_archivos[i]);
		File f= new File(Objeto.getAbsolutePath(),nombre_archivos[i]);
		if(f.isDirectory()) {
			String[] subcarpetas=f.list();
			for(int j=0;j<subcarpetas.length;j++) {
				System.out.println(subcarpetas[j]);
			}
			
		}
		
	}
	/*File eliminar=new File("D:"+File.separator+"CURSOS DE UNIVERSIDAD1"+File.separator+"Steve Jobs.txt");
	if(eliminar.delete()) {
		System.out.println("el archivo /"+eliminar+"/ se eliminoo correctamente");
	}
	else {
		System.out.println("no pudo eliminarse");
	}*/
	
		}
		catch(IOException e) {
			System.out.println("excepcion al crear el archivo"+e);
			
		}
	}
}
