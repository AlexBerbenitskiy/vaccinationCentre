package com.example.vaccinationcentre;


    public class Utilities {

        public static String numbersOnly = "[0-9]+";

        public static boolean max15Chars(String string) {
            return (string.length() <= 15) ? true : false;
        }

        public static boolean max30Chars(String string) {
            return (string.length() <= 30) ? true : false;
        }

        public static boolean max60Chars(String string) {
            return (string.length() <= 60) ? true : false;
        }

        public static boolean validEircode(String eircode) {
            return (eircode.length() == 7)? true : false;

            }



        //This method was discovered from https://stackoverflow.com/questions/20385963/validate-a-string-pps-number/20386061
        public static boolean validPPS(String ppsNumber) {
            if (ppsNumber.matches("\\d{7}[A-Z]{1,2}")) { // \d means 'a digit 1-9'
                return true;
            } else {
                return false;
            }
        }


        public static boolean validBoothId(String boothId) {
            if (boothId.matches("[A-Z]\\d")) { // \d means 'a digit 1-9'
                return true;
            } else {
                return false;
            }
        }


        public static boolean VCId(String VCId) {
            if (VCId.matches("[A-Z]\\d{2,3}")) { // \d means 'a digit 1-9'
                return true;
            } else {
                return false;
            }
        }


        public static boolean onlyContainsNumbers(String text) {
            if (text != null) {
                return (text.matches(numbersOnly));
            }
            return false;
        }

    }










