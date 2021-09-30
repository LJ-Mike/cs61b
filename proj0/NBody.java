import java.io.File;

public class NBody {

    final static String IMG_PATH = "images/";
    final static String BACKGROUND = "images/starfield.jpg";
    public static double readRadius(String file){
        In read = new In(file);
        int numberOfPlanets = read.readInt();

        return read.readDouble();
    }

    public static Body[] readBodies(String file) {
        In read = new In(file);

        int numberOfPlanets = read.readInt();

        Body[] ret = new Body[numberOfPlanets];

        double radious = read.readDouble();

        int count = 0;
        while (!read.isEmpty() && count < numberOfPlanets) {
            /** save current Body object in the array, and
            increment the count variable */
            ret[count++] = getBody(read);
        }

        return ret;
    }

    /** Get Body object at the current Line */
    public static Body getBody(In read) {
        double xxPos = read.readDouble();
        double yyPos = read.readDouble();
        double xxvel = read.readDouble();
        double yyVel = read.readDouble();
        double mass = read.readDouble();
        String img = IMG_PATH + read.readString();

        return new Body(xxPos, yyPos, xxvel, yyVel, mass, img);
    }

    /** Main method */
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        double T = Double.parseDouble(args[0]);
        
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];

        double universalRadious = readRadius(filename);

        Body[] bodies = readBodies(filename);

        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-1 * universalRadious, universalRadious);

        double time = 0.0;

        double[] l = StdAudio.read("audio/2001.mid");
        StdAudio.play(l);

        while (time <= T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            AnimateAllBodies(bodies, xForces, yForces);
            updateAllBodies(bodies, xForces, yForces, dt);

            StdDraw.clear();

            StdDraw.picture(0.0, 0.0, BACKGROUND);
            drawAllBodies(bodies);
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
            if (time > T) {
                printNewPosition(bodies, universalRadious);
            }
        }
    }

    /** Calculate forceExertedBy all other bodies in every bodies */
    public static void AnimateAllBodies(Body[] bodies, double[] xForces, double[] yForces) {
        int count = 0;
        for (Body b : bodies) {
            xForces[count] = b.calcNetForceExertedByX(bodies);
            yForces[count] = b.calcNetForceExertedByY(bodies);
            count += 1;
        }
    }

    /** Calculate, update all bodies */
    public static void updateAllBodies(Body[] bodies, double[] xForces, double[] yForces, double time) {
        int count = 0;
        for (Body b : bodies) {
            b.update(time, xForces[count], yForces[count]);
            count += 1;
        }
    }

    /** Draw all bodies */
    public static void drawAllBodies(Body[] bodies) {
        for (Body b : bodies) {
            b.draw();
        }
    }

    public static void printNewPosition(Body[] bodies, double radious) {
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radious);
        for (Body b : bodies) {
            StdOut.printf("%11.4e  %11.4e  %11.4e  %11.4e  %11.4e  %12s\n",
                         b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
        }
    }
}
