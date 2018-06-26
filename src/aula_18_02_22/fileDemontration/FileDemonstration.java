package aula_18_02_22.fileDemontration;

// Fig. 14.4: FileDemonstration.java
// Demonstrating the File class.
import java.io.File;
import java.util.Date;

public class FileDemonstration {
    // display information about file user specifies

    public void analyzePath(String path) {
        // create File object based on user input
        File name = new File(path);
        long soma = 0, t;
        int countf = 0;
        int countd = 0;

        if (name.exists()) // if name exists, output information about it
        {
            // display file (or directory) information
            System.out.printf(
                    "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
                    name.getName(), " exists",
                    (name.isFile() ? "is a file" : "is not a file"),
                    (name.isDirectory() ? "is a directory" : "is not a directory"),
                    (name.isAbsolute() ? "is absolute path" : "is not absolute path"),
                    "Last modified: ", new Date(name.lastModified()),
                    "Length: ", name.length(),
                    "Path: ", name.getPath(),
                    "Absolute path: ", name.getAbsolutePath(),
                    "Parent: ", name.getParent(),
                    "Total size: ", name.getTotalSpace());

            if (name.isDirectory()) // output directory listing
            {
                String directory[] = name.list();
                System.out.println("\n\nDirectory contents:\n");
                for (String directoryName : directory) {
                    File cont = new File(name, directoryName);
                    System.out.printf("%s -%s\n", directoryName, cont.isFile());
                    if (cont.isFile() == true) {
                        t = cont.length();
                        soma = soma + t;
                        System.out.printf("Tamanho Arquivo: %s\n", t);
                        countf++;
                    } else if (cont.isDirectory() == true) {
                        System.out.println("Pasta: "+ directoryName);
                    }
                } // end else
                System.out.println("\nNumero de arquivos: " + countf);
                System.out.printf("Tamanho Total: %s\n", soma);

            } // end outer if
            else // not file or directory, output error message
            {
                System.out.printf("\n%s %s\n", path, "does not exist.");
            } // end else
        } // end method analyzePath
    } // end class FileDemonstration
}
/**
 * ***********************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
************************************************************************
 */
