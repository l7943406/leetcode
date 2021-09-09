package P68文本左右对齐;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();

        Queue<String> queue = new LinkedList<>();
        int length = words[0].length();
        queue.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if(length + word.length() + 1 > maxWidth){
                ans.add(solve(queue, maxWidth, length));
                queue.clear();
                length = word.length();
                queue.add(word);
                continue;
            }
            length += word.length() + 1;
            queue.add(word);
        }
        if(!queue.isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append(queue.poll());
            while (!queue.isEmpty()){
                sb.append(' ').append(queue.poll());
            }
            while (sb.length() < maxWidth){
                sb.append(' ');
            }

            ans.add(sb.toString());
        }

        return ans;
    }
    private String solve(Queue<String> queue, int maxWidth, int length){
        if(queue.size() == 1){
            StringBuilder sb = new StringBuilder();
            sb.append(queue.poll());
            while (!queue.isEmpty()){
                sb.append(' ').append(queue.poll());
            }
            while (sb.length() < maxWidth){
                sb.append(' ');
            }

            return sb.toString();

        }

        StringBuilder s = new StringBuilder();
        int realLength = length - queue.size() + 1;
        int wordSize = queue.size();
        int spaceSize = maxWidth - realLength;
        int space = spaceSize / (wordSize - 1);
        int otherSpace = spaceSize % (wordSize - 1);
        s.append(queue.poll());


        for (int i = 0; i < otherSpace; i++) {
            for (int j = 0; j < space + 1; j++) {
                s.append(' ');
            }
            s.append(queue.poll());
        }

        while (!queue.isEmpty()){
            for (int i = 0; i < space; i++) {
                s.append(' ');
            }
            s.append(queue.poll());
        }

        return s.toString();
    }

}

/*
给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于maxWidth。
输入单词数组 words至少包含一个单词。
 */