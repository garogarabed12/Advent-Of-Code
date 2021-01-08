package aoc2020.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionsCounter {

    private final List<String> data;
    private long yesAnswersCounter = 0;

    public QuestionsCounter() {
        data = new ArrayList<>();
    }

    public void countTheNumberOfWithYesAnsweredQuestionsV1() {
        List<Character> answeredQuestions = new ArrayList<>();
        int numberOfWithYesAnsweredQuestionsPerGroup = 0;

        for (String line : data) {
            for (int i = 0; i < line.length(); i++) {
                if (!answeredQuestions.contains(line.charAt(i))) {
                    answeredQuestions.add(line.charAt(i));
                    numberOfWithYesAnsweredQuestionsPerGroup++;
                }
            }
        }

        yesAnswersCounter += numberOfWithYesAnsweredQuestionsPerGroup;
        data.clear();
    }

    public void countTheNumberOfWithYesAnsweredQuestionsV2() {
        int numberOfPeopleWhoAnswered = data.size();

        List<Character> answeredQuestions = new ArrayList<>();
        int numberOfWithYesAnsweredQuestionsPerGroup = 0;

        for (String line : data) {
            for (int i = 0; i < line.length(); i++) {
                answeredQuestions.add(line.charAt(i));
            }
        }

        List<Character> distinctAnswers = answeredQuestions.stream().distinct().collect(Collectors.toList());
        Map<Character, Long> frequenciesMap = answeredQuestions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Character distinctAnswer : distinctAnswers) {
            if (frequenciesMap.get(distinctAnswer) == numberOfPeopleWhoAnswered) {
                numberOfWithYesAnsweredQuestionsPerGroup++;
            }
        }

        yesAnswersCounter += numberOfWithYesAnsweredQuestionsPerGroup;
        data.clear();
    }

    public void addData(String line) {
        data.add(line);
    }

    public void calculateV1(List<String> lines) {
        yesAnswersCounter = 0;
        for (String line : lines) {
            if (!line.equals("")) {
                addData(line);
            } else countTheNumberOfWithYesAnsweredQuestionsV1();
        }
        //One last time to consider the last group.
        countTheNumberOfWithYesAnsweredQuestionsV1();
    }

    public void calculateV2(List<String> lines) {
        yesAnswersCounter = 0;
        for (String line : lines) {
            if (!line.equals("")) {
                addData(line);
            } else countTheNumberOfWithYesAnsweredQuestionsV2();
        }
        //One last time to consider the last group.
        countTheNumberOfWithYesAnsweredQuestionsV2();
    }

    public long getYesAnswersCounter() {
        return yesAnswersCounter;
    }
}
