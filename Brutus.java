import java.util.Scanner;

public class Brutus implements Cipher{
  public Brutus(){}

  // English Freq
  double[] english = { 0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218,0.0209, 0.0496, 0.0733, 0.0022, 0.0081, 0.0421,0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
                     0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019,
                     0.0172, 0.0011 };

  // Implement all Cipher Methods
  public String encrypt(String plainText){
    return plainText;
  }
  // Suppose to Decrypt Tho, I can't figure it.
  public String decrypt(String cipherText){
    // Get's a Double for
    // double[] freq = computeFrequencies(cipherText);
    // double chiValue = chiSquared(english,freq);
    // return cipherText;
  }

  private double[] computeFrequencies(String text){
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] capitalAphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    double[] letterFreq = new double[25];

    // Run for the Text Length and check for letters.
    for (int a = 0;a < text.length();a++) {
      char singleLetter = text.charAt(a);
      for (int b = 0;b < 25;b++) {
        if (singleLetter == alphabet[b] || singleLetter == capitalAphabet[b]) {
          letterFreq[b] = letterFreq[b] + 1.0;
        }
      }
    }
    // Divide them by the length of the text
    for (int z = 0;z < 25;z++) {
      if (letterFreq[z] > 0.0) {
        letterFreq[z] = letterFreq[z]/text.length();
      }
    }
    return letterFreq;
  }

  public double chiSquared(double[] freqsA, double[] freqsB){
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] capitalAphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    // Calculate Chi-Square Value
    String encrptText = "";
    double chiPoint = 0.0;
    // double chiShift = 0.0;
    for (int i =0;i < 25;i++) {
      if (freqsB[i] > 0.0) {
        double chiSquared = (((freqsB[i]- freqsA[i])*2)/freqsA[i]);
        chiPoint += chiSquared;
      }
    }
    // Return Shift Point
    return chiPoint;
  }

  public String Reconstruct(int shift, String text){
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] capitalAphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int textLength = text.length();
    String reconstructText = "";
    // Second Loop - Break Downlad Input String into Character
      // Loop for the Text Length
    // Third Loop - Compare and Reconstruct with the revelent shift
    for (int firstLoop =0;firstLoop < textLength;firstLoop++) {
      char singleLetter = text.charAt(firstLoop);
      // System.out.println("Single Letter: " + singleLetter);
      for (int secondLoop=0;secondLoop <= 25;secondLoop++) {
        // System.out.println("secondLoop: " + secondLoop);
        if (Character.isLetter(singleLetter) == true && Character.isUpperCase(singleLetter)){
          if (singleLetter == capitalAphabet[secondLoop]) {
            int difference = (singleLetter - 'Z' + (26 + shift));
            int wraparoundValue = difference-26;
            System.out.println("Wrap Around Value: " + wraparoundValue);
            System.out.println("capitalAphabet[wraparoundValue]: " + capitalAphabet[wraparoundValue]);
            reconstructText += capitalAphabet[wraparoundValue];
          }
        }
        else if (Character.isLetter(singleLetter) == true && Character.isLowerCase(singleLetter)) {
          if (singleLetter == capitalAphabet[secondLoop]) {
            int difference = (singleLetter - 'z' + (26 + shift));
            int wraparoundValue = difference-26;
            System.out.println("Wrap Around Value: " + wraparoundValue);
            System.out.println("capitalAphabet[wraparoundValue]: " + capitalAphabet[wraparoundValue]);
            reconstructText += capitalAphabet[wraparoundValue];
          }
        }
        else {
          reconstructText += singleLetter;
        }
      }
    }
    return reconstructText;
  }

  public static void main(String[] args) {
    // Main Method to Run the Application
    Brutus Brutus = new Brutus();
    Scanner myObj = new Scanner(System.in);
    String decryptText = myObj.nextLine();
    System.out.println(Brutus.decrypt(decryptText));
  }
}
