import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Tokenizer {
    private BufferedReader reader;
    private List<String> tokens;
    private int cursor;
    private String line;
    private static Tokenizer instance;

    private static final String[] RESERVED_WORDS = {
        "program", "begin", "end", "int", "if", "then", "else", "while", "loop", "read", "write"
    };

    private static final String[] SPECIAL_SYMBOLS = {
        ";", ",", "=", "!", "[", "]", "&&", "||", "(", ")", "+", "-", "*", "!=", "==", "<", ">", "<=", ">="
    };

    public Tokenizer(String file) {
        file = "data/" + file;
        cursor = 0;
        tokens = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                tokenizeLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   

    private void tokenizeLine(String line) {
        int startIdx = 0;
        String token = "";
        for (int i = 0; i < line.length(); i++) {
            if (Character.isWhitespace(line.charAt(i))) {
                if (startIdx < i) {
                    token = line.substring(startIdx, i);
                    tokens.add(token);
                }
                startIdx = i + 1;
            } else if (!Character.isDigit(line.charAt(i)) && !Character.isLetter(line.charAt(i))) {
                if (startIdx < i) {
                    token = line.substring(startIdx, i);
                    tokens.add(token);
                }
                if (i < line.length() - 1) {
                    if (!Character.isDigit(line.charAt(i + 1)) && !Character.isLetter(line.charAt(i + 1))) {
                        token = line.substring(i, i + 2);
                        tokens.add(token);
                        i++;
                        startIdx = i + 1;
                    } else {
                        token = line.substring(i, i + 1);
                        tokens.add(token);
                        startIdx = i + 1;
                    }
                } else if (line.charAt(i) == ';') {
                    token = line.substring(i, i + 1);
                    tokens.add(token);
                    startIdx = i + 1;
                } else {
                    token = line.substring(i, i + 1);
                    tokens.add(token);
                    startIdx = i + 1;
                }
            } else if (i == line.length() - 1) {
                token = line.substring(startIdx, i + 1);
                tokens.add(token);
            }
        }
    }
         


    public int parseReserveWord(String token) {
        int tokenNum = 0;
        for (int i = 0; i < RESERVED_WORDS.length; i++) {
            boolean match = false;
            for (int j = 0; j < token.length(); j++) {
                if (token.charAt(j) == RESERVED_WORDS[i].charAt(j)) {
                    match = true;

                } else if (token.charAt(j) != RESERVED_WORDS[i].charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match == true) {
                tokenNum = i + 1;
                return tokenNum;
            }
        }
        return 34;
    }

    public int parseSpecialChar(String token) {
        int tokenNum = 0;
        for (int i = 0; i < SPECIAL_SYMBOLS.length; i++) {
            if (token.charAt(0) == SPECIAL_SYMBOLS[i].charAt(0)) {
                if (token.length() > 1) {
                    if (token.equals("==")) {
                        return 26;
                    } else if (token.equals("!=")) {
                        return 25;
                    } else if (token.equals("<=")) {
                        return 29;
                    } else if (token.equals(">=")) {
                        return 30;
                    } else if (token.equals("&&")) {
                        return 18;
                    } else if (token.equals("||")) {
                        return 19;
                    } else {
                        tokenNum = i + 12;
                        return tokenNum;
                }
            }else {
                tokenNum = i + 12;
                return tokenNum;
            }
        }
    }
        
    return 34;
    }

    public int parseIdentifier(String token) {
        int tokenNum = 0;
        boolean match = true;
        if (!Character.isUpperCase(token.charAt(0))) {
            match = false;
        } 
        if (token.length() > 1) {
            for (int i = 1; i < token.length(); i++) {
                if (!Character.isDigit(token.charAt(i)) && !Character.isUpperCase(token.charAt(i))) {
                    match = false;
                    break;
                }
            }
        }
        if (match == true) {
            tokenNum = 32;
            return tokenNum;
        }
        return 34;
    }

    public int parseInteger(String token) {
        int tokenNum = 0;
        boolean match = true;
        for (int i = 0; i < token.length(); i++) {
            if (!Character.isDigit(token.charAt(i))) {
                match = false;
                break;
            }
        }
        if (match == true) {
            tokenNum = 31;
            return tokenNum;
        }
        return 34;
    }


    public int getToken() {
        int tokenID = 34;
        if (cursor >= tokens.size()) {
            return 33;
        }
        if (0 <= cursor && cursor < tokens.size()) {
            String token = tokens.get(cursor);
            if (Character.isLowerCase(token.charAt(0))) {
                tokenID = parseReserveWord(token);
            } else if (Character.isUpperCase(token.charAt(0))) {
                tokenID = parseIdentifier(token);
            } else if (Character.isDigit(token.charAt(0))) {
                tokenID = parseInteger(token);
            } else if (!Character.isDigit(token.charAt(0)) && !Character.isLetter(token.charAt(0))) {
                tokenID = parseSpecialChar(token);
            } else if (token.equals(" ")) {
                cursor++;
            }
        }
        return tokenID;
    }

    public void skipToken() {
        cursor++;
    }

    public int intVal() {
        String token = tokens.get(cursor);
        if (parseInteger(token) == 31) {
            return Integer.parseInt(token);
        } else {
            System.out.println("Current token is not an integer");
            return 0;
        }
    }

    public String idName() {
        String token = tokens.get(cursor);
        if (parseIdentifier(token) == 32) {
            return token;
        } else {
            System.out.println("Current token is not an identifier");
            return "";
        }
    }

    public static void initialize(String file) {
        instance = new Tokenizer(file);
    }

    public static Tokenizer getTokenizer() {
        return instance;
    }
}
