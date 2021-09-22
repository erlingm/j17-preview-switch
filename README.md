# j17-preview-switch
Test of Java 17 switch with pattern matching

An example run:



```
Checked value of "1957" is "Integer: 1957"
Checked value of "Erling" is "Some other type : class java.lang.String, and value Erling"
Checked value of "null" is "No defined value"
Checked value of "3.141592653589793" is "Double: 3.141592653589793"
Checked value of "9223372036854775807" is "Long: 9223372036854775807"
Checked value of "3.14" is "Float: 3.14"
Checked value of "THREE" is "Enum: THREE"
Checked value of "6.0" is "Double: 6.0"
Checked value of "Miss" is "GenderPrefix.Miss"
Checked value of "Mr." is "GenderPrefix.Mr."
Checked value of "1957-08-30" is ", AND Supports DAYS: 30. Aug 1957"
Checked value of "2021-09-23T01:02:53.138274800" is "Supports HOURS: 23. sep. 2021 kl. 1:02:53"
Checked value of "2021-09-22T23:02:53.140273300Z[UTC]" is "Supports HOURS: 22. Sep 2021 kl. 23:02:53 - UTC - Coordinated Universal Time"
Checked value of "2021-09-22T13:02:53.140273300-10:00[US/Hawaii]" is "Supports HOURS: 22. Sep 2021 kl. 13:02:53 - US/Hawaii - Hawaii-Aleutian Standard Time"
Checked value of "2021-09-22T13:02:53.140273300-10:00[Pacific/Honolulu]" is "Supports HOURS: 22. Sep 2021 kl. 13:02:53 - Pacific/Honolulu - Hawaii-Aleutian Standard Time"
```