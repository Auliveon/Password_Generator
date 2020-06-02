import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password_Generator {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        String password = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество символов(мин 8 символов):");
        int len;
        while(true) {
            try {
                len = Integer.parseInt(reader.readLine());
                if(len < 8) throw new NullPointerException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введены неверные данные");
            } catch (NullPointerException e) {
                System.out.println("Минимум 8 символов");
            }
        }
        boolean chisla = false;
        boolean tlc = false;
        boolean bykvi = false;
        for(int i = 0; i < len; i++) {
            String b = "";
            int rndtlc = (int)(0 + Math.random() * 2);
            int rnd = (int)(0 + Math.random() * 2);
            if(!chisla && i == 4) rnd = 1;
            if(!bykvi && i == 5) {
                rndtlc = 0;
                rnd = 0;
            }
            if(!tlc && i == 6) {
                rnd = 0;
                rndtlc = 1;
            }
            if(rnd == 1){
                b = String.valueOf((char)(48 + Math.random() * 10));
                password = password + b;
                chisla = true;
            }
            if(rnd == 0){
                b = String.valueOf((char)(65 + Math.random() * 26));
                bykvi = true;
                if(rndtlc == 1){
                    b = b.toLowerCase();
                    tlc = true;
                    bykvi = false;
                }

                password = password + b;
            }
        }
        ByteArrayOutputStream qq = new ByteArrayOutputStream();
        qq.write(password.getBytes());
        return qq;
    }
}
