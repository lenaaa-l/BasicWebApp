package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Lena";
        } else if (query.contains("plus")) {
            String[] temp = query.split(" ");
            return "" + Arrays.stream(temp).filter(x -> x.chars().allMatch( Character::isDigit)).mapToInt(Integer::parseInt).sum();
        } else if (query.contains("largest")){
            String[] temp = query.split(" ");
            return "" + Arrays.stream(temp).map(x->x.replace(",", "")).filter(x -> x.chars().allMatch(Character::isDigit)).mapToInt(Integer::parseInt).max();
        }

        else { // TODO extend the programm here
            return "";
        }
    }
}
