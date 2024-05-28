package com.theisland.utils;

import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import com.theisland.misc.EnhancedLog;

public class FileManager {


    /**
     * Return the URL of a partial Path given for a local resource of the current Java project. It sould NOT start with a "/" or "\".
     * The path should be a reference to a file having the folder "./src/main/resources" as root
     * @param partialPath the partial path that should be a reference to a file having the folder "./src/main/resources" as root
     * @return
     */
    public URL getURLOfLocalRes(String partialPath) {
        return getClass().getClassLoader().getResource(partialPath);
    }

    /**
     * Search for a file if it exists by using a {@code filePath}.
     * @param filePath the file path with the name of the file to get
     * @return the obtained {@code File}, or {@code null} if it doesn't exist
     */

    public File getFile(String filePath) {
        
        File file = new File(filePath);
        
        if (file.exists()) {
            EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" existe !", "INFO");
            return file;
        }
        
        EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" n'existe pas !", "ERROR !");

        return null;
    }


    /**
     * Search for a file if it exists by using an {@code URL} referring to a file stored in the local "resources" folder.
     * @param url the URL with the name of the file to get
     * @return the obtained {@code File}, or {@code null} if it doesn't exist
     */

     public File getFileFromLocalRes(URL url) {
        
        File file = null;

        try {
            file = Paths.get(url.toURI()).toFile();
        } catch (URISyntaxException e) {
            EnhancedLog.eventLogger("Erreur lors de la conversion de l'URL !", "ERROR !");
            e.printStackTrace();
            return null;
        }
        
        if (file.exists()) {
            // EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" existe !", "INFO");
            return file;
        }
        
        EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" n'existe pas !", "ERROR !");

        return null;
    }

    /**
     * Search for a file if it exists by using a {@code filePath} or create the file mentionned in the {@code filePath} if it doesn't exist. 
     * @param filePath the file path with the name of the file to get or create if it doesn't exists
     * @return the obtained or created {@code File}, or {@code null} if something went wrong 
     */
    public File getOrCreateFile(String filePath) {
        File file = new File(filePath);
        
        if (file.exists()) {
            EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" existe !", "INFO");
            return file;
        }
       
        try {
            file.createNewFile();
            EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" a été créé avec succès !", "INFO");
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }

     /**
     * Search for a file if it exists by using a {@code filePath} or create the file mentionned in the {@code filePath} if it doesn't exist.
     * Can also create folders recursively if they don't exist 
     * @param partialFilePath the partial file path starting from the executable's path with the name of the file to get or create if it doesn't exists
     * @param getOrCreateInProgramPath the file is searched or created in the executable's current path
     * @return the obtained or created {@code File}, or {@code null} if something went wrong 
     */
    public File getOrCreateFileInProgramPath(String partialFilePath) {
        
        File file = new File("./" + partialFilePath);
        
        if (file.exists()) {
            EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" existe !", "INFO");
            return file;
        }
       
        try {

            // Create directories if they are needed
            if(partialFilePath.contains("/") ) {

                List<String> splittedDir = new ArrayList<>( Arrays.asList(partialFilePath.split("/")) );
                
                // Remove file name from string
                splittedDir.removeLast();
                
                String directoriesToCreate = String.join("/", splittedDir);
                
                Files.createDirectories(Paths.get(directoriesToCreate));
            }

            // Create the new file
            file.createNewFile();
            EnhancedLog.eventLogger("Le fichier \"" + file.getName() + "\" a été créé avec succès !", "INFO");
            return file;

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }


    /**
     * Add a new {@code data} (line) to a file, adding an EOL at the end of each line
     * @param file the {@code File} you want to write in
     * @param data the {@code String} you want to write in the file
     * @return {@code 1} if everything went well, {@code null} if there was an error.
     */
    public Integer appendNewLineToFile(File file, String data) {
        return appendNewLineToFile(file, data, true);
    }

    
    /**
     * Add a new {@code data} (line) to a file, adding an EOL at the end of each line (optionnal)
     * @param file the {@code File} you want to write in
     * @param data the {@code String} you want to write in the file
     * @param addEOL add a EOL (line ending) at the end of the srting if {@code true}. Doesn't do it if {@code false}
     * @return {@code 1} if everything went well, {@code null} if there was an error.
     */
    public Integer appendNewLineToFile(File file, String data, boolean addEOL) {

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) { // Permet de faire le "fileWriter.close();" automatiquement lorsque le "try" est terminé
            
            fileWriter.append(data);

            if (addEOL == true) {
                fileWriter.append(System.lineSeparator());
            }

            EnhancedLog.eventLogger("Ligne \"" + data + "\" ajoutée avec succès dans le fichier \"" + file.getName() + "\"", "INFO");
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return 1;
    }


    /**
     * Return every lines of a file as a {@code Stream<String>} 
     * @param url the URL with the name of the file to get
     * @return {@code Stream<String>} if the file exists, {@code null} if there was an error
     */
    public Stream<String> getFileLines(URL url) {
        
        Path path = null;

        try {
            path = Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            EnhancedLog.eventLogger("Erreur lors de la conversion de l'URL !", "ERROR !");
            e.printStackTrace();
            return null;
        }
        

        try {
            return Files.lines(path);
        } catch (IOException e) {
            EnhancedLog.eventLogger("Erreur lors de la conversion du fichier en Stream !", "ERROR !");
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Return every lines of a file as a {@code Stream<String>} located in the executable's current path
     * @param url the URL with the name of the file to get
     * @return {@code Stream<String>} if the file exists, {@code null} if there was an error
     */
    public Stream<String> getFileLinesFromProgramPath(String partialFilePath) {
        
        String filePathString = new File("./" + partialFilePath).getAbsolutePath();
        Path filePath = Paths.get(filePathString);        

        try {
            return Files.lines(filePath);
        } catch (IOException e) {
            EnhancedLog.eventLogger("Erreur lors de la conversion du fichier en Stream !", "ERROR !");
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Search for a {@code Image} if it exists by using an {@code URL} referring to a file stored in the local "resources" folder.
     * @param url the URL with the name of the file to get
     * @return the obtained {@code Image}, or {@code null} if it doesn't exist
     */
    public Image getImageFromLocalRes(URL url) {

        File file = getFileFromLocalRes(url);

        if(file == null) {
            EnhancedLog.eventLogger("Le fichier spécifié n'existe pas !", "ERROR !");
            return null;
        }

        try {
            // EnhancedLog.eventLogger("L'image \"" + file.getName() + "\" existe !", "INFO");
            return ImageIO.read(file);

        } catch (IOException ex) {
            EnhancedLog.eventLogger("Erreur lors de la conversion du fichier \"" + file.getName() + "\" en  image !", "ERROR !");
            ex.printStackTrace();   
        }

        return null;        
    }
}
