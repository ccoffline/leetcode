package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1125 {

    public static void main(String[] args) {
        Solution1125 solution = new Solution1125();
        String[][] req_skills = {
                {"java", "nodejs", "reactjs"},
                {"algorithms", "math", "java", "reactjs", "csharp", "aws"}
        };
        String[][][] peoples = {
                {{"java"}, {"nodejs"}, {"nodejs", "reactjs"}},
                {{"algorithms", "math", "java"}, {"algorithms", "math", "reactjs"}, {"java", "csharp", "aws"}, {"reactjs", "csharp"}, {"csharp", "math"}, {"aws", "java"}}
        };
        for (int i = 0; i < req_skills.length; i++) {
            String[][] people = peoples[i];
            List<List<String>> input = new ArrayList<>(people.length);
            for (String[] skills : people) input.add(Arrays.asList(skills));
            System.out.println(Arrays.toString(solution.smallestSufficientTeam(req_skills[i], input)));
        }
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        final int reqs = req_skills.length;
        final int full = 1 << reqs;

        int[][] teams = new int[full][reqs + 1];
        // 0个技能所需要的团队数量为0，其他设为负数，标记为dp未赋值
        for (int i = 0; i < full; i++)
            teams[i][0] = -i;
        for (int i = 0; i < people.size(); i++) {
            int skills = 0;
            List<String> person = people.get(i);
            for (int j = 0; j < reqs; j++)
                if (person.contains(req_skills[j]))
                    skills |= 1 << j;
            for (int j = 0; j < full; j++) {
                int[] team = teams[j];
                if (team[0] < 0) continue;
                int x = j | skills;
                if (teams[x][0] < 0 || teams[x][0] > team[0] + 1) {
                    System.arraycopy(team, 0, teams[x], 0, reqs + 1);
                    teams[x][++teams[x][0]] = i;
                }
            }
        }
        return Arrays.copyOfRange(teams[full - 1], 1, teams[full - 1][0] + 1);
    }
}