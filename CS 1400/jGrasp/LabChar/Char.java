public class Char
{
   public static void main(String[] args)
   {
      char dash = '-';
      System.out.printf("Dash:%c\n", dash);
      
      char a = 'a';
      char letter = a;
      char b = ++letter;
      char c = ++ letter;
      letter += 2;
      char e = letter;
      
      System.out.printf("Letter: %c, a: %c b: %c c: %c e: %c\n", 
         letter, a, b, c, e);
         
      char copyrightSign = '\u00a9'; // or 169;
      System.out.printf("Copyright sign: %c %d %X\n", copyrightSign, 
         (int)copyrightSign, (int)copyrightSign);
         
      char yen ='\u00a5'; // look up the binary code;
      System.out.printf("Yen: %c %d %X\n", yen, (int)yen, (int)yen);
   }
}