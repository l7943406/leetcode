package P1678设计Goal解析器;

class Solution {
    public String interpret(String command) {
        command = command.replace("()","o");
        command = command.replace("(al)","al");
        return command;
    }
}