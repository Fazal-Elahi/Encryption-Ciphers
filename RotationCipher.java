public abstract class RotationCipher implements Cipher{
  // Get All Methods in Cipher class
  protected int shiftKey;
  public RotationCipher(int key){
    this.shiftKey = key;
  }
  public abstract String encrypt(String plainText);
  public abstract String decrypt(String cipherText);
  protected abstract String rotate(int shift, String text);
}
