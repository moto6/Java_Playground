package chp500_json_paser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class JsonToDocPasser {


    static final private String DELIMITER = "##";


    public static void main(String[] args) {

        //initialize
        Scanner scanner = new Scanner(System.in);

        // 프롬프트 : 도움말, 시작 ##
        passerShell(scanner);

        //데이터 입력받고
        String jsonString = insertData(scanner);
        //System.out.println("RET : " +jsonString);



        //입력/ 출력 구분 출력


        //여기가 그부분
        Converting(jsonString);



        //finalize
    }

    private static void Converting(String json1) {
        String json = json1.strip();
        json = json.replaceAll("\t","");
        json = json.replaceAll("\"","");

        Stack<String> prefix = new Stack<>();
        String[] tokens = json.split(",");
        for(int i=0; i<tokens.length ; i++) {

            if(tokens[i].contains("{")) {
                prefix.push(tokens[i]);
            }

            if(tokens[i].contains("}")) {
                prefix.pop();
            }
            System.out.printf("fieldWithPath(\"%s\").description(\"\"),\n",keyRefiner(tokens[i]));
            //System.out.printf("fieldWithPath(\"%s%s\").description(\"\"),\n",prefixToString(prefix),keyRefiner(tokens[i]));

        }
    }

    private static String prefixToString(Stack<String> prefix) {
        StringBuilder builder = new StringBuilder();
        List<String> prefixList = new ArrayList<>(prefix);
        for(int i=1 ; i<prefixList.size() ; i++) {
            builder.append(prefixList.get(i));
            builder.append(".");
        }
        // String retString = builder.toString();
        return builder.toString();
        //return retString.substring(0, retString.length() - 2);
    }

    private static String keyRefiner(String token) {
        token = token.replaceAll(" ","");
        token = token.replaceAll("\"","");
        //token = token.replaceAll("", "");

        char[] tokenArr = token.toCharArray();
        StringBuilder builder = new StringBuilder();

        int count = 0;
        for(int i=0 ; i<tokenArr.length ; i++) {
            if(tokenArr[i] == ':') {
                break;
            }
            builder.append(tokenArr[i]);
        }

        return builder.toString();
    }

    private static void passerShell(Scanner scanner) {
        final String WELCOME_MSG = "Json data >>To>> JAVA-RESTDocs code Passing&&Converter \n"+
                "command : <h>=Help ,  <##>=activate ,  <q>=exit \n\n";
        final String PROMPT = "passer > ";

        while (true) {
            System.out.print(WELCOME_MSG);
            System.out.print(PROMPT);
            String buffer = scanner.nextLine();

            if( buffer.equals("q")) {
                System.exit(0);
            }

            if(buffer.equals("h")) {
                continue;
            }

            if(buffer.equals("##")) {
                break;
            }
        }
    }

    private static String insertData(Scanner scanner) {
        StringBuilder builder = new StringBuilder();
        String buffer;
        while (true) {

            buffer = scanner.nextLine();
            if(buffer.contains(DELIMITER)) {
                break;
            }
            else {
                builder.append(buffer);
            }
        }

        return builder.toString();
    }

}


//개같은거 계속 버그나는데 이거 좀 갈아엎어야함
//원인 : 벨류속에 , 문자가 있으면 , 문자 기준으로 파싱하는데 문제가 생김
// 해결책 : 키벨류 기준으로  >> 일단 토크나이져 부터 완성해야함

// 샘플데이터
