/*
	problem 551
	You are given a string representing an attendance record for a student.
	The record only contains the following three characters:
	'A' : Absent.
	'L' : Late.
	'P' : Present.
	A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
	or more than two continuous 'L' (late).
	You need to return whether the student could be rewarded according to his attendance record.
	Example 1:
		Input: "PPALLP"
		Output: True
	Example 2:
		Input: "PPALLL"
		Output: False
*/

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        return !(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"));
    }
    
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;

        for(char c : s.toCharArray()) {
            if(c == 'L') {
                countL++;
                if(countL >= 3) {
                    return false;
                }
            } else {
                countL = 0;
                if(c == 'A') {
                    countA++;
                    if(countA > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


}