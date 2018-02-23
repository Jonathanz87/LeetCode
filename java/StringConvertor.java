import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringConvertor {
    public static void main(String[] args) {
        String s;
        System.out.println(s = convert(Arrays.asList("\\","\",\"","'\\we")));
        convert(s).forEach(System.out::println);
    }

    public static String convert(List<String> strList) {
        if(strList == null){
            throw new RuntimeException();
        }
        StringBuilder builder = new StringBuilder();

        for (String s : strList) {
            builder.append('"');
            for (char c : s.toCharArray()) {
                if (c == '"') {
                    builder.append('\\').append('"');
                } else if (c == '\\') {
                    builder.append('\\').append('\\');
                } else {
                    builder.append(c);
                }

            }
            builder.append('"').append(',');
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    public static List<String> convert(String str) {
        if(str == null){
            throw new RuntimeException();
        }
        List<String> result = new LinkedList<>();
        String[] strArr = str.substring(1, str.length() - 1).split("\",\"");
        for(String s : strArr){
            result.add(s.replace("\\\"", "\"").replace("\\\\", "\\"));
        }

        return result;
    }
}
