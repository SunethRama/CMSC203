import java.io.File;
import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) {
		
		//String workingDir = System.getProperty("user.dir");
        
        // Construct the file path relative to the working directory
        String filePath = "src/StudentTest1.txt";
        
        File file = new File(filePath);

		try {
			double[][] test = TwoDimRaggedArrayUtility.readFile(file);
			
			for (int i=0 ; i < test.length ; i++ ){
				for (int j=0 ; j < test[i].length ; j++) {
					System.out.print(test[i][j] + " ");
				}
				System.out.println();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
