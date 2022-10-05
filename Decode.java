public class Decode{
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
            int wraparoundValue = (singleLetter - 'z' + (26 + shift));
            // int wraparoundValue = difference-26;
            // ciphertext[i] - 'A' + 26 - key)%26 + 'A';
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
    Decode test = new Decode();
    System.out.println(test.Reconstruct(2,"B"));
  }
