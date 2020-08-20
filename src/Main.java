import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.parseDouble;

/**
 * Assignment 4 E5.9
 * @author Sergei Chekhonin
 * This program converts angle to direction
 */

public class Main {

    public static void main(String[] args) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("Assignment4_E5.9output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String input = JOptionPane.showInputDialog("Enter angle away from North:");
        /**
         * stores input angle that needle away from North (Clockwise)
         */
        double angle = parseDouble(input);



        /**
         * stores name of Direction
         */
        String direction = computeDiretion(angle);

        out.println(dtf.format(now));
        out.printf("Angle away from North is:  %.2f\n", angle);
        out.printf("Nearest compass direction is:  " + direction);

        out.close();
    }

    /***
     *
     * @param angle input angle of needle away from North
     * @return Direction in string format
     */
    public static String computeDiretion(double angle)
    {
        double _angle = angle;
        String direction = "";
        if (_angle > 360)
            _angle=_angle%360;
        if (_angle>=337.5 || _angle<=22.5)
            direction = "N";
        else if (_angle>22.5 && _angle<67.5)
            direction = "NE";
        else if (_angle>=67.5 && _angle<=112.5)
            direction = "E";
        else if (_angle>112.5 && _angle<157.5)
            direction = "SE";
        else if (_angle>=157.5 && _angle<=202.5)
            direction = "S";
        else if (_angle>202.5 && _angle<247.5)
            direction = "SW";
        else if (_angle>=247.5 && _angle<=292.5)
            direction = "W";
        else if (_angle>292.5 && _angle<337.5)
            direction = "NW";

        return direction;

    }
}
