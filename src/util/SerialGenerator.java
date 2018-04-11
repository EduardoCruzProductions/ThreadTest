package util;

import java.util.Random;

public class SerialGenerator {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String upperAlphabet = alphabet + alphabet.toUpperCase();
    private char divisorCharactere = '-';

    /**
     * This method returns a sequence of randomic numbers.
     * @param n_groups The number of groups.
     * @param n_char The number of characteres of a group.
     * @return A String with the groups of charactere, divide by divisorCharactere.
     */
    public String generateNumberSerial(int n_groups, int n_char) {

        String serial = "";
        Random r = new Random();

        for (int i = 0; i < n_groups; i++) {

            for (int j = 0; j < n_char; j++) {

                serial += Integer.toString(r.nextInt(10));

            }

            if (i < (n_groups - 1)) {

                serial += "-";

            }
        }

        return serial;

    }

    /**
     * This method returns a sequence of randomic numbers and letters. <br/>
     * The probability of letters appears is fixed on 50%.
     * @param n_groups The number of groups.
     * @param n_char The number of characteres of a group.
     * @param isCaseSensitive Allow case distinct.
     * @return A String with the groups of charactere, divide by divisorCharactere.
     */
    public String generateAlphaNumericSerial(int n_groups, int n_char, boolean isCaseSensitive) {

        String serial = "";
        Random r = new Random();

        for (int i = 0; i < n_groups; i++) {

            for (int j = 0; j < n_char; j++) {

                if (r.nextInt(10) % 2 == 0) {

                    if (isCaseSensitive) {

                        serial += upperAlphabet.charAt(r.nextInt(upperAlphabet.length()));

                    } else {

                        serial += alphabet.charAt(r.nextInt(alphabet.length()));

                    }

                } else {

                    serial += Integer.toString(r.nextInt(10));

                }

            }

            if (i < (n_groups - 1)) {

                serial += divisorCharactere;

            }
        }

        return serial;

    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getUpperAlphabet() {
        return upperAlphabet;
    }

    public void setUpperAlphabet(String upperAlphabet) {
        this.upperAlphabet = upperAlphabet;
    }

    public char getDivisorCharactere() {
        return divisorCharactere;
    }

    public void setDivisorCharactere(char divisorCharactere) {
        this.divisorCharactere = divisorCharactere;
    }

}
