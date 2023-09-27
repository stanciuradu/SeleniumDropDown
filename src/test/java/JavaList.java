import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class JavaList {
    // o lista ->echivalentul unui array, dar poate stoca mai multe tipuri de date sau obiecte

    public static void main(String[] args) {
        String[] vocale = {"a", "e", "i", "o", "u"};
/*        for (int i=0; i<vocale.length; i++){ //se parcuge array ul
            System.out.println(vocale[i]);
        }*/
        List<String> listaVocale = Arrays.asList(vocale);
        System.out.println(listaVocale);
    }
        /*
        6)
        Access : http://kevinlamping.com/webdriverio-course-content/index.html#
        Wait until the picture changes
        Verify that a different pictures is presented (and not the first)
        --> Tema
    */

}
