package manuscript.directing;

import manuscript.Movie;

/**  
 * Test.
 */  
public class InstalledMovieTest  {


    public static void main(String[] args) {
        Movie movie = new AnalogMovie();
        movie.start();
        movie.nextScene();
    }

   
}