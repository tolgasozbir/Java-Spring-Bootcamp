public class StringMethods {
    public static void main(String[] args) {
        String message="Today was a good day.";
        System.out.println(message);

        System.out.println("Length : "+message.length());
        System.out.println("first letter : "+message.charAt(0));
        System.out.println(message.concat(" -Ice Cube.")); //concatenation (birleştirme)
        System.out.println(message.startsWith("t"));    //False because java case sensitive
        System.out.println(message.endsWith("."));      //True

        char[] chars = new char[5];
        message.getChars(0,5,chars,0);
        System.out.println(chars);

        System.out.println(message.indexOf('a'));
        System.out.println(message.indexOf("was"));
        System.out.println(message.lastIndexOf('.'));
        
        System.out.println(message.replace(' ','-'));
        System.out.println(message.substring(2));
        System.out.println(message.substring(2,5));
        System.out.println(message.trim());

        System.out.println("-------------");
        for (String letter:message.split(" ")) {
            System.out.println(letter);
        }

        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
    }
}
