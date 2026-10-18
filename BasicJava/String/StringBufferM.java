
public class StringBufferM {
    public static void main(String[] args){
            StringBuffer sb=new StringBuffer();
            sb.append("12345678912345678");
            System.out.println(sb.capacity());

            //  StringBuilder or StringBuffer to String

            StringBuilder str=new StringBuilder("sameer");
            String str1=str.toString();

            // not possible from StringBuffer to String.
        }
    }


