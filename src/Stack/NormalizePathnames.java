package Stack;

import java.util.*;

public class NormalizePathnames {
    /**
     * It's natural to process the String from left to right, splitting on forward slash.
     * we record directory and file names. Each time we encounter a .. we delete the most recent name, which corresponds
     * to going up directory hierarchy
     * if the String begins with /, we cannot go up grom it
     * may beginwith .., which indicate a path that begins with an ancestor of the current working path
     * @param path
     * @return
     */
    public static String shortestEquivalentPath(String path) {
        if(path.equals("")) {
            throw new IllegalArgumentException("Empty String is not a legal path");
        }

        Stack<String> pathNames = new Stack<>();
        //special case: start with /
        if(path.startsWith("/")) {
            pathNames.push("/");
        }

        for(String token : path.split("/")) {
            if(token.equals("..")) {
                if(pathNames.isEmpty() || pathNames.peek().equals("..")) {
                    pathNames.push(token);
                }else {
                    if(pathNames.peek().equals("/")) {
                        throw new IllegalArgumentException("Path error, trying to go up root" + path);
                    }
                    pathNames.pop();
                }
            }else if(!token.equals(".") && !token.isEmpty()) {
                pathNames.push(token);
            }
        }

        StringBuilder result = new StringBuilder();
        if(!pathNames.isEmpty()) {
            Iterator<String> it = pathNames.iterator();
            String prev = it.next();
            result.append(prev);
            while(it.hasNext()) {
                if(!prev.equals("/")) {
                    result.append("/");
                }
                prev = it.next();
                result.append(prev);
            }
        }
        return result.toString();
    }

    public static String simplifyPath(String path) {
        Set<String> isSkip = new HashSet<>(Arrays.asList("", ".", ".."));
        Deque<String> stack = new ArrayDeque<>();
        for (String token : path.split("/")) {
            if (token.equals("..") && !stack.isEmpty()) stack.pop();
            if (isSkip.contains(token)) continue;
            stack.push(token);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String args[]) {
        String s = "../a/../../b/../c//.//";
        String[] b = s.split("/");
        for(String a : b) {
            System.out.println(a);
        }
        String res = simplifyPath(s);
        System.out.println(res);
    }
}
