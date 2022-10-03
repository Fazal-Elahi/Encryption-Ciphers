public class CaesarCipher extends RotationCipher{

  protected int shiftKey;
  public CaesarCipher(int key){
    super(key);
  }

  public String encrypt(String plainText){
    return plainText;
  }
  public String decrypt(String cipherText){
    return cipherText;
  }

  protected String rotate(int shift, String text){
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] capitalAphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int textLength = text.length();
    String encrptText = "";

    // Minus one since the method doens't use 0
    for (int letter = 0;letter <= textLength-1;letter++) {
      char singleLetter = text.charAt(letter);
      if (Character.isLetter(singleLetter) == true) {
        if (Character.isUpperCase(singleLetter) == true) {
          // Loop through alphabet
          for (int match = 0;match <= 25;match++) {
            // Find singleLetter in my alphabet Array
            if (singleLetter == capitalAphabet[match]) {
              if (match + shift > 25) {
                int wraparoundValue = (singleLetter - 'A' - (26 - shift));
                System.out.println("Wrap Around Value: " + wraparoundValue);
                match = wraparoundValue;
                encrptText = encrptText + capitalAphabet[match];
                break;
              }
              else {
                encrptText = encrptText + capitalAphabet[match+shift];
              }
            }
          }
        }
        else {
          for (int match = 0;match <= 25;match++) {
            // Find singleLetter in my alphabet Array
            if (singleLetter == alphabet[match]) {
              if (match + shift > 25) {
                int wraparoundValue = (singleLetter - 'a' - (26 - shift));
                System.out.println("Wrap Around Value: " + wraparoundValue);
                match = wraparoundValue;
                encrptText = encrptText + alphabet[match];
                break;
              }
              else {
                encrptText = encrptText + alphabet[match+shift];
              }
            }
          }
        }
      }
      else {
        // Ignoreing Everthing that isn't a letter.
        encrptText = encrptText + singleLetter;
      }
    }
    return encrptText;
  }
  // // Testing Console
  // public static void main(String[] args) {
  //   CaesarCipher Caesar = new CaesarCipher(2);
  //   String ReturnValue = Caesar.rotate(2,"Aa");
  //   System.out.println(ReturnValue);
  // }
}
