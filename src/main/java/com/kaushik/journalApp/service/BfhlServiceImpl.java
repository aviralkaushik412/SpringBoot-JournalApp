package com.kaushik.journalApp.service;

import com.kaushik.journalApp.dto.BfhlRequestDto;
import com.kaushik.journalApp.dto.BfhlResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class BfhlServiceImpl implements BfhlService {
    private static final String FULL_NAME = "john_doe";
    private static final String EMAIL = "john@xyz.com";
    private static final String ROLL_NUMBER = "ABCD123";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+$");

    @Override
    public BfhlResponseDto process(BfhlRequestDto requestDto) {
        List<String> data = requestDto.getData() == null ? List.of() : requestDto.getData();
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        List<String> alphabetChars = new ArrayList<>();
        int sum = 0;

        for (String item : data) {
            if (item == null || item.isBlank()) {
                continue;
            }

            if (NUMBER_PATTERN.matcher(item).matches()) {
                int number = Integer.parseInt(item);
                sum += number;
                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            } else if (isAlphabetic(item)) {
                alphabets.add(item.toUpperCase());
                for (char c : item.toCharArray()) {
                    if (Character.isLetter(c)) {
                        alphabetChars.add(String.valueOf(c));
                    }
                }
            } else {
                for (char c : item.toCharArray()) {
                    if (!Character.isLetterOrDigit(c)) {
                        specialCharacters.add(String.valueOf(c));
                    }
                }
            }
        }

        String concatString = buildConcatString(alphabetChars);

        return new BfhlResponseDto(
                true,
                FULL_NAME + "_17091999",
                EMAIL,
                ROLL_NUMBER,
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString
        );
    }

    private boolean isAlphabetic(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return !value.isEmpty();
    }

    private String buildConcatString(List<String> alphabetChars) {
        StringBuilder builder = new StringBuilder();
        for (int i = alphabetChars.size() - 1; i >= 0; i--) {
            char ch = alphabetChars.get(i).toLowerCase().charAt(0);
            builder.append(i % 2 == 1 ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
        }
        return builder.toString();
    }
}
