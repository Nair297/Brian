//Minim Helper to load audio files

package tools;

import java.io.FileInputStream;
import java.io.InputStream;

public class Sound {

    public String sketchPath( String fileName ) {
        return "Audio/"+fileName;
    }

    public InputStream createInput(String fileName) {
        InputStream is = null;
        try{
            is = new FileInputStream(sketchPath(fileName));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return is;
    }
}